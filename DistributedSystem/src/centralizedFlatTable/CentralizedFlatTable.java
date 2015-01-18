package centralizedFlatTable;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import myCrypto.MyCrypto;

/**
 * Gestice la centralized flat table. Contiene tutte le chiavi
 * necessarie per la gestione del gruppo e tutti i metodi che servono
 * a cambiare tali chiavi
 *
 */
public class CentralizedFlatTable {
	private SecretKey[][] table;	//dim is 2 * numOfBit
	private int numOfBit; 
	private SecretKey dek;
	private KeyGenerator gen;
	private String algorithm;
	
	public CentralizedFlatTable(int numOfBit, String algorithm){
		this.algorithm = algorithm; 
		this.numOfBit = numOfBit;
		table = new SecretKey[2][this.numOfBit];
		
		//get the key generator
		try {
			gen = KeyGenerator.getInstance(this.algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		//create initial keys
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < this.numOfBit; j++){
				table[i][j] = gen.generateKey();
			}
		}
		
		dek = gen.generateKey();
	}
	
	/**
	 * Change the key that are owned by the member identified whit its ID.
	 * 
	 * @param id the id of the member that will leave
	 */
	public List<byte[]> changeKek(Cipher cipher, int id){
		String binary = Integer.toBinaryString(id);
		List<byte[]> list = new ArrayList<byte[]>();
		
		for(int i = 0; i < binary.length(); i++){
			int bitValue = Character.getNumericValue(binary.charAt(i));
			SecretKey oldKek = table[bitValue][numOfBit - i - 1];
			table[bitValue][numOfBit - i - 1] = gen.generateKey();
			
			list.add(MyCrypto.encryptKey(table[bitValue][numOfBit - i - 1], cipher, oldKek));
		}
		
		return list;		
	}

	public SecretKey changeDek() {
		dek = gen.generateKey();
		return dek;
	}

	public List<SecretKey> getKeksExcept(int id) {
		String binary = Integer.toBinaryString(id);
		List<SecretKey> keks = new ArrayList<SecretKey>();;
		
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < this.numOfBit; j++){
				for(int k = binary.length()-1; i >= 0 ; i++){
					int bitValue = Character.getNumericValue(binary.charAt(i));
					//if the bit position is different or bit value is different add the kek
					if(k != j || i != bitValue){
						keks.add(table[i][j]);
					}
				}
			}
		}
		
		return keks;
		
	}

	public SecretKey getDek() {
		return dek;
	}

	public List<SecretKey> getKeks(int id) {
		String binary = Integer.toBinaryString(id);
		List<SecretKey> list = new ArrayList<SecretKey>();
		
		for(int i = 0; i < binary.length(); i++){
			int bitValue = Character.getNumericValue(binary.charAt(i));
			
			list.add(table[bitValue][numOfBit - i - 1]);
		}
		
		return list;
	}

}
