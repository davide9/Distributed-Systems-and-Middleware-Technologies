package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import common.CommunicationMessage;

public class Server03 implements MessageListener {

	static JMSContext jmsContext;
	
	public static void main(String[] args) throws NamingException, IOException {
		// TODO Auto-generated method stub
		Context initialContext = Server03.getContext();
		Server03 server = new Server03();
		jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		
		String subscribeTopicName ="Topic01";
		Topic subscribeDestination = (Topic) initialContext.lookup(subscribeTopicName);
		
		JMSConsumer consumer = jmsContext.createConsumer(subscribeDestination,"pippo <> 'low' and pippo <> 'high'");
		consumer.setMessageListener(server);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		bufferedReader.readLine();
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
			Queue replyToQueue = (Queue)msg.getJMSReplyTo();
			CommunicationMessage commMsg = msg.getBody(CommunicationMessage.class);
			System.out.println("Server received -> [username: " + commMsg.getName() + " | message: " + commMsg.getMessage() + "]");
			jmsContext.createProducer().send(replyToQueue, new CommunicationMessage(commMsg.getName(), "Server 03 echo - " + commMsg.getMessage()));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
