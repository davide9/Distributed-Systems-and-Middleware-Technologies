package messages;

import java.io.Serializable;
import java.util.List;

public class MessageImageSrcName implements Serializable {
	
	private List<String> src;
	private List<String> name;
	private String id;
	private String fileName;
	private String endpoint;
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public MessageImageSrcName(List<String> src, List<String> name, String endpoint, String id, String fileName) {
		super();
		this.src = src;
		this.name = name;
		this.endpoint = endpoint;
		this.id = id;
		this.fileName = fileName;
	}
	
	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public List<String> getSrc() {
		return src;
	}
	
	public void setSrc(List<String> src) {
		this.src = src;
	}
	
	public List<String> getName() {
		return name;
	}
	
	public void setName(List<String> name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
