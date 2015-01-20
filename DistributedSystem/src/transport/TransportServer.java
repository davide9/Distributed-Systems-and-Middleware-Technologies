package transport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import myCrypto.MyCrypto;
import centralizedFlatTable.CentralizedFlatTable;
import server.Server;

public class TransportServer {
	
	private Map<Integer, Socket> clientMapping;
	private Map<Integer, ObjectOutputStream> clientOutputStream;
	private Map<InetAddress, Integer> ipMapping;
	private Server myServer;
	ServerSocket serverSocket;
	
	private int maxId;

	
	protected final static int SERVER_PORT = 4448;
	public static final int JOIN = 0;
	public static final int LEAVE = 1;
	
	
	
	
	public TransportServer(Server server){
		myServer = server;
		maxId = 0;
		clientMapping = new HashMap<Integer, Socket>();
		ipMapping = new HashMap<InetAddress, Integer>();
		clientOutputStream = new HashMap<Integer, ObjectOutputStream>();
	}

	public void setUp(){
		Socket clientSocket = null;
		try {
			System.out.println("Initialize server on port" + SERVER_PORT);
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Server is running at ip: " + serverSocket.getInetAddress().getHostAddress());
			System.out.println("Server name: " + serverSocket.getInetAddress().getHostName());
			clientSocket = serverSocket.accept();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	    while(true){
			try {
				handleRequest(clientSocket);
				System.out.println("waiting new request");
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
	
	private void handleRequest(Socket clientSocket) {
		
		BufferedReader in = null;
	    try {
		    in = new BufferedReader(
		        new InputStreamReader(clientSocket.getInputStream()));
		    
		} catch (IOException e) {
			e.printStackTrace();
		}

		String inputLine;
		
		//try to write in the stream
		try {
			inputLine = in.readLine();
			int command = Integer.parseInt(inputLine);
			int id;
			System.out.println("Request for command " + command);
			switch(command){
				case JOIN:
					//assign id to the incoming client
					id = maxId;
					maxId++;
					clientMapping.put(id, clientSocket);
					ipMapping.put(clientSocket.getInetAddress(), id);
					//call the join function
					myServer.join(id);
					break;
				case LEAVE:
					System.out.println("request from " + clientSocket.getRemoteSocketAddress().toString());
					id = ipMapping.get(clientSocket.getInetAddress());
					System.out.println("Request for leaving by id " +id );
					myServer.leave(id);
					
					ipMapping.remove(id);
					
					clientMapping.get(id).close();
					clientMapping.remove(id);
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void notifyKey(int id, SecretKey dek, SecretKey[] keks) {
		Socket clientSocket = null;
		clientSocket = clientMapping.get(id);
		
		ObjectOutputStream outputStream = null;
	    try {
	    	outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    clientOutputStream.put(id, outputStream);
	    
	    try {
	    	System.out.println("Sending data to client: " + clientSocket.getRemoteSocketAddress());
	    	System.out.println("Sending Dek....");
			outputStream.writeObject(dek);
			
			System.out.println("Sending "+ keks.length + " keys...");
			outputStream.writeInt(keks.length);
			
		    for (SecretKey kek : keks) {
			    outputStream.writeObject(kek);
			}
			System.out.println("keks sent");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}

	/**
	 * 
	 * @param encryption
	 * @param ids
	 * @param index
	 * @param leavingId
	 */
	public void sendDekEncrypted(byte[] encryption, List<Integer> ids, int index, int leavingId) {
		for (Integer id : ids) {
			
			if(CentralizedFlatTable.isCommonKey(id, leavingId, index)){
				continue;
			}
			
			System.out.println("Sending new dek...");
			sendKeyEncripted(encryption, id, index);
		}
	}
	
	public void sendKekEncrypted(byte[] encryption, List<Integer> ids, int index, int leavingId) {
		for (Integer id : ids) {
			
			if( ! CentralizedFlatTable.isCommonKey(id, leavingId, index)){
				continue;
			}
			
			System.out.println("Sending new kek...");
			sendKeyEncripted(encryption, id, index);
		}
	}
	
	private void sendKeyEncripted(byte[] encryption, int id, int index){
		//otherwise send the data
		Socket clientSocket = clientMapping.get(id);
		System.out.println("Sending to " + clientSocket.getRemoteSocketAddress());
		ObjectOutputStream outputStream = clientOutputStream.get(id);
	    
	    try {
	    	//sending the index of the key used to encrypt
	    	System.out.println("Index used to encrypt is " + index);
			outputStream.writeObject(index);
			
			//sending the key
			outputStream.writeObject(encryption);
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setKekSending(List<Integer> ids, int leavingId) {
		//tells each client how many kek is going to received
		for (Integer id : ids) {
			
			Socket clientSocket = clientMapping.get(id);
			ObjectOutputStream outputStream = clientOutputStream.get(id);
			
			System.out.println("number of keks to change = " + CentralizedFlatTable.howManyInCommon(id, leavingId));
			
			try {
				outputStream.writeObject(CentralizedFlatTable.howManyInCommon(id, leavingId));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
