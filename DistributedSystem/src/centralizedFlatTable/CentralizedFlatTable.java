package centralizedFlatTable;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import server.Server;
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
		String binary = binarizeInteger(id);
		List<byte[]> list = new ArrayList<byte[]>();
		
		for(int i = binary.length()-1; i >= 0; i--){
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

	public SecretKey[] getKeksExcept(int id) {
		String binary = binarizeInteger(id);
		SecretKey[] keks = new SecretKey[numOfBit];;
		for(int i = 0; i < binary.length(); i++){
			int bitValue = Character.getNumericValue(binary.charAt(i));
			
			//toggle bit value
			if(bitValue == 1)
				bitValue = 0;
			else
				bitValue = 1;
			
			keks[numOfBit - i - 1] = table[bitValue][numOfBit - i - 1];
			
		}
		
		return keks;
		
	}

	public SecretKey getDek() {
		return dek;
	}

	public SecretKey[] getKeks(int id) {
		String binary = binarizeInteger(id);
		System.out.println("Getting keks for id: " + binary);
		SecretKey[] keks = new SecretKey[binary.length()];
		
		for(int i = 0; i < binary.length(); i++){
			int bitValue = Character.getNumericValue(binary.charAt(i));
			keks[numOfBit - i - 1] = table[bitValue][numOfBit - i - 1];
		}
		
		return keks;
	}
	
	private static String binarizeInteger(int id) {
		String binary = Integer.toBinaryString(id);
		//add zeros
		if(binary.length() < Server.numOfBit){
			int numPadding = Server.numOfBit - binary.length();
			String zero  = "0";
			String temp = binary;
			for(int i = 0; i < numPadding; i++){
				temp = zero.concat(temp);
			}
			binary = temp;
		}
		return binary;
	}

	public static boolean isCommonKey(int id1, int id2, int index){
		String binary1 = binarizeInteger(id1);
		
		String binary2 = binarizeInteger(id2);
		
		if(binary1.charAt(binary1.length() - 1 - index) == binary2.charAt(binary2.length() - 1 - index)){
			return true;
		}
		else{
			return false;
		}
	}

	public static int howManyInCommon(Integer id1, int id2) {
		String binary1 = binarizeInteger(id1);
		
		String binary2 = binarizeInteger(id2);
		
		int count = 0;
		for(int i = 0; i < binary1.length(); i++){
			if(binary1.charAt(i) == binary2.charAt(i)){
				count++;
			}
		}
		return count;
	}

	public SecretKey getKek(int index, int bitValue) {
		return this.table[bitValue][index];
	}
}
