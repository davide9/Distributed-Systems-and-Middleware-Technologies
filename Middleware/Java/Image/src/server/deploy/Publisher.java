package server.deploy;

import javax.xml.ws.Endpoint;

import server.impl.ImageWSImpl;

public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9999/ImageWS", new ImageWSImpl());
		System.out.println("ImageWS has been deployed");
	}

}
