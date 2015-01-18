package client;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;

import transport.TransportClient;

public class Client {
	private SecretKey dek;
	private List<SecretKey> keks;
	private TransportClient transport;
	
	public Client(){
		keks = new ArrayList<SecretKey>();
		transport = new TransportClient(this);
	}

	public void join(){
		transport.notifyServerJoin();
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
		System.out.println(dek.toString());
	}
	
	public void setKeks(List<SecretKey> keks){
		System.out.println("Setting kek keys....");
		this.keks.clear();
		for (SecretKey kek : keks) {
			System.out.println(kek.toString());
			this.keks.add(kek);
		}
		
	}
}
