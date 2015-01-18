package server;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import transport.TransportServer;
import centralizedFlatTable.CentralizedFlatTable;

/**
 * Codice per il server. Gestisce le operazioni di join e leave di un membro
 * identificato dal suo id.
 *
 */
public class Server {

	private List<Integer> ids;
	private CentralizedFlatTable table;
	private int numOfBit = 3;
	public static String ALGORITHM = "AES";
	

	
	private TransportServer transport;

	
	
	public Server(){
		table = new CentralizedFlatTable(numOfBit, ALGORITHM);
		ids = new ArrayList<Integer>();
		transport = new TransportServer(this);
		transport.setUp();
	}

	/**
	 * Assign a new id to the process that have joined the group, and add it in the ids list
	 * @return id of the process that have joined the group
	 */
	public void join(int id){
		ids.add(id);
		
		transport.notifyKey(id, table.getDek(), table.getKeks(id));
	}
	
	public void leave(int id){
		//get the cipher
		Cipher cipher = null; 
		try {
			Cipher chiper = Cipher.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		
		manageDekChanges(cipher, id);
		
		manageKekChanges(cipher, id);
		
	}
	

	private void manageDekChanges(Cipher cipher, int id) {

		SecretKey newDek = table.changeDek();
		List<SecretKey> keks = table.getKeksExcept(id);
		
		//crypt dek with keks and broadcast
		byte[] dekByte = newDek.getEncoded();
		
		for (SecretKey kek : keks) {
			//prepare cipher
			try {
				cipher.init(Cipher.ENCRYPT_MODE, kek);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
			
			//encrypt
			byte[] encryption = null;
			try {
				encryption = cipher.doFinal(dekByte);
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			
			broadcastDek(encryption);
		}
		
	}

	
	private void manageKekChanges(Cipher cipher, int id) {
		List<byte[]> encryptedkeks = table.changeKek(cipher, id);
		
		//prepare cipher
		try {
			cipher.init(Cipher.ENCRYPT_MODE, table.getDek());
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		
		for (byte[] bs : encryptedkeks) {
			byte[] encryption = null;
			
			try {
				encryption = cipher.doFinal(bs);
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			
			broadcastKek(encryption);
		}
		
	}
	
	
	private void broadcastDek(byte[] encryption) {
		// TODO Auto-generated method stub	
	}
	
	private void broadcastKek(byte[] encryption) {
		// TODO Auto-generated method stub
		
	}
	
}
