package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.NamingException;

import common.JMS_set_up;

public class Client {

	public static String publishQueueName = "Queue-Client_Server";
	
	public static void main(String[] args) throws NamingException, IOException {
		
		
		Context initialContext = JMS_set_up.getContext();
				
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


}
