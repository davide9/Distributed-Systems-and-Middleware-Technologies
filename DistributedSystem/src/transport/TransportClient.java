package transport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;

import client.Client;

public class TransportClient {
	private Socket serverSocket;
	private String serverName;
	private Client myClient;
	
	protected final static int CLIENT_PORT = 7777;

	public TransportClient(Client client){
		myClient = client;
		serverSocket = null;
		serverName = new String("0.0.0.0");
	}

	public void notifyServerJoin() {
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			serverSocket = new Socket(serverName, TransportServer.SERVER_PORT);
			out = new PrintWriter(serverSocket.getOutputStream(), true);
			in = new BufferedReader(
			        new InputStreamReader(serverSocket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("joining the server.....");
		out.println(TransportServer.JOIN);
		ObjectInputStream inStream = null;
		try {
			inStream = new ObjectInputStream(serverSocket.getInputStream());
			//reciving dek
			myClient.setDek((SecretKey) inStream.readObject());
			List<SecretKey> list = new ArrayList<SecretKey>();

			//reciving keks
			int keksSize = Integer.parseInt(in.readLine());
			System.out.println("I should received " + keksSize + " keys");
			for(int i = 0; i < keksSize; i++){
				System.out.println("I'm going to received kek number " + i);
				SecretKey kek = (SecretKey) inStream.readObject();
				list.add(kek);
				System.out.println("Receved kek " + i + "/" + keksSize);
			}
			System.out.println("out of while");
			myClient.setKeks(list);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public void notifyServerLeave() throws UnknownHostException{
		if(serverSocket != null){
			PrintWriter out = null;
			BufferedReader in = null;
			try {
				out = new PrintWriter(serverSocket.getOutputStream(), true);
				in = new BufferedReader(
				        new InputStreamReader(serverSocket.getInputStream()));
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			out.println(TransportServer.LEAVE);
		}
		else{
			throw new UnknownHostException();
		}

	}
}
