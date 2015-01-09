package client;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;

import support.ImageWS;
import support.ImageWSImplService;

public class TestClient {

	public static void main(String[] args) {
		
		ImageWSImplService service = new ImageWSImplService();
		
		ImageWS port = service.getImageWSImplPort();
		
		//enable MTOM on the client side
		BindingProvider bProvider = (BindingProvider)port;
		SOAPBinding sBinding = (SOAPBinding) bProvider.getBinding();
		sBinding.setMTOMEnabled(true);
		
		// Code for downloading 
		
		InputStream in = new ByteArrayInputStream(port.downloadImage("firefly.jpg"));
		
		try {
			Image image = ImageIO.read(in);
			JFrame jframe = new JFrame();
			jframe.setSize(600, 500);
			JLabel label = new JLabel(new ImageIcon(image));
			jframe.add(label);
			jframe.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
