package server;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import messages.MessageNameKey;

import com.smartfile.api.BasicClient;

public class DownloadImages implements MessageListener {

	private static String publishQueueName = "Queue4-5";
	private static String subscribeQueueName = "Queue3-4";

	private JMSProducer jmsProducer;
	
	private Queue publishQueue;
	private Queue subscribeQueue;
	
	public DownloadImages() throws NamingException{
		
		Context initialContext = getContext();
				
		Queue subscribeQueue = (Queue) initialContext.lookup(subscribeQueueName);
		Queue publishQueue = (Queue) initialContext.lookup(publishQueueName);
		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		jmsContext.createConsumer(subscribeQueue).setMessageListener(this);

		JMSProducer jmsProducer = jmsContext.createProducer();
	}

	public void onMessage(Message msg) {
		MessageNameKey mess = null;
		try {
			mess = msg.getBody(MessageNameKey.class);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String src = mess.getName();
		Image image = null;
		String fileName = src;
	    File file = null;
		try {
		    URL url = new URL(src);
		    image = ImageIO.read(url);
		    file = File.createTempFile(fileName, "png");
		    ImageIO.write((RenderedImage) image, "png", file);
		} catch (IOException e) {
			System.out.println("sono cazzi");
		}
		
		BasicClient client = null;
		try {
			client = new BasicClient("5Pke4WiJ8uzaxCPEQ59P6ACUwm89iI", "fVasCSf4etDHxv7mCOZlSWrJYGdk1j");
			//client.setApiUrl("app.smartfile.com");
			client.post(endpoint, id, file);
		}
	}

	public static void main(String[] args) throws IOException, NamingException {
		
		DownloadImages chat = new DownloadImages();
		
	}
	
	private static Context getContext() throws NamingException {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		props.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(props);
	}
}
