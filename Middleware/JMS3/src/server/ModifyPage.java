package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
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

import messages.MessageImageSrcName;
import common.Download;
import common.JMS_set_up;

public class ModifyPage extends Thread implements MessageListener {

	private static String subscribeQueueName = "Queue4-5";
		
	private Queue subscribeQueue;
	
	private boolean test = false;

	
	public ModifyPage() throws NamingException{
		Context initialContext = JMS_set_up.getContext();

		subscribeQueue = (Queue) initialContext.lookup(subscribeQueueName);
		
		JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		jmsContext.createConsumer(subscribeQueue).setMessageListener(this);
	}
	
	public void onMessage(Message msg) {
		MessageImageSrcName mess = null;
		try {
			mess = msg.getBody(MessageImageSrcName.class);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		List<String> nameList = mess.getName();
		List<String> srcList = mess.getSrc();
		String fileName = mess.getFileName();
		
        InputStream fileStream = null;
        BasicClient client = null;
        try {
			client = new BasicClient("5Pke4WiJ8uzaxCPEQ59P6ACUwm89iI", "fVasCSf4etDHxv7mCOZlSWrJYGdk1j");
			fileStream = client.get(mess.getEndpoint()+mess.getId(), fileName);
		} catch (SmartFileException e1) {
			e1.printStackTrace();
			return;
		}
        
        BufferedReader br = new BufferedReader(new InputStreamReader(fileStream));
		File fileTemp = Download.downloadHtml(br, "TheSourcePageModify");
		try {
			br.close();
	        fileStream.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		
		Document doc = null;
		try {
			doc = Jsoup.parse(fileTemp, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		Elements img = doc.getElementsByTag("img");
		for (Element el : img) {
			String src = el.attr("src");
			for (int i = 0; i < srcList.size(); i++) {
				//se match allora modifica il riferimento all'immagine
				if(srcList.get(i).endsWith(src)){
					el.attr("src", nameList.get(i));
				}
			}
		}
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileTemp,"UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return;
		}
		writer.write(doc.html() ) ;
		writer.flush();
		writer.close();
		
		try {
			client.post(mess.getEndpoint(), mess.getId(), fileTemp);
			if(test)
				System.out.println("Html modificato è su");
		} catch (SmartFileException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void run(){
		while(!this.isInterrupted()){
			
		}
	}
	
	public static void main(String[] args) throws NamingException {
		ModifyPage chat = new ModifyPage();
		while(true);
	}

}
