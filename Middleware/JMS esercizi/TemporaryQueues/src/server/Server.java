package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import common.CommunicationMessage;

public class Server implements MessageListener {
	
	static JMSContext jmsContext;

	public static void main(String[] args) throws NamingException, IOException {
		
		Context initialContext = Server.getContext();
		Server server = new Server();
		
		ConnectionFactory cf = (ConnectionFactory)initialContext.lookup("java:comp/DefaultJMSConnectionFactory");
		Queue queue01 = (Queue)initialContext.lookup("Queue01");
		
		jmsContext = cf.createContext();
		jmsContext.createConsumer(queue01).setMessageListener(server);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Waiting for messages...");
		System.out.println("input 'exit' to close");
		
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
		
		try {
			Queue replyToQueue = (Queue) msg.getJMSReplyTo();
			CommunicationMessage commMsg = msg.getBody(CommunicationMessage.class);
			System.out.println("Received -> username("+commMsg.getUsername()+") - message( " + commMsg.getMessage()+")");
			jmsContext.createProducer().send(replyToQueue, new CommunicationMessage("server", "echo client(" + commMsg.getUsername() + ") - message(" + commMsg.getMessage() +")"));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
