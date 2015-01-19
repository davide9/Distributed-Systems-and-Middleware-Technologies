package transport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.SecretKey;

import server.Server;

public class TransportServer {
	
	private Map<Integer, Socket> clientMapping;
	private Map<String, Integer> ipMapping;
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
		ipMapping = new HashMap<String, Integer>();
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
		
		PrintWriter out = null;
		BufferedReader in = null;
	    try {
			out =
				new PrintWriter(clientSocket.getOutputStream(), true);
			
		    in = new BufferedReader(
		        new InputStreamReader(clientSocket.getInputStream()));
		    
		} catch (IOException e) {
			e.printStackTrace();
		}

		String inputLine, outputLine;
		
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
					ipMapping.put(clientSocket.getRemoteSocketAddress().toString(), id);
					//call the join function
					myServer.join(id);
					break;
				case LEAVE:
					id = ipMapping.get(clientSocket.getRemoteSocketAddress().toString());
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
	    
	    
	    try {/*verificare
	    	System.out.println("Sending id");
	    	outputStream.writeInt(id);
	    	*/
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

	public void sendDekEncrypted(byte[] encryption, List<Integer> ids, int index) {
		for (Integer id : ids) {
			Socket clientSocket = clientMapping.get(id);
			
			ObjectOutputStream outputStream = null;
		    try {
		    	outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		    
		    try {
		    	/*verificare
		    	System.out.println("Sending id");
		    	outputStream.writeInt(id);
		    	*/
		    	System.out.println("Index used to encrypt is " + index);
				outputStream.writeInt(index);
				
				System.out.println("Sending dek encrypted...");
				outputStream.writeObject(encryption);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
