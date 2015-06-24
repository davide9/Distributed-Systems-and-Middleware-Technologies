package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.NamingException;

import messages.MessageNameKey;

import com.smartfile.api.BasicClient;
import com.smartfile.api.SmartFileException;

import common.Download;
import common.JMS_set_up;

public class StorePage extends Thread implements MessageListener {

	private static String publishQueueName = "Queue2-3";
	private static String subscribeQueueName = "Queue1-2";
	
	private JMSProducer jmsProducer;
	
	private Queue publishQueue;
	private Queue subscribeQueue;
	
	private boolean test = false;
	private boolean busy = false;
		
	public StorePage() throws NamingException{
		
		Context initialContext = JMS_set_up.getContext();
		
		subscribeQueue = (Queue) initialContext.lookup(subscribeQueueName);
		publishQueue = (Queue) initialContext.lookup(publishQueueName);
		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		jmsContext.createConsumer(subscribeQueue).setMessageListener(this);

		jmsProducer = jmsContext.createProducer();		
	}
	
	public void onMessage(Message msg) {
		busy = false;
		
		String body = null;
		try {
			body = (String) msg.getBody(String.class);
		} catch (JMSException e1) {
			e1.printStackTrace();
			return;
		}
		if(test)
			System.out.println("L'url ricevuto è: " + body);
		
		URL url = null;

		try {
			url = new URL(body);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return;
		}
		
		InputStream is = null;
		try {
			is = url.openStream();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} 
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        String fileName = "TheSourcePage";
        
        File htmlSource = Download.downloadHtml(br, fileName);
        
        try {
			br.close();
			is.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
   
        //save on smart file
        String endpoint = "/path";
        String id = "/data/"+body;
        BasicClient client = null;
        
        
		try {
			client = new BasicClient("5Pke4WiJ8uzaxCPEQ59P6ACUwm89iI", "fVasCSf4etDHxv7mCOZlSWrJYGdk1j");
			//fisrt create a folder dedicated to the new page
			client.put("/path/oper/mkdir", body);
			client.post(endpoint, id, htmlSource);
			
			MessageNameKey mess = new MessageNameKey(endpoint, id, htmlSource.getName(), body);
			if(test)
				System.out.println(htmlSource.getName());
			jmsProducer.send(publishQueue, mess);
			
		} catch (SmartFileException e) {
			e.printStackTrace();
		}
   
		busy = false;
	}
	
	public void run(){
		while(!this.isInterrupted()){
			
		}
	}
	
	public boolean busyState(){
		return busy;
	}

	public static void main(String[] args) throws IOException, NamingException {	
		StorePage chat = new StorePage();
		while(true);
	}
}
