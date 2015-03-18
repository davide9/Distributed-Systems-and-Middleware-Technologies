package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.smartfile.api.BasicClient;
import com.smartfile.api.SmartFileException;

import common.JMS_set_up;
import messages.MessageNameKey;

public class ParsePage implements MessageListener{

	private static String publishQueueName = "Queue3-4";
	private static String subscribeQueueName = "Queue2-3";
	

	private JMSProducer jmsProducer;
	
	private Queue publishQueue;
	private Queue subscribeQueue;
	
	public ParsePage() throws NamingException{

		Context initialContext = JMS_set_up.getContext();
				
		Queue subscribeQueue = (Queue) initialContext.lookup(subscribeQueueName);
		Queue publishQueue = (Queue) initialContext.lookup(publishQueueName);
		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		jmsContext.createConsumer(subscribeQueue).setMessageListener(this);

		JMSProducer jmsProducer = jmsContext.createProducer();
	}
	
	
	public static void main(String[] args) throws IOException, NamingException {
		ParsePage chat = new ParsePage();
	}
	
	public void onMessage(Message msg) {
		
		//reading message
		
		MessageNameKey mess = null;
		try {
			mess = msg.getBody(MessageNameKey.class);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		String endpoint = mess.getEndpoint();
		String id = mess.getId();
		
		
		//getting the object
		BasicClient client = null;
        
		try {
			client = new BasicClient("5Pke4WiJ8uzaxCPEQ59P6ACUwm89iI", "fVasCSf4etDHxv7mCOZlSWrJYGdk1j");
		} catch (SmartFileException e) {
			e.printStackTrace();
		}
        client.setApiUrl("app.smartfile.com");

        InputStream fileStream = null;
		try {
			fileStream = client.get(endpoint, id);
		} catch (SmartFileException e1) {
			e1.printStackTrace();
		}
		
		//parsing
		
		try {
			parsing(fileStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void parsing(InputStream input) throws IOException {
		Document doc = Jsoup.parse(input, "UTF-8", null);
		Elements img = doc.getElementsByTag("img");
		for (Element el : img) {
			String src = el.attr("src");

			this.jmsProducer.send(publishQueue, src);
		}
    }
}
