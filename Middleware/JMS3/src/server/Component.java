package server;

import javax.jms.JMSConsumer;

public abstract class Component {
	
	protected boolean busy = false;

	protected JMSConsumer myConsumer;
	
	public boolean busyState(){
		return busy;
	}
	
	public void delete(){
		myConsumer.close();
	}
}
