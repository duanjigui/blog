package com.blog.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Coder {
	/**
	 * 
	 * @param data 加密的数据
	 * @return byte[]  
	 */
	public static byte[] encodeMD5 (String data) {
		return DigestUtils.md5(data);
	}
	
	public static String encodeMD5Hex(String data) {
		return DigestUtils.md5Hex(data);
	}
	
}
