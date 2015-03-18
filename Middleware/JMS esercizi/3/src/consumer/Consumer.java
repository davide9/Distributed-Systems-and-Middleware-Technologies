package consumer;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import common.CommunicationMessage;

public class Consumer {

	public static void main(String[] args) throws NamingException, JMSException {
		
		Message msg = null;
		CommunicationMessage commMsg = null;
		
		Queue queue01 = (Queue) getContext().lookup("Queue01"); 
		JMSContext context = ((ConnectionFactory) getContext().lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		JMSConsumer consumer = context.createConsumer(queue01);
		
		while (true) {
			msg = consumer.receive();
			commMsg = msg.getBody(CommunicationMessage.class);
			System.out.println("Received -> username(" + commMsg.getName()+") - message(" + commMsg.getMessage()+")");
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
