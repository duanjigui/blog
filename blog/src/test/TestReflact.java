package test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/**
 * ����ɨ��ָ�����µ���
 * @author duanjigui
 *
 */
public class TestReflact {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		File file=new File("./src/com/blog/Bean");
		String[] filelist=	file.list();
		List<String> list=new ArrayList<>(); //��ɨ�赽��java�ļ����ص�list��
		for(String name:filelist){
			int i=name.lastIndexOf(".");
			String ClassName=	name.substring(0, i);
			list.add(ClassName);
		}
		//////
		for(String value:list){
		Class scanclass=	Class.forName("com.blog.bean."+value);
		Object object=	scanclass.newInstance();
		Method[] methods=	scanclass.getDeclaredMethods();
		for(Method m:methods){
			if (m.getName().startsWith("get")) {
				Object values=	m.invoke(object);
				System.out.println(values);
			}
		}
		System.out.println("-----------------");
		}
	
		
	}
}
