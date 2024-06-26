package com.soft.park.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/4 11:30
 * @description MD5密码加盐
 */
public class SaltMD5Utils {

	/**
	 * 生成普通的md5密码
	 * @param password
	 * @return
	 */
	public static String MD5(String password) {
		MessageDigest md5 = null;
		try {
			// 生成普通的MD5密码
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return "check jdk";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = password.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuilder hexValue = new StringBuilder();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * 加盐MD5
	 * @param password
	 * @return
	 */
	public static String generateSaltPassword(String password) {
		Random random = new Random();
		//生成一个16位的随机数，也就是所谓的盐
		/**
		 * 此处的盐也可以定义成一个系统复杂点的常量,而不是非要靠靠随机数随机出来 两种方式任选其一 例如下面这行代码:
		 * 盐加密 ：SALT的字符串是随意打的，目的是把MD5加密后的再次加密变得复杂
		 * public static final String SALT = "fskdhfiuhjfshfjhsad4354%@!@#%3";
		 **/
		StringBuilder stringBuilder = new StringBuilder(16);
		stringBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
		int len = stringBuilder.length();
		if (len < 16) {
			for (int i = 0; i < 16 - len; i++) {
				stringBuilder.append("0");
			}
		}
		// 生成盐
		String salt = stringBuilder.toString();
		//将盐加到明文中，并生成新的MD5码
		password = MD5(password + salt);
		//将盐混到新生成的MD5码中，之所以这样做是为了后期更方便的校验明文和秘文，也可以不用这么做，不过要将盐单独存下来，不推荐这种方式
		char[] cs = new char[48];
		for (int i = 0; i < 48; i += 3) {
			cs[i] = password.charAt(i / 3 * 2);
			char c = salt.charAt(i / 3);
			cs[i + 1] = c;
			cs[i + 2] = password.charAt(i / 3 * 2 + 1);
		}
		return new String(cs);
	}

	public static boolean verifySaltPassword(String password, String md5) {
		//先从MD5码中取出之前加的盐和加盐后生成的MD5码
		char[] cs1 = new char[32];
		char[] cs2 = new char[16];
		for (int i = 0; i < 48; i += 3) {
			cs1[i / 3 * 2] = md5.charAt(i);
			cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
			cs2[i / 3] = md5.charAt(i + 1);
		}
		String salt = new String(cs2);
		//比较二者是否相同
		return MD5(password + salt).equals(new String(cs1));
	}
}
