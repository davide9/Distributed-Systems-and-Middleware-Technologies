package producer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import common.CommunicationMessage;

public class Producer {

	public static void main(String[] args) throws NamingException, IOException, JMSException {
		
		Queue queue01 = (Queue) getContext().lookup("Queue01"); 
		JMSContext context = ((ConnectionFactory) getContext().lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		JMSProducer producer = context.createProducer();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please enter your username ->");
		String username = bufferedReader.readLine();
		System.out.println("You are connected as " + username);
		
		String msgToSend = null;
		ObjectMessage objMsg = null;
		
		while (true) {
			System.out.println("Please enter your message (or exit) ->");
			msgToSend = bufferedReader.readLine();
			
			if (msgToSend.equalsIgnoreCase("exit")) {
				context.close();
				System.out.println("Goodbye");
				return;
			}
			objMsg = context.createObjectMessage();
			objMsg.setObject(new CommunicationMessage(username, msgToSend));
			objMsg.setStringProperty("username", username);
			producer.send(queue01, objMsg);
		}
		
	}
	
	private static Context getContext() throws NamingException {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		props.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(props);
	}

}
