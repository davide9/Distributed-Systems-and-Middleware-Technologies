package transport;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import myCrypto.MyCrypto;
import client.Client;

public class TransportClient {
	private Socket serverSocket;
	private String serverName;
	private Client myClient;
	private ObjectInputStream inStreamServer;
	private PrintWriter out;
	
	protected final static int CLIENT_PORT = 7777;

	public TransportClient(Client client){
		myClient = client;
		serverSocket = null;
		serverName = new String("0.0.0.0");
		inStreamServer = null;
		out = null;
	}

	public void notifyServerJoin() {
		try {
			serverSocket = new Socket(serverName, TransportServer.SERVER_PORT);
			out = new PrintWriter(serverSocket.getOutputStream(), true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("joining the server.....");
		out.println(TransportServer.JOIN);
		
		try {
			inStreamServer = new ObjectInputStream(serverSocket.getInputStream());

			//reciving dek
			myClient.setDek((SecretKey) inStreamServer.readObject());

			//reciving keks
			int keksSize = (int) inStreamServer.readInt();
			if(keksSize != server.Server.numOfBit){
				throw new Error();
			}else{
				SecretKey[] keks = new SecretKey[server.Server.numOfBit];
				System.out.println("I should received " + keksSize + " keys");
				for(int i = 0; i < keksSize; i++){
					System.out.println("I'm going to received kek number " + i);
					SecretKey kek = (SecretKey) inStreamServer.readObject();
					keks[i] = kek;
					System.out.println("Receved kek " + i);
				}
				myClient.setKeks(keks);
			}
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public void notifyServerLeave() throws UnknownHostException{
		System.out.println("trying to leave");
		try {
			serverSocket = new Socket(serverName, TransportServer.SERVER_PORT);
			out = new PrintWriter(serverSocket.getOutputStream(), true);
			out.println(TransportServer.LEAVE);
			System.out.println("left");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listen() throws UnknownHostException, EOFException {
		if(serverSocket != null){
			try {

				//getting index of the key to use
				int index = inStreamServer.readInt();
				System.out.println("Getting the index of the key to use....");
				//reciving dek encrypted
				byte[] encryption = (byte[]) inStreamServer.readObject();
				
				SecretKey keyToUse = myClient.getKek(index);
				try {
					SecretKey newDek = MyCrypto.dencryptKey(encryption, Cipher.getInstance(server.Server.CHIPER_TRANSFORMATION), keyToUse);
					myClient.setDek(newDek);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					e.printStackTrace();
				}
			} catch (IOException | ClassNotFoundException e) {
				//e.printStackTrace();
			}
		}
		else{
			throw new UnknownHostException();
		}
		
	}
}
