package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;

import com.blog.util.RSACoder;
/**
 * �������˽Կ���ܣ���Կ���ܵķ�ʽ���������ݼ���
 * ���ݲ��ܳ���53���ֽ�
 * @author duanjigui
 *
 */
public class TestRSA {
	public static void main(String[] args) throws Exception {
		Map<String, Object> keymap=RSACoder.initKey();
		byte[] privateKey=	RSACoder.getPrivateKey(keymap);
		byte[] publicKey=	RSACoder.getPublicKey(keymap);
		String s="a1101971076";  //�˺�Admin1101971076@qq.com
		//���ܺ��������Ҫbase64�������
		byte[] data=	RSACoder.encryptByPrivateKey(s.getBytes(), privateKey);
		System.out.println(Base64.encodeBase64String(data));
		byte[] data2=	RSACoder.encryptByPrivateKey(s.getBytes(), privateKey);
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("C:/Users/duanjigui/Desktop/a.txt")));
		objectOutputStream.writeObject(data);
		System.out.println(Base64.encodeBase64String(data2));
		System.err.println(new String(data));
		//ֱ�ӾͿ��Խ���
		ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(new File("C:/Users/duanjigui/Desktop/a.txt")));
		byte[] data4=	(byte[]) objectInputStream.readObject();
		System.out.println(new String(RSACoder.decryptByPublicKey(data4, publicKey)));
	}
}
