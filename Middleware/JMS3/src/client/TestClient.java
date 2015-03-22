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

public class TestClient {
	
	public static String publishQueueName = "Queue-Client_Server";
	
	public static void main(String[] args) throws NamingException, IOException {
		
		
		Context initialContext = JMS_set_up.getContext();
				
		Queue publishQueue = (Queue) initialContext.lookup(publishQueueName);
		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
				
		JMSProducer jmsProducer = jmsContext.createProducer();
		
		String msgToSend = "http://www.cavallibaggio.it/";
		
		for(int i = 0; i < 1000; i++){
			jmsProducer.send(publishQueue, "URL = " + msgToSend );
		}
	}

}
