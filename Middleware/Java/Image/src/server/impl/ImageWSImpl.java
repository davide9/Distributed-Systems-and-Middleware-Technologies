package server.impl;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import server.ImageWS;


@WebService(endpointInterface="server.ImageWS")
@MTOM(enabled=true, threshold=2048)
public class ImageWSImpl implements ImageWS {

	static int counter;
	
	static {
		counter = 0;
	}
	
	@Override
	public String uploadImage(Image data) {
		if (data!=null) {
			BufferedImage bImage = new BufferedImage(data.getWidth(null), data.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = bImage.createGraphics();
			graphics.drawImage(data, null, null);
			RenderedImage rImage = (RenderedImage)bImage;
			try {
				ImageIO.write(rImage, "jpg", new File("/Users/sam/Desktop/" + counter + ".jpg"));
				counter++;
				return "Upload Success";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Upload Error";
		}
		return "Data was null";
	}

	@Override
	public Image downloadImage(String name) {
		Image returnImage = null;
		try {
			returnImage = ImageIO.read(new File("/Users/sam/Desktop/" + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return returnImage;
	}

}
