package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.naming.Context;
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
		listLoadUrl.add(load);
		
		StorePage store = new StorePage();
		listStorePage.add(store);

		ParsePage parsePage = new ParsePage(); 
		listParsePage.add(parsePage);

		DownloadImages download = new DownloadImages();
		listDownloadImage.add(download);
		
		ModifyPage modify = new ModifyPage();
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
			Thread.sleep(10000); //perform the control every X seconds
			System.out.println("****************************************************************");
			for (int i = 0; i < browswers.length; i++) {	
				numMsgs = 0;
				e = browswers[i].getEnumeration();
				while (e.hasMoreElements()) {
		            e.nextElement();
		            numMsgs++;
		        }
				System.out.println("in queue " + i + " ci sono " + numMsgs + " mess");
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
			case 0:
				if(listLoadUrl.size() > 1){
					if(!listLoadUrl.get(0).busyState()){
						listLoadUrl.get(0).delete();
						listLoadUrl.remove(0);
						System.out.println("component rimosso");
					}
				}
				else{
					System.out.println("impossibile rimuovere component " + i);
				}
				break;
			case 1:
				if(listStorePage.size() > 1){
					if(!listStorePage.get(0).busyState()){
						listStorePage.get(0).delete();
						listStorePage.remove(0);
						System.out.println("component rimosso");
					}
				}
				else{
					System.out.println("impossibile rimuovere component " + i);
				}
				break;
			case 2:
				if(listParsePage.size() > 1){
					if(!listParsePage.get(0).busyState()){
						listParsePage.get(0).delete();
						listParsePage.remove(0);
						System.out.println("component rimosso");
					}
				}
				else{
					System.out.println("impossibile rimuovere component  " + i);
				}
				break;
			case 3:
				if(listDownloadImage.size() > 1){
					if(!listDownloadImage.get(0).busyState()){
						listDownloadImage.get(0).delete();
						listDownloadImage.remove(0);
						System.out.println("component rimosso");
					}
				}
				else{
					System.out.println("impossibile rimuovere component " + i );
				}
				break;
			case 4:
				if(listModifyPage.size() > 1){
					if(!listModifyPage.get(0).busyState()){
						listModifyPage.get(0).delete();
						listModifyPage.remove(0);
						System.out.println("component rimosso");
					}
				}
				else{
					System.out.println("impossibile rimuovere component " + i);
				}
				break;
	
			default:
				throw new IllegalArgumentException("Paramenter i illegal");
		}
	}
	
	private static void addComponent(int i) throws NamingException, IOException {
		switch (i) {
			case 0:
				if(listLoadUrl.size() < numMaxComponent){
					LoadURL load = new LoadURL();
					listLoadUrl.add(load);
					System.out.println("component add " + i);
				}
				break;
			case 1:
				if(listStorePage.size() < numMaxComponent){
					StorePage store = new StorePage();
					listStorePage.add(store);
					System.out.println("component add " + i);
				}
				break;
			case 2:
				if(listParsePage.size() < numMaxComponent){
					ParsePage parsePage = new ParsePage(); 
					listParsePage.add(parsePage);
					System.out.println("component add " + i);
				}
				break;
			case 3:
				if(listDownloadImage.size() < numMaxComponent){
					DownloadImages download = new DownloadImages();
					listDownloadImage.add(download);
					System.out.println("component add " + i);
				}
				break;
			case 4:
				if(listModifyPage.size() < numMaxComponent){
					ModifyPage modify = new ModifyPage();
					listModifyPage.add(modify);
					System.out.println("component add " + i);
				}
				break;
			default:
				throw new IllegalArgumentException("Paramenter i illegal");
		}
		
		

	}
}
