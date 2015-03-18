package common;

import java.io.Serializable;

public class CommunicationMessage implements Serializable {

	private String username;
	private String message;
	
	public CommunicationMessage(String username, String message) {
		super();
		this.username = username;
		this.message = message;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
