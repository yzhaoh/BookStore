package com.bs.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类，用于加密密码等明文文本。
 * 
 * @author 若水
 *
 */
public class MD5 {
	private static String pwdMD5;

	/**
	 * 获取MD5值
	 * 
	 * @param plainText
	 *            需要加密的字符串
	 * @return 加密后的MD5值
	 */
	public static String getMd5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			pwdMD5 = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return pwdMD5.toString();
	}

}
