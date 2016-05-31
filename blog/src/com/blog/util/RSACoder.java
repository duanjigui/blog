package com.blog.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
/**
 * <p>该类用于对不超过53个字节的数据进行加密和解密</p>
 * <p>建议采用私钥加密，公钥解密的方式进行</p>
 * @deprecated 不适合加密解密，适合于即时通信对内容进行加密
 * @author duanjigui
 *@time 2016/5/16
 *@version 1.0
 */
@Deprecated
public abstract class RSACoder {

	public static final String KEY_ALGORITHM="RSA";

	//公钥
	private static final String PUBLIC_KEY="RSAPublicKey";
	//私钥
	private static final String PRIVATE_KEY="RSAPrivateKey";
	//秘钥长度
	private static final int KEY_SIZE=512;
	/**
	 * 私钥解密
	 * @param data  带解密的数据
	 * @param key   私钥
	 * @return   byte[]  解密数据
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data,byte[] key) throws Exception {
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory=	KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey privateKey=	keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Cipher cipher=	Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}
	/**
	 * 公钥解密
	 * @param data  带解密的数据
	 * @param key   公钥
	 * @return  byte[]  解密后的数据
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data,byte[] key) throws Exception {
		X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(key);
		KeyFactory factory=	KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicKey=	factory.generatePublic(x509EncodedKeySpec);
		Cipher cipher=	Cipher.getInstance(factory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE,publicKey);
		return cipher.doFinal(data);
	}
	/**
	 * 公钥加密
	 * @param data  代价密的数据
	 * @param key   公钥
	 * @return  byte[] 加密后的数据
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data,byte[] key) throws Exception {
		X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(key);
		KeyFactory keyFactory=	KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicKey=keyFactory.generatePublic(x509EncodedKeySpec);
		Cipher cipher=	Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}
	/**
	 * 私钥加密
	 * @param data  代价密的数据
	 * @param key  私钥
	 * @return  byte[] 加密后的数据
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data,byte[] key) throws Exception {
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory=	KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey privateKey=	keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Cipher cipher=	Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}
	/**
	 * 获取私钥
	 * @param keymap  秘钥map
	 * @return
	 */
	public static byte[] getPrivateKey(Map<String,Object> keymap) {
		Key key=	(Key) keymap.get(PRIVATE_KEY);
		return key.getEncoded();

	}
	/**
	 * 获取公钥
	 * @param keymap 秘钥map
	 * @return
	 */
	public static byte[] getPublicKey(Map<String, Object> keymap) {
		Key key=	(Key) keymap.get(PUBLIC_KEY);
		return key.getEncoded();
	}
	/**
	 * 初始化秘钥
	 * @return Map<String, Object> 秘钥集
	 * @throws Exception
	 */
	public static Map<String, Object> initKey() throws Exception {
		KeyPairGenerator keyPairGenerator=	KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGenerator.initialize(KEY_SIZE);
		KeyPair keyPair=	keyPairGenerator.generateKeyPair();
		RSAPublicKey publicKey=	(RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey=	(RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> map=new HashMap<>(2);
		map.put(PUBLIC_KEY, publicKey);
		map.put(PRIVATE_KEY,privateKey);
		return map;
	}
}
