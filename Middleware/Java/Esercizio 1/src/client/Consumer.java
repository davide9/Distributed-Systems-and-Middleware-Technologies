package client;

import support.TimeWS;
import support.TimeWSImplService;

public class Consumer {

	public static void main(String[] args) {
		
		TimeWSImplService service = new TimeWSImplService();
		TimeWS port = service.getPort(TimeWS.class);
		
		System.out.println("Time as string -> " + port.getTimeAsString());
		System.out.println("Time as elapsed -> " + port.getTimeAsElapsed());

	}

}
