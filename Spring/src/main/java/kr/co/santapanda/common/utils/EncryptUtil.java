package kr.co.santapanda.common.utils;

import java.security.MessageDigest;

public class EncryptUtil {

	public static String SHA256(String s) {
		return encrypt(s, "SHA-256");
	}
	
	private static String encrypt(String s, String messageDigest) {
		try {
			MessageDigest md = MessageDigest.getInstance(messageDigest);
			md.update(s.getBytes());
			byte[] passBytes = md.digest();
//			StringBuffer sb = new StringBuffer();
//			for(byte b : passBytes) {
//				sb.append(Integer.toString((b&0xff) + 0x100, 16).substring(1));
//			}
			StringBuffer hexString = new StringBuffer();
			for(byte b : passBytes) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	};
}
