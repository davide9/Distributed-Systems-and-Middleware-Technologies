package client;

import java.net.UnknownHostException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import transport.TransportClient;

public class Client {
	
	public static final String ALGORITHM = "RSA";

	public static final String CHIPER_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
	
	private SecretKey dek;
	private SecretKey[] keks;
	private TransportClient transport;
	private PrivateKey myKey;
	private PublicKey publicKey;
	
	public Client(){
		keks = new SecretKey[server.Server.numOfBit];
		
		createAsimmetricKey();
		
		transport = new TransportClient(this);
	}

	public void join(){
		transport.notifyServerJoin();
	}
	
	public void listen(){
		try {
			System.out.println("waiting....");
			while(true){
				transport.listen();
				System.out.println("waiting....");
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}	
	}
	
	public void leave(){
		try {
			transport.notifyServerLeave();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void setDek(SecretKey newDek){
		System.out.println("Setting dek key....");
		dek = newDek;
		System.out.println(dek);
	}
	
	public void setKeks(SecretKey[] keks){
		System.out.println("Setting kek keys....");
		for(int i = 0; i < this.keks.length; i++){
			this.keks[i] = keks[i];
		}
	}
	
	public void setKek(SecretKey kek, int index){
		this.keks[index] = kek;
	}
	
	public SecretKey getKek(int index){
		return keks[index];
	}

	public SecretKey getDek() {
		return dek;
	}
	
	public PublicKey getPublicKey() {
		return this.publicKey;
	}
	
	public PrivateKey getPrivateKey() {
		return this.myKey;
	}
	
	private void createAsimmetricKey() {
		KeyPairGenerator gen = null;
		try {
			gen = KeyPairGenerator.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		KeyPair pair = gen.generateKeyPair();
		
		myKey = pair.getPrivate();
		publicKey = pair.getPublic();
	}



	

}
