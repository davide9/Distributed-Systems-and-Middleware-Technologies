package messages;

import java.io.Serializable;
import java.util.List;

public class MessageImageList implements Serializable {
	
	private List<String> imageList;
	private String endpoint;
	private String id;
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MessageImageList(List<String> imageList, String endpoint, String id, String fileName) {
		super();
		this.imageList = imageList;
		this.endpoint = endpoint;
		this.id = id;
		this.fileName = fileName;
	}
	
	public List<String> getImageList() {
		return imageList;
	}
	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
