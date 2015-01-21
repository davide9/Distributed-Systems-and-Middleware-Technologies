package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	
	public Client(){
		keks = new SecretKey[server.Server.numOfBit];
		
		createAsimmetricKey();
		
		transport = new TransportClient(this);
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
						transport.listen();
						System.out.println("waiting....");
					}
					
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
			}
		}
		
		ClientListen listen = new ClientListen();
		listen.start();
		System.out.println("the client is listening");
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
		System.out.println("Setting dek key " + newDek);
		dek = newDek;
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

	/**
	 * A simple Swing-based client for the chat server.  Graphically
	 * it is a frame with a text field for entering messages and a
	 * textarea to see the whole dialog.
	 *
	 * The client follows the Chat Protocol which is as follows.
	 * When the server sends "SUBMITNAME" the client replies with the
	 * desired screen name.  The server will keep sending "SUBMITNAME"
	 * requests as long as the client submits screen names that are
	 * already in use.  When the server sends a line beginning
	 * with "NAMEACCEPTED" the client is now allowed to start
	 * sending the server arbitrary strings to be broadcast to all
	 * chatters connected to the server.  When the server sends a
	 * line beginning with "MESSAGE " then all characters following
	 * this string should be displayed in its message area.
	 */
	public class ClientMess extends Thread {
		
	    private BufferedReader in;
	    private PrintWriter out;
	    private JFrame frame = new JFrame("Chatter");
	    private JTextField textField = new JTextField(40);
	    private JTextArea messageArea = new JTextArea(8, 40);

	    /**
	     * Constructs the client by laying out the GUI and registering a
	     * listener with the textfield so that pressing Return in the
	     * listener sends the textfield contents to the server.  Note
	     * however that the textfield is initially NOT editable, and
	     * only becomes editable AFTER the client receives the NAMEACCEPTED
	     * message from the server.
	     * @param dek 
	     */
	    public ClientMess() {
	        // Layout GUI
	        textField.setEditable(false);
	        messageArea.setEditable(false);
	        frame.getContentPane().add(textField, "North");
	        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
	        frame.pack();

	        // Add Listeners
	        textField.addActionListener(new ActionListener() {
	            /**
	             * Responds to pressing the enter key in the textfield by sending
	             * the contents of the text field to the server.    Then clear
	             * the text area in preparation for the next message.
	             */
	            public void actionPerformed(ActionEvent e) {
	            	String textToSend = textField.getText();
	            	String testEncrypted = MyCrypto.encryptString(textToSend, dek);
	                out.println(testEncrypted);
	                textField.setText("");
	            }
	        });
	    }
	    
	    /**
	     * Prompt for and return the address of the server.
	     */
	    private String getServerAddress() {
	        return JOptionPane.showInputDialog(
	            frame,
	            "Enter IP Address of the Server:",
	            "Welcome to the Chatter",
	            JOptionPane.QUESTION_MESSAGE);
	    }

	    /**
	     * Prompt for and return the desired screen name.
	     */
	    private String getChatName() {
	        return JOptionPane.showInputDialog(
	            frame,
	            "Choose a screen name:",
	            "Screen name selection",
	            JOptionPane.PLAIN_MESSAGE);
	    }

	    /**
	     * Connects to the server then enters the processing loop.
	     */
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
	            	line = line.substring(8);
	            	//take the name of the author of the line
	                String name = line.split(":")[0];
	                messageArea.append(name + ": ");
	                String text = line.substring(name.length()+2);
	                try{
	                	text = MyCrypto.decryptString(text, dek);
	                } catch(BadPaddingException e){
	                	//do nothing
	                }
	                messageArea.append(text + "\n");
	            }
	        }
	    }

	    /**
	     * Runs the client as an application with a closeable frame.
	     */
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
