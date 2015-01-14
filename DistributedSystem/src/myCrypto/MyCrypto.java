package myCrypto;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

/**
 * Classe di supporto per criptare chiavi o un array di byte.
 *
 */
public class MyCrypto {
	
	/**
	 * 
	 * @param input chiave da crittare
	 * @param cipher il cifratore che si vuole usare
	 * @param ciperKey la chiave per il cifratore
	 * @return l'array di byte crittato
	 */
	public static byte[] encryptKey(SecretKey input, Cipher cipher, SecretKey ciperKey){
		byte[] byteKey = input.getEncoded();
		return encrypt(byteKey, cipher, ciperKey);
	}
	
	/**
	 * 
	 * @param input array di byte da crittare
	 * @param cipher il cifratore che si vuole usare
	 * @param ciperKey la chiave per il cifratore
	 * @return l'array di byte crittato
	 */
	public static byte[] encrypt(byte[] input, Cipher cipher, SecretKey ciperKey){
		//prepare cipher
		try {
			cipher.init(Cipher.ENCRYPT_MODE, ciperKey);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		byte[] encryption = null;
		
		try {
			encryption = cipher.doFinal(input);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return encryption;
	}

}
