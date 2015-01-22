package myCrypto;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import server.Server;

/**
 * Classe di supporto per criptare chiavi o un array di byte.
 *
 */
public class MyCrypto {
	
	public static String IV = "0123456789zxcvbn";
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
			try {
				cipher.init(Cipher.ENCRYPT_MODE, (SecretKeySpec) ciperKey, new IvParameterSpec(IV.getBytes("ISO-8859-1")));
			} catch (InvalidAlgorithmParameterException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
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
	
	public static byte[] decrypt(byte[] input, Cipher cipher, SecretKey ciperKey) {
		//prepare cipher
		try {
			try {
				cipher.init(Cipher.DECRYPT_MODE, (SecretKeySpec) ciperKey, new IvParameterSpec(IV.getBytes("ISO-8859-1")));
			} catch (InvalidAlgorithmParameterException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		byte[] decryption = null;
		
		try {
			decryption = cipher.doFinal(input);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			return null;
		}
		
		return decryption;
	}
	
	public static SecretKey decryptKey(byte[] input, Cipher cipher, SecretKey ciperKey) {
		byte[] byteKey = decrypt(input, cipher, ciperKey);
		SecretKey key = new SecretKeySpec(byteKey, server.Server.ALGORITHM);
		return key;
	}

	//-----------------------------------Assimmetric crypto-------------------------------------------------
	public static byte[] encryptKeyAsimmetric(SecretKey input, Cipher cipher, PublicKey ciperKey){
		byte[] byteKey = input.getEncoded();
		return encryptAsimmetric(byteKey, cipher, ciperKey);
	}
	
	public static byte[] encryptAsimmetric(byte[] input, Cipher cipher, PublicKey ciperKey){
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

	public static SecretKey decryptKeyAsimmetric(byte[] input, Cipher cipher, PrivateKey ciperKey) {
		byte[] byteKey = decryptAsimmetric(input, cipher, ciperKey);
		SecretKey key = new SecretKeySpec(byteKey, server.Server.ALGORITHM);
		return key;
	}
	
	public static byte[] decryptAsimmetric(byte[] input, Cipher cipher, PrivateKey ciperKey) {
		//prepare cipher
		try {
			cipher.init(Cipher.DECRYPT_MODE, ciperKey);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		byte[] decryption = null;
		
		try {
			decryption = cipher.doFinal(input);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return decryption;
	}
	
	
	//------------Simmetric encryption for string------------
	
	public static String encryptString(String toCrypt, SecretKey key){
		System.out.println("Encrypption key " + key);
		Cipher cipher = null; 
		try {
			cipher = Cipher.getInstance(Server.CHIPER_TRANSFORMATION);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} 
	
		byte[] byteString = toCrypt.getBytes();
		
		return Base64.getMimeEncoder().encodeToString(encrypt(byteString, cipher, key));
		
	}
	
	public static String decryptString(String toDecrypt, SecretKey key) {
		System.out.println("Decryption key " + key);
		Cipher cipher = null; 
		try {
			cipher = Cipher.getInstance(Server.CHIPER_TRANSFORMATION);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		
		byte[] byteString = Base64.getMimeDecoder().decode(toDecrypt.getBytes());
		
		byteString = decrypt(byteString, cipher, key);
		
		if(byteString == null){
			//decryption went wrong just return the string in input without doing anything
			return toDecrypt;
		}
		//else return decrypted string
		return new String(byteString, Charset.forName("ISO-8859-1"));

	}
}
