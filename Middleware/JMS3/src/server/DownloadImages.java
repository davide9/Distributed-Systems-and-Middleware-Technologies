package server;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.NamingException;

import messages.MessageImageList;
import messages.MessageImageSrcName;
import com.smartfile.api.BasicClient;
import com.smartfile.api.SmartFileException;

import common.JMS_set_up;

public class DownloadImages extends Component implements MessageListener {

	private static String publishQueueName = "Queue4-5";
	private static String subscribeQueueName = "Queue3-4";

	private JMSProducer jmsProducer;
	
	private Queue publishQueue;
	private Queue subscribeQueue;
	
	private boolean test = false;

	private boolean busy = false;
	
	public DownloadImages() throws NamingException{
		
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
		MessageImageList mess = null;
		try {
			mess = msg.getBody(MessageImageList.class);
		} catch (JMSException e) {
			e.printStackTrace();
			return;
		}
		
		List<String> listSrc = mess.getImageList();
		String endpoint = mess.getEndpoint();
		String id = mess.getId();
		String fileName = mess.getFileName();
		
		Image image = null;
	    File file = null;
	    int count = 0;
	    List<String> nameList = new ArrayList<String>();
	    
	    URL url = null;
	    BasicClient client = null;
	    
	    try {
			client = new BasicClient("5Pke4WiJ8uzaxCPEQ59P6ACUwm89iI", "fVasCSf4etDHxv7mCOZlSWrJYGdk1j");
		} catch (SmartFileException e1) {
			e1.printStackTrace();
			return;
		}
	    
	    for (String src : listSrc) {
	    	try {
			    url = new URL(src);
			    image = ImageIO.read(url);
			    file = File.createTempFile("Image" + Integer.toString(count) + "-", ".png");
			    ImageIO.write((RenderedImage) image, "png", file);
			    
			    nameList.add(file.getName());
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(src);
				nameList.add(src);
				continue;
			}
	    	
			try {
				client.post(endpoint, id, file);
				if(test)
					System.out.println("upload immagine effettuato");
			} catch (SmartFileException e) {
				e.printStackTrace();
				return;
			}
			
			count++;
		}
	    jmsProducer.send(publishQueue, new MessageImageSrcName(listSrc, nameList, endpoint, id, fileName));
	    busy = false;
	}
	
	public static void main(String[] args) throws IOException, NamingException {
		
		DownloadImages chat = new DownloadImages();
		
		while(true);
		
	}
}
