package com.blog.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Coder {
	/**
	 * 
	 * @param data ���ܵ�����
	 * @return byte[]  
	 */
	public static byte[] encodeMD5 (String data) {
		return DigestUtils.md5(data);
	}
	
	public static String encodeMD5Hex(String data) {
		return DigestUtils.md5Hex(data);
	}
	
}
