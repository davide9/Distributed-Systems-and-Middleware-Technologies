package client;

import java.util.Scanner;

public class ClientMain2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Insert the server name...");
		String serverName = in.nextLine();
		Client client1 = new Client(serverName);
		System.out.println("Client 1 is going to join...");
		client1.join();
		System.out.println("client 2 is leaving.....");
		client1.startMessage();
		client1.leave();
		/*
		Client client2 = new Client();
		System.out.println("Client 2 is going to join...");
		client2.join();
		
		Client client3 = new Client();
		System.out.println("Client 3 is going to join...");
		client3.join();
		
		client1.leave();
		*/
		while(true){
			
		}
	}

}
