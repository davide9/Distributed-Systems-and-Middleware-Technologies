package client;

import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class ClientLogHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		Boolean outbound = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		SOAPMessage message = context.getMessage();
		
		if (outbound) {
			//the message is outbound	
			try {
				System.out.println("Captured an outbound message: ");
				message.writeTo(System.out);
				System.out.println();
				
				SOAPBody body = message.getSOAPBody();
				System.out.println("Local name for first node-> " + body.getChildNodes().item(0).getLocalName());
				
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			//the message is inbound
			System.out.println("Captured an inbound message: ");
			try {
				message.writeTo(System.out);
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
