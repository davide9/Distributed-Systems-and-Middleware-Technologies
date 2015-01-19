package client;

import java.io.EOFException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;

import transport.TransportClient;

public class Client {
	private SecretKey dek;
	private SecretKey[] keks;
	private TransportClient transport;
	
	public Client(){
		keks = new SecretKey[server.Server.numOfBit];
		transport = new TransportClient(this);
	}

	public void join(){
		transport.notifyServerJoin();
	}
	
	public void listen(){
		try {
			while(true){
				try{
					transport.listen();
				}catch(EOFException e){
					
				}
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
		System.out.println(dek.toString());
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
}
