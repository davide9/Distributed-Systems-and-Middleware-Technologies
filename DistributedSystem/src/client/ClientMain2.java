package client;

public class ClientMain2 {

	public static void main(String[] args) {
		Client client1 = new Client();
		System.out.println("Client 2 is going to join...");
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
