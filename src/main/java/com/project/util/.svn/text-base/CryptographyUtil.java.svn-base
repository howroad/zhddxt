package com.project.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 加密解密
 * 
 * @author 赵子墨
 *
 */
public class CryptographyUtil {

	/**
	 * 字符串base64加密
	 * @param str 字符串
	 * @return 加密后
	 */
	public static String encBase64(String str) {
		return Base64.encodeToString(str.getBytes());
	}
	
	/**
	 * base64解密
	 * @param str 解密前
	 * @return 解密后
	 */
	public static String decBase64(String str) {
		return Base64.decodeToString(str);
	}
	
	/**
	 * md5加密
	 * @param str 加密前
	 * @param salt 盐
	 * @return 加密后
	 */
	public static String md5(String str, String salt) {
		return new Md5Hash(str, salt).toString();
	}
	
}
