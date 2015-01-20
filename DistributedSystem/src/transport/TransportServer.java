package transport;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	private Map<Integer, PublicKey> publicKeyMapping;
	private Server myServer;
	private ServerSocket serverSocket;
	
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
		publicKeyMapping = new HashMap<Integer, PublicKey>();
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
		
		ObjectInputStream in = null;
	    try {
		    in = new ObjectInputStream(clientSocket.getInputStream());
		    
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		//try to write in the stream
		try {
			int command = (Integer) in.readObject();
			System.out.println("Request for command " + command);
			int id;
			switch(command){
				case JOIN:
					//first read the public key
					PublicKey publicKey = (PublicKey) in.readObject();
					//assign id to the incoming client
					id = maxId;
					maxId++;
					clientMapping.put(id, clientSocket);
					ipMapping.put(clientSocket.getInetAddress(), id);
					publicKeyMapping.put(id, publicKey);
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
					
					publicKeyMapping.remove(id);
					
					clientOutputStream.get(id).close();
					clientOutputStream.remove(id);
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public void notifyKey(int id, SecretKey dek, SecretKey[] keks) {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance(client.Client.CHIPER_TRANSFORMATION);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			e1.printStackTrace();
		}

		Socket clientSocket = clientMapping.get(id);
		PublicKey publicKey = publicKeyMapping.get(id);
		
		ObjectOutputStream outputStream = null;
	    try {
	    	outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
		    clientOutputStream.put(id, outputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}
	    	    
	    try {
	    	System.out.println("Sending data to client: " + clientSocket.getRemoteSocketAddress());
	    	System.out.println("Sending Dek....");
	    	//send dek encrypted
	    	byte[] encryption = MyCrypto.encryptKeyAsimmetric(dek, cipher, publicKey);
			outputStream.writeObject(encryption);
			
			System.out.println("Sending "+ keks.length + " keys...");
			outputStream.writeInt(keks.length);
			
			//send all the kek (encrypted)
		    for (SecretKey kek : keks) {
		    	encryption = MyCrypto.encryptKeyAsimmetric(kek, cipher, publicKey);
			    outputStream.writeObject(encryption);
			}
		    
			System.out.println("keks sent");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendDekEncrypted(byte[] encryption, Set<Integer> ids, int index, int leavingId) {
		for (Integer id : ids) {
			System.out.println("Sending new dek...");
			sendKeyEncripted(encryption, id, index);
		}
	}
	
	public void sendKekEncrypted(byte[] encryption, Set<Integer> ids, int index, int leavingId) {
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

	public void setKekSending(Set<Integer> ids, int leavingId) {
		//tells each client how many kek is going to received
		for (Integer id : ids) {
			
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
