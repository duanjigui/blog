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
 * 建议采用私钥加密，公钥解密的方式来进行数据加密
 * 数据不能超过53个字节
 * @author duanjigui
 *
 */
public class TestRSA {
	public static void main(String[] args) throws Exception {
		Map<String, Object> keymap=RSACoder.initKey();
		byte[] privateKey=	RSACoder.getPrivateKey(keymap);
		byte[] publicKey=	RSACoder.getPublicKey(keymap);
		String s="a1101971076";  //账号Admin1101971076@qq.com
		//加密后的数据需要base64编码才行
		byte[] data=	RSACoder.encryptByPrivateKey(s.getBytes(), privateKey);
		System.out.println(Base64.encodeBase64String(data));
		byte[] data2=	RSACoder.encryptByPrivateKey(s.getBytes(), privateKey);
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("C:/Users/duanjigui/Desktop/a.txt")));
		objectOutputStream.writeObject(data);
		System.out.println(Base64.encodeBase64String(data2));
		System.err.println(new String(data));
		//直接就可以解密
		ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(new File("C:/Users/duanjigui/Desktop/a.txt")));
		byte[] data4=	(byte[]) objectInputStream.readObject();
		System.out.println(new String(RSACoder.decryptByPublicKey(data4, publicKey)));
	}
}
