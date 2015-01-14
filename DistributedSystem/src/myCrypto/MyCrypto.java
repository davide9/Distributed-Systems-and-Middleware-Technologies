package myCrypto;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

public class MyCrypto {
	
	public static byte[] encryptKey(SecretKey input, Cipher cipher, SecretKey ciperKey){
		byte[] byteKey = input.getEncoded();
		return encrypt(byteKey, cipher, ciperKey);
	}
	
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
