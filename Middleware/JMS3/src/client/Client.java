package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {

	public static String publishQueueName = "Queue-Client_Server";
	
	public static void main(String[] args) throws NamingException, IOException {
		
		
		Context initialContext = getContext();
				
		Queue publishQueue = (Queue) initialContext.lookup(publishQueueName);
		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
				
		JMSProducer jmsProducer = jmsContext.createProducer();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String msgToSend = null;
		while (true) {
			System.out.println("Inserire un URL");
			msgToSend = bufferedReader.readLine();
			if (msgToSend.equalsIgnoreCase("exit")) {
				jmsContext.close();
				System.exit(0);
			}
			else {
				jmsProducer.send(publishQueue, "URL = " + msgToSend );
				System.out.println("messaggio mandato");
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
}
