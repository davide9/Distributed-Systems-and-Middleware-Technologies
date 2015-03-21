package messages;

import java.io.Serializable;

public class MessageNameKey implements Serializable {

	private String id;
	private String endpoint;
	private String name;
	private String url;
	
	public MessageNameKey(String endpoint, String id, String name, String url){
		super();
		this.endpoint = endpoint;
		this.id = id;
		this.name = name;
		this.url = url;
		
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
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getUrl(){
		return this.url;
	}
	
}
