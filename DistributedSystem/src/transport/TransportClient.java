
package transport;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;

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
	private ObjectOutputStream out;
	
	protected final static int CLIENT_PORT = 7777;

	public TransportClient(Client client, String serverName){
		myClient = client;
		serverSocket = null;
		inStreamServer = null;
		this.serverName = serverName;
		out = null;
	}

	public void notifyServerJoin() {
		try {
			serverSocket = new Socket(serverName, TransportServer.SERVER_PORT);
			out = new ObjectOutputStream(serverSocket.getOutputStream());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		//prepare the cipher to use
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance(Client.CHIPER_TRANSFORMATION);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		
		try {

			System.out.println("joining the server.....");
			out.writeObject(TransportServer.JOIN);
			
			//sending publicKey
			out.writeObject(myClient.getPublicKey());
			
			out.reset();
			
			inStreamServer = new ObjectInputStream(serverSocket.getInputStream());

			//reciving dek on join
			receiveDekOnjoin(cipher);

			//reciving keks
			receiveKekOnJoin(cipher);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void notifyServerLeave() throws UnknownHostException{
		System.out.println("trying to leave");
		try {			
			out.writeObject(TransportServer.LEAVE);
			
			out.flush();
			out.close();
			serverSocket.close();
			
			System.out.println("left");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int listen() throws UnknownHostException, EOFException {
		if(serverSocket != null){
			Cipher cipher = null;
			
			try {
				cipher = Cipher.getInstance(server.Server.CHIPER_TRANSFORMATION);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			}
			try{
				//manage the receving of dek and its setting
				//TODO togliere questo synchronized
				//synchronized (this) {
				int result = receiveDekOnLeave(cipher, inStreamServer);
				
				if(result == -1)
					return -1;
			
				//manage the receving of kek and its setting
				result = reveiveKeksOnLeave(cipher, inStreamServer);
				
				
				if(result == -1)
					return -1;
				//}
			}catch(Exception e){
				System.out.println(e);
				return -1;
			}
		}
		else{
			throw new UnknownHostException();
		}
		
		return 0;
		
	}

	private void receiveDekOnjoin(Cipher cipher) {
		try {
			byte[] encrypted = (byte[]) inStreamServer.readObject();
			SecretKey newDek = MyCrypto.decryptKeyAsimmetric(encrypted, cipher, myClient.getPrivateKey());
			myClient.setDek(newDek);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void receiveKekOnJoin(Cipher cipher) {
		try {
			int keksSize = (int) inStreamServer.readInt();
			if(keksSize != server.Server.numOfBit){
				throw new Error();
			}else{
				SecretKey[] keks = new SecretKey[server.Server.numOfBit];
				System.out.println("I should received " + keksSize + " keys");
				for(int i = 0; i < keksSize; i++){
					System.out.println("I'm going to received kek number " + i);
					byte[] encrypted = (byte[]) inStreamServer.readObject();
					SecretKey newKek = MyCrypto.decryptKeyAsimmetric(encrypted, cipher, myClient.getPrivateKey());
					
					keks[i] = newKek;
					System.out.println("Receved kek " + i);
				}	
				myClient.setKeks(keks);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private int receiveDekOnLeave(Cipher cipher, ObjectInputStream inStreamServer2) {
		try {
			//getting index of the key to use
			int index = (Integer) inStreamServer.readObject();
			System.out.println("Getting the index of the key to use...." + index);
			
			//receiving dek encrypted
			byte[] encryption = (byte[]) inStreamServer.readObject();
			
			SecretKey keyToUse = myClient.getKek(index);
			SecretKey newDek = MyCrypto.decryptKey(encryption, cipher, keyToUse);
			myClient.setDek(newDek);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("catched it");
			return -1;
		} 
		return 0;
	}
	
	private int reveiveKeksOnLeave(Cipher cipher, ObjectInputStream inStreamServer2) {
		try {
			//received number of kek to change
			int numOfKeyToReceive = (Integer) inStreamServer.readObject();
			System.out.println("I'm going to receive " + numOfKeyToReceive + " keks...");
			
			for(int i = 0; i < numOfKeyToReceive; i++){
				//receive index of kek to change
				int index = (Integer) inStreamServer.readObject();
				
				//receive kek encrypted
				byte[] encryption = (byte[]) inStreamServer.readObject();
				
				byte[] firstDecription = MyCrypto.decrypt(encryption, cipher, myClient.getDek());
				
				SecretKey newKek = MyCrypto.decryptKey(firstDecription, cipher, myClient.getKek(index));
				
				myClient.setKek(newKek, index);
				
				System.out.println("Received key with index: " + index + " " + i + "/" + numOfKeyToReceive);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("catched it");
			return -1;
		} 
		return 0;
	}
}
