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
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import common.CommunicationMessage;


public class Client implements MessageListener{

	public static void main(String[] args) throws NamingException, IOException, JMSException {
		
		String publishTopicName = "Topic01";
		
		Context initialContext = Client.getContext();
		Client client = new Client();
		
		Topic publishTopic = (Topic) initialContext.lookup(publishTopicName);
		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		
		//Queue subscribeQueue = (Queue) initialContext.lookup(subscribeQueueName);
		Queue subscribeQueue = jmsContext.createTemporaryQueue();
		
		jmsContext.createConsumer(subscribeQueue).setMessageListener(client);
		
		JMSProducer jmsProducer = jmsContext.createProducer().setJMSReplyTo(subscribeQueue);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String msgToSend = null;
		System.out.println("Please provide a name-> ");
		String username = bufferedReader.readLine();
		String priority = null;
		while (true) {
			System.out.println("Please provide your message (or exit) -> ");
			msgToSend = bufferedReader.readLine();
			if (msgToSend.equalsIgnoreCase("exit")) {
				jmsContext.close();
				System.exit(0);
			}
			else {
				System.out.println("Please provide a priority value (low, high, default)");
				priority = bufferedReader.readLine();
				ObjectMessage objMessage = jmsContext.createObjectMessage();
				CommunicationMessage message = new CommunicationMessage(username, msgToSend);
				objMessage.setObject(message);
				objMessage.setStringProperty("pippo", priority);
				jmsProducer.send(publishTopic, objMessage);
				//jmsProducer.setProperty("pippo", priority).send(publishTopic, message);
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

	@Override
	public void onMessage(Message msg) {
		try {
			CommunicationMessage commMsg = msg.getBody(CommunicationMessage.class);
			System.out.println("Client Received -> [username: " + commMsg.getName() + " | message: " + commMsg.getMessage() + "]");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
