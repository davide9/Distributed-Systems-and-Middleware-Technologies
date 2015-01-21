package client;

public class ClientMain {

	public static void main(String[] args) {
		Client client1 = new Client();
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
