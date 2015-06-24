package server;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.NamingException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.smartfile.api.BasicClient;
import com.smartfile.api.SmartFileException;

import common.JMS_set_up;
import messages.MessageImageList;
import messages.MessageNameKey;

public class ParsePage extends Component implements MessageListener{

	private static String publishQueueName = "Queue3-4";
	private static String subscribeQueueName = "Queue2-3";
	

	private JMSProducer jmsProducer;
	
	private Queue publishQueue;
	private Queue subscribeQueue;
	
	private boolean test = false;
	private boolean busy = false;

	
	public ParsePage() throws NamingException{

		Context initialContext = JMS_set_up.getContext();
				
		subscribeQueue = (Queue) initialContext.lookup(subscribeQueueName);
		publishQueue = (Queue) initialContext.lookup(publishQueueName);
		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		myConsumer = jmsContext.createConsumer(subscribeQueue);
		myConsumer.setMessageListener(this);
		
		jmsProducer = jmsContext.createProducer();
	}
	
	
	public void onMessage(Message msg) {
		busy = true;
		//reading message
		
		MessageNameKey mess = null;
		try {
			mess = msg.getBody(MessageNameKey.class);
		} catch (JMSException e) {
			e.printStackTrace();
			return;
		}
		String endpoint = mess.getEndpoint();
		String id = mess.getId();
		String fileName = mess.getName();
		String url = mess.getUrl();
		
		
		//getting the object
		BasicClient client = null;
        
		try {
			client = new BasicClient("5Pke4WiJ8uzaxCPEQ59P6ACUwm89iI", "fVasCSf4etDHxv7mCOZlSWrJYGdk1j");
		} catch (SmartFileException e) {
			e.printStackTrace();
			return;
		}
        //client.setApiUrl("app.smartfile.com");

        InputStream fileStream = null;
		try {
			fileStream = client.get(endpoint+id, fileName);
		} catch (SmartFileException e1) {
			e1.printStackTrace();
			return;
		}
		
		//parsing
		List<String> imgSource = null;
		try {
			imgSource = parsing(fileStream, url);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		if(test)
			System.out.println("ho trovato " + imgSource.size() + "immagine");
		
		if(imgSource.size() == 0){
			return;
		}
		
		jmsProducer.send(publishQueue, new MessageImageList(imgSource, endpoint, id, fileName));
		busy = false;
		
	}
	
	public static void main(String[] args) throws IOException, NamingException {
		ParsePage chat = new ParsePage();
		while(true);
	}

	private List<String> parsing(InputStream input, String url) throws IOException {
		
		Document doc = Jsoup.parse(input, "UTF-8", url);
		Elements img = doc.getElementsByTag("img");
		List<String> imageSource = new ArrayList<String>();
		for (Element el : img) {
			String absSrc = el.absUrl("src");
			imageSource.add(absSrc);
		}
		
		return imageSource;
    }
}
