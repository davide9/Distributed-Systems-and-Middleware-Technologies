package server;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ImageWS {

	@WebMethod public String uploadImage(Image data);
	@WebMethod public Image downloadImage(String name); 

}
