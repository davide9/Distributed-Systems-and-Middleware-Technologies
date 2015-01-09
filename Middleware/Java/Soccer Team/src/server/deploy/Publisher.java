package server.deploy;

import javax.xml.ws.Endpoint;

import server.impl.TeamWSImpl;

public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9999/TeamWS", new TeamWSImpl());
		System.out.println("The service has been deployed...");
	}

}
