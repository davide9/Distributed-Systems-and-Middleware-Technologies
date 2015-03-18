package client;

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
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import common.CommunicationMessage;

public class Client implements MessageListener {

	public static void main(String[] args) throws NamingException, IOException {
		// TODO Auto-generated method stub

		String publishQueueName = "Queue01";
		String subscribeQueueName = "Queue02";
		
		Client listener = new Client();
		
		Context initialContext = Client.getContext();
		
		ConnectionFactory cf = (ConnectionFactory)initialContext.lookup("java:comp/DefaultJMSConnectionFactory");
		Queue queue01 = (Queue)initialContext.lookup("Queue01");
		//Queue queue02 = (Queue)initialContext.lookup("Queue02");
		
		
		JMSContext jmsContext = cf.createContext();
		Queue queue02 = jmsContext.createTemporaryQueue();
		jmsContext.createConsumer(queue02).setMessageListener(listener);
		JMSProducer producer = jmsContext.createProducer();
		producer.setJMSReplyTo(queue02);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please provide a name -> ");
		String username = bufferedReader.readLine();
		String message = null;
		while (true) {
			System.out.println("Please provide a message (or exit) ->");
			message = bufferedReader.readLine();
			
			if (message.equalsIgnoreCase("exit")) {
				jmsContext.close();
				System.out.println("Goodbye");
				return;
			}
			
			producer.send(queue01, new CommunicationMessage(username, message));
			
		}
		
		
	}
	
	private static Context getContext() throws NamingException {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		props.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(props);
	}

	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		
		try {
			CommunicationMessage commMessage = msg.getBody(CommunicationMessage.class);
			System.out.println("Received -> username("+commMessage.getUsername()+") - message(+ " + commMessage.getMessage()+")");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		if (msg instanceof ObjectMessage) {
			try {
				ObjectMessage objMsg = (ObjectMessage)msg;
				CommunicationMessage commMessage = (CommunicationMessage)objMsg.getObject();
				System.out.println("Received -> username("+commMessage.getUsername()+") - message(+ " + commMessage.getMessage()+")");
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		
	}

}
