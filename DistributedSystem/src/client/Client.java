package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import myCrypto.MyCrypto;
import transport.TransportClient;

public class Client {
	
	public static final String ALGORITHM = "RSA";

	public static final String CHIPER_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
	
	private SecretKey dek;
	private SecretKey[] keks;
	private TransportClient transport;
	private PrivateKey myKey;
	private PublicKey publicKey;
	private ClientMess message;
	
	public Client(String serverName){
		keks = new SecretKey[server.Server.numOfBit];
		dek = new SecretKeySpec(new byte[16], server.Server.ALGORITHM);
				
		createAsimmetricKey();
		System.out.println(serverName);
		transport = new TransportClient(this, serverName);
	}

	public void join(){
		transport.notifyServerJoin();
	}
	
	public void listen(){
		class ClientListen extends Thread{
			@Override
			public void run(){
				try {
					System.out.println("waiting....");
					while(true){
						try {
							int result = transport.listen();
							if( result == -1){
								break;
							}
						} catch (EOFException e) {
							System.out.println("Stop listening...");
							break;
						}
						System.out.println("waiting....");
					}
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}				
			}
		}
		
		ClientListen listen = new ClientListen();
		listen.start();
	}
	
	public void startMessage(){
		message = new ClientMess();
		message.start();
	}
	
	public void leave(){
		try {
			transport.notifyServerLeave();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void setDek(SecretKey newDek){
		
		synchronized (dek) {
			System.out.println("Setting dek key " + newDek);
			dek = newDek;
		}
	}
	
	
	public void setKeks(SecretKey[] keks){
		System.out.println("Setting kek keys....");
		for(int i = 0; i < this.keks.length; i++){
			this.keks[i] = keks[i];
		}
	}
	
	public void setKek(SecretKey kek, int index){
		this.keks[index] = kek;
	}
	
	public SecretKey getKek(int index){
		return keks[index];
	}

	public SecretKey getDek() {
		return dek;
	}
	
	public PublicKey getPublicKey() {
		return this.publicKey;
	}
	
	public PrivateKey getPrivateKey() {
		return this.myKey;
	}
	
	private void createAsimmetricKey() {
		KeyPairGenerator gen = null;
		try {
			gen = KeyPairGenerator.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		KeyPair pair = gen.generateKeyPair();
		
		myKey = pair.getPrivate();
		publicKey = pair.getPublic();
	}

	public class ClientMess extends Thread {
		
	    private BufferedReader in;
	    private PrintWriter out;
	    private JFrame frame = new JFrame("Chat group");
	    private JTextField textField = new JTextField(40);
	    private JTextArea messageArea = new JTextArea(8, 40);
	    private JButton leaveButton = new JButton("Leave group");


	    public ClientMess() {
	        // Layout GUI
	        textField.setEditable(false);
	        messageArea.setEditable(false);
	        frame.getContentPane().add(textField, "North");
	        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
	        JPanel buttons = new JPanel();
	        frame.getContentPane().add(buttons, "East");
	        buttons.add(leaveButton, "Center");
	        frame.pack();

	        // Add Listeners
	        textField.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	            	String textToSend = textField.getText();
	            	String testEncrypted = null;
	            	synchronized (dek) {
		            	testEncrypted = MyCrypto.encryptString(textToSend, dek);
					}
	                out.println(testEncrypted);
	                textField.setText("");
	            }
	        });
	        
	        leaveButton.addActionListener(new ActionListener() {
				
	        	public void actionPerformed(ActionEvent arg0) {
					Client.this.leave();
				}
			});
	    }
	    
	    private String getServerAddress() {
	        return JOptionPane.showInputDialog(
	            frame,
	            "Enter IP Address of the Server:",
	            "Welcome to the Chatter",
	            JOptionPane.QUESTION_MESSAGE);
	    }

	    private String getChatName() {
	        return JOptionPane.showInputDialog(
	            frame,
	            "Choose a screen name:",
	            "Screen name selection",
	            JOptionPane.PLAIN_MESSAGE);
	    }

	    private void exec() throws IOException {

	        // Make connection and initialize streams
	        String serverAddress = getServerAddress();
	        Socket socket = new Socket(serverAddress, 9001);
	        in = new BufferedReader(new InputStreamReader(
	            socket.getInputStream()));
	        out = new PrintWriter(socket.getOutputStream(), true);

	        // Process all messages from server, according to the protocol.
	        while (true) {
	            String line = in.readLine();
	            if (line.startsWith("SUBMITNAME")) {
	                out.println(getChatName());
	            } else if (line.startsWith("NAMEACCEPTED")) {
	                textField.setEditable(true);
	            } else if (line.startsWith("MESSAGE")) {
	            	//delete MESSAGE from the input line
	            	synchronized(dek){ 
	            		line = line.substring(8);
		            	//take the name of the author of the line
		                String name = line.split(":")[0];
		                messageArea.append(name + ": ");
		                String text = line.substring(name.length()+2);
		                text = MyCrypto.decryptString(text, dek);
		                messageArea.append(text + "\n");
	            	}
	            }
	        }
	    }

	    public void run() {
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        try {
				exec();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
}
