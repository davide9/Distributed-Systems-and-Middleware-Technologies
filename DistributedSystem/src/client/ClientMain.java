package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Insert the server name...");
		String serverName = in.nextLine();
		Client client1 = new Client(serverName);
		System.out.println("Client 1 is going to join...");
		client1.join();
		client1.listen();
		System.out.println("Start chatting");
		client1.startMessage();
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
