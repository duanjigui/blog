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
 * <p>�������ڶԲ�����53���ֽڵ����ݽ��м��ܺͽ���</p>
 * <p>�������˽Կ���ܣ���Կ���ܵķ�ʽ����</p>
 * @deprecated ���ʺϼ��ܽ��ܣ��ʺ��ڼ�ʱͨ�Ŷ����ݽ��м���
 * @author duanjigui
 *@time 2016/5/16
 *@version 1.0
 */
@Deprecated
public abstract class RSACoder {

	public static final String KEY_ALGORITHM="RSA";

	//��Կ
	private static final String PUBLIC_KEY="RSAPublicKey";
	//˽Կ
	private static final String PRIVATE_KEY="RSAPrivateKey";
	//��Կ����
	private static final int KEY_SIZE=512;
	/**
	 * ˽Կ����
	 * @param data  �����ܵ�����
	 * @param key   ˽Կ
	 * @return   byte[]  ��������
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
	 * ��Կ����
	 * @param data  �����ܵ�����
	 * @param key   ��Կ
	 * @return  byte[]  ���ܺ������
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
	 * ��Կ����
	 * @param data  �����ܵ�����
	 * @param key   ��Կ
	 * @return  byte[] ���ܺ������
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
	 * ˽Կ����
	 * @param data  �����ܵ�����
	 * @param key  ˽Կ
	 * @return  byte[] ���ܺ������
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
	 * ��ȡ˽Կ
	 * @param keymap  ��Կmap
	 * @return
	 */
	public static byte[] getPrivateKey(Map<String,Object> keymap) {
		Key key=	(Key) keymap.get(PRIVATE_KEY);
		return key.getEncoded();

	}
	/**
	 * ��ȡ��Կ
	 * @param keymap ��Կmap
	 * @return
	 */
	public static byte[] getPublicKey(Map<String, Object> keymap) {
		Key key=	(Key) keymap.get(PUBLIC_KEY);
		return key.getEncoded();
	}
	/**
	 * ��ʼ����Կ
	 * @return Map<String, Object> ��Կ��
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
