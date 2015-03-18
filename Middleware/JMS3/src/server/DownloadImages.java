package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

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

public class DownloadImages implements MessageListener {

	private static String publishQueueName = "Queue4-5";
	private static String subscribeQueueName = "Queue3-4";
	
	public static void main(String[] args) throws IOException, NamingException {
		
		Context initialContext = getContext();
		
		DownloadImages chat = new DownloadImages();

				
		Queue subscribeQueue = (Queue) initialContext.lookup(subscribeQueueName);
		Queue publishQueue = (Queue) initialContext.lookup(publishQueueName);
		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		jmsContext.createConsumer(subscribeQueue).setMessageListener(chat);

		JMSProducer jmsProducer = jmsContext.createProducer();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String msgToSend = null;
		while (true) {
			msgToSend = bufferedReader.readLine();
			if (msgToSend.equalsIgnoreCase("exit")) {
				jmsContext.close();
				System.exit(0);
			}
			else {
				jmsProducer.send(publishQueue, "URL = " + msgToSend );
			}
		}

	}
	
	private static Context getContext() throws NamingException {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		props.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(props);
	}

	public void onMessage(Message msg) {
		try {
			System.out.println(msg.getBody(String.class));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
