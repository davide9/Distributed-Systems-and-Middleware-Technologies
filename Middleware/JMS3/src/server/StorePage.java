package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;

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

import messages.MessageNameKey;

import com.smartfile.api.BasicClient;
import com.smartfile.api.SmartFileException;
import common.JMS_set_up;

public class StorePage implements MessageListener {

	private static String publishQueueName = "Queue2-3";
	private static String subscribeQueueName = "Queue1-2";
	
	private JMSProducer jmsProducer;
	
	private Queue publishQueue;
	private Queue subscribeQueue;
	
	private int num = 0;
	
	public StorePage() throws NamingException{
		
		Context initialContext = JMS_set_up.getContext();
		
		subscribeQueue = (Queue) initialContext.lookup(subscribeQueueName);
		publishQueue = (Queue) initialContext.lookup(publishQueueName);
		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		jmsContext.createConsumer(subscribeQueue).setMessageListener(this);

		jmsProducer = jmsContext.createProducer();		
	}
	
	private static Context getContext() throws NamingException {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		props.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(props);
	}

	public void onMessage(Message msg) {

		num ++;
		
		String body = null;
		try {
			body = (String) msg.getBody(String.class);
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		URL url = null;

		try {
			url = new URL(body);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		InputStream is = null;
		try {
			is = url.openStream();
		} catch (IOException e) {
			e.printStackTrace();
		} 
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        String fileName = "";
        
        File htmlSource = downloadHtml(br, fileName);
        
        
        System.out.println("prova");
        System.out.println(num);
   
        //save on smart file
        String endpoint = body;
        String id = "/page";
        BasicClient client = null;
        
        System.out.println(htmlSource);
        
		try {
			client = new BasicClient("5Pke4WiJ8uzaxCPEQ59P6ACUwm89iI", "fVasCSf4etDHxv7mCOZlSWrJYGdk1j");
			//client.setApiUrl("app.smartfile.com");
			client.post(endpoint, id, htmlSource);
			
			MessageNameKey mess = new MessageNameKey(endpoint, id, fileName, body);
        
        jmsProducer.send(publishQueue, mess);
		} catch (SmartFileException e) {
			e.printStackTrace();
		}finally{
			System.out.println("La madonna");
		}
   
	}

	public static void main(String[] args) throws IOException, NamingException {	
		StorePage chat = new StorePage();
		while(true);
	}
	
	private File downloadHtml(BufferedReader reader, String name) {
		File file = null;
		try {
			file = File.createTempFile("aws-java-sdk-", ".txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
        file.deleteOnExit();

        //start downloading the source
        try {
			Writer writer = new OutputStreamWriter(new FileOutputStream(file));
			
			while (true) {
	            String line = null;
	            
	            //READ LINE
				try {
					line = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
	            if (line == null) break;
	            
	            //WRITE LINE
	            try {
					writer.write(line);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return file;
	}

	
}
