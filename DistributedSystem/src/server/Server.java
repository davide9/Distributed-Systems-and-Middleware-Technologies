package server;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import myCrypto.MyCrypto;
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
	private TransportServer transport;

	
	public final static int numOfBit = 3;
	public static String ALGORITHM = "AES";
	public static String CHIPER_TRANSFORMATION = "AES/CBC/PKCS5Padding";
	

	public Server(){
		table = new CentralizedFlatTable(numOfBit, ALGORITHM);
		ids = new ArrayList<Integer>();
		transport = new TransportServer(this);
		/*
		SecretKey key = table.getDek();
		byte[] prova = key.getEncoded();
		
		SecretKey key2 = new SecretKeySpec(prova,ALGORITHM);
		
		if(key==key2){
			System.out.println("UGUALI");
		}
		else{
			System.out.println("DIVERSE");
		}
		*/
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
		//TODO handle remove of id
		ids.remove(id);
		Cipher cipher; 
		try {
			cipher = Cipher.getInstance(CHIPER_TRANSFORMATION);
			
			manageDekChanges(cipher, id);
			manageKekChanges(cipher, id);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}

	}
	

	private void manageDekChanges(Cipher cipher, int id) {

		SecretKey newDek = table.changeDek();
		System.out.println("new Dek is " + newDek);
		SecretKey[] keks = table.getKeksExcept(id);
		
		//crypt dek with keks and broadcast
		byte[] dekByte = newDek.getEncoded();
		
		for (int i = 0; i < keks.length; i++) {
			//prepare cipher
			try {
				try {
					cipher.init(Cipher.ENCRYPT_MODE, (SecretKeySpec) keks[i],  new IvParameterSpec(MyCrypto.IV.getBytes("UTF-8")));
				} catch (InvalidAlgorithmParameterException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
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
			
			broadcastDek(encryption, i, id);
		}
		
	}

	
	private void manageKekChanges(Cipher cipher, int id) {
		List<byte[]> encryptedKeks = table.changeKek(cipher, id);
		
		//prepare cipher
		try {
			try {
				cipher.init(Cipher.ENCRYPT_MODE,(SecretKeySpec) table.getDek(),  new IvParameterSpec(MyCrypto.IV.getBytes("UTF-8")));
			} catch (InvalidAlgorithmParameterException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		transport.setKekSending(ids, id);
		
		for (int i = 0; i < encryptedKeks.size(); i ++) {
			byte[] encryption = null;
			
			try {
				encryption = cipher.doFinal(encryptedKeks.get(i));
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			
			broadcastKek(encryption, i, id);
		}
		
	}
	
	/**
	 * 
	 * @param encryption dek encrypted
	 * @param index index of the kek used to encrypt the dek
	 * @param leavingId of the leaving member
	 */
	private void broadcastDek(byte[] encryption, int index, int leavingId) {
		transport.sendDekEncrypted(encryption, ids, index, leavingId);
	}
	
	private void broadcastKek(byte[] encryption, int index, int leavingId) {
		transport.sendKekEncrypted(encryption, ids, index, leavingId);
		
	}
	
	public SecretKey getDek(){
		return table.getDek();
	}
	
	public SecretKey getKek(int index, int bitValue){
		return table.getKek(index, bitValue);
	}
	
}
