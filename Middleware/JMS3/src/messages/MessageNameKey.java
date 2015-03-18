package messages;

import java.io.Serializable;

public class MessageNameKey implements Serializable {

	private String id;
	private String endpoint;
	
	public MessageNameKey(String endpoint, String id){
		super();
		this.endpoint = endpoint;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
}
