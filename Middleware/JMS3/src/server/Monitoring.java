package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.weld.exceptions.IllegalArgumentException;

import common.JMS_set_up;

public class Monitoring {

	private static String[] names = {"Queue-Client_Server", "Queue1-2", "Queue2-3", "Queue3-4", "Queue4-5"};
	
	private static int threshold = 10;
	private static int numMaxComponent = 3;
	
	private static List<LoadURL> listLoadUrl;
	private static List<StorePage> listStorePage;
	private static List<ParsePage> listParsePage;
	private static List<DownloadImages> listDownloadImage;
	private static List<ModifyPage> listModifyPage;
	
	public static void main(String[] args) throws NamingException, IOException, JMSException, InterruptedException {
		listLoadUrl = new ArrayList<LoadURL>();
		listStorePage = new ArrayList<StorePage>();
		listParsePage = new ArrayList<ParsePage>();
		listDownloadImage = new ArrayList<DownloadImages>();
		listModifyPage = new ArrayList<ModifyPage>();
		
		LoadURL load = new LoadURL();
		load.start();
		listLoadUrl.add(load);
		
		StorePage store = new StorePage();
		store.start();				
		listStorePage.add(store);

		ParsePage parsePage = new ParsePage(); 
		parsePage.start();
		listParsePage.add(parsePage);

		DownloadImages download = new DownloadImages();
		download.start();
		listDownloadImage.add(download);
		
		ModifyPage modify = new ModifyPage();
		modify.start();
		listModifyPage.add(modify);
		
		//monitoring
		Queue[] queues = new Queue[names.length];
		QueueBrowser[] browswers = new QueueBrowser[names.length];
		// get the initial context
		Context initialContext = JMS_set_up.getContext();
        JMSContext jmsContext = ((ConnectionFactory) initialContext.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
        
        for(int i = 0; i < names.length; i++){
        	//find the queue
        	queues[i] =  (Queue) initialContext.lookup(names[i]);
        	//create the browser
        	browswers[i] = jmsContext.createBrowser(queues[i]);
        }
        // browse the messages
        Enumeration e;
        int numMsgs;

		while(true){
			Thread.sleep(5000); //perform the control every 5 seconds
			for (int i = 1; i < browswers.length; i++) {	//start from 1 because 0 is the queue of client-server
				numMsgs = 0;
				e = browswers[i].getEnumeration();
				while (e.hasMoreElements()) {
		            e.nextElement();
		            numMsgs++;
		        }
				System.out.println("in queue " + i + " ci sono " + numMsgs);
				if(numMsgs == 0){
					deleteComponent(i);
					
				}else if (numMsgs > threshold) {
					addComponent(i);
				}
			}
			
		}

	}

	private static void deleteComponent(int i) {
		switch (i) {
			case 1:
				if(listStorePage.size() > 1){
					int last = listStorePage.size()-1;
					listStorePage.get(last).interrupt();
					listStorePage.remove(last);
					System.out.println("component removed");
				}
				else{
					System.out.println("impossible to remove component " + i);
				}
				break;
			case 2:
				if(listParsePage.size() > 1){
					int last = listParsePage.size()-1;
					listParsePage.get(last).interrupt();
					listParsePage.remove(last);
					System.out.println("component removed");
				}
				else{
					System.out.println("impossible to remove component  " + i);
				}
				break;
			case 3:
				if(listDownloadImage.size() > 1){
					int last = listDownloadImage.size()-1;
					listDownloadImage.get(last).interrupt();
					listDownloadImage.remove(last);
					System.out.println("component removed");
				}
				else{
					System.out.println("impossible to remove component " + i );
				}
				break;
			case 4:
				if(listModifyPage.size() > 1){
					int last = listModifyPage.size()-1;
					listModifyPage.get(last).interrupt();
					listModifyPage.remove(last);
					System.out.println("component removed");
				}
				else{
					System.out.println("impossible to remove component " + i);
				}
				break;
	
			default:
				throw new IllegalArgumentException("Paramenter i illegal");
		}
	}
	
	private static void addComponent(int i) throws NamingException {
		switch (i) {
			case 1:
				if(listStorePage.size() < numMaxComponent){
					StorePage store = new StorePage();
					store.start();				
					listStorePage.add(store);
				}
				break;
			case 2:
				if(listParsePage.size() < numMaxComponent){
					ParsePage parsePage = new ParsePage(); 
					parsePage.start();
					listParsePage.add(parsePage);
				}
				break;
			case 3:
				if(listDownloadImage.size() < numMaxComponent){
					DownloadImages download = new DownloadImages();
					download.start();
					listDownloadImage.add(download);
				}
				break;
			case 4:
				if(listModifyPage.size() < numMaxComponent){
					ModifyPage modify = new ModifyPage();
					modify.start();
					listModifyPage.add(modify);
				}
				break;
			default:
				throw new IllegalArgumentException("Paramenter i illegal");
		}
		
		System.out.println("component add " + i);

	}
}
