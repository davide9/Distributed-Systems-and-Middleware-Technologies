package browser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import common.CommunicationMessage;

public class Browser01 {

	public static void main(String[] args) throws NamingException, IOException, JMSException {
		// TODO Auto-generated method stub

		String queueName = null;
		Queue queueToExamine = null;
		QueueBrowser browser = null;
		Enumeration<?> enumeration = null;
		ObjectMessage objMsg = null;
		CommunicationMessage commMsg = null;
		
		JMSContext context = ((ConnectionFactory) getContext().lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			try {
				System.out.println("Please enter a queue name (or exit) ->");
				queueName = bufferedReader.readLine();
				if (queueName.equalsIgnoreCase("exit")) {
					context.close();
					System.out.println("Goodbye");
					return;
				}
				queueToExamine = (Queue)getContext().lookup(queueName); 
				browser = context.createBrowser(queueToExamine);
				enumeration = browser.getEnumeration();
				while (enumeration.hasMoreElements()) {
					Object obj = enumeration.nextElement();
					if (obj instanceof ObjectMessage) {
						objMsg = (ObjectMessage)obj;
						commMsg = (CommunicationMessage)objMsg.getObject();
						System.out.print("Sender -> " + commMsg.getName());
						System.out.println(" | Msg -> " + commMsg.getMessage());
					}
				}
			} catch (NamingException e) {
				System.out.println("Naming Exception -> " + e.getMessage());
			}
		}
		
		
		
		
	}
	
	private static Context getContext() throws NamingException {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		props.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(props);
	}

}
