package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
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

import common.JMS_set_up;

public class LoadURL extends Thread implements MessageListener {

	private static String publishQueueName = "Queue1-2";
	private static String subscribeQueueName = "Queue-Client_Server";
	
	private JMSProducer jmsProducer;
	
	private Queue publishQueue;
	private Queue subscribeQueue;
	
	private boolean test = false;
	
	public LoadURL() throws NamingException, IOException{
		
		Context initialContext = JMS_set_up.getContext();
		
		publishQueue = (Queue) initialContext.lookup(publishQueueName);
		subscribeQueue = (Queue) initialContext.lookup(subscribeQueueName);

		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		jmsContext.createConsumer(subscribeQueue).setMessageListener(this);
		jmsProducer = jmsContext.createProducer();		
	}

	public void onMessage(Message msg) {
		String body = null;
		try {
			body = (String) msg.getBody(String.class);
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
		
		String prefix = "URL = ";
		if(body.startsWith(prefix)){
			body = body.substring(prefix.length());
			
			URL url = null;

			try {
				url = new URL(body);
				jmsProducer.send(publishQueue, body);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			if(test)
				System.out.println("L'url ricevuto �: " + body);
		}
		
		else{
			System.out.println("Message not valid");
		}
	}
	
	public void run(){
		while(!this.isInterrupted()){
			
		}
	}
	
	public static void main(String[] args) throws IOException, NamingException {
		
		LoadURL chat = new LoadURL();
		while(true);
	}
	
}
