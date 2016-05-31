package test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/**
 * 测试扫描指定包下的类
 * @author duanjigui
 *
 */
public class TestReflact {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		File file=new File("./src/com/blog/Bean");
		String[] filelist=	file.list();
		List<String> list=new ArrayList<>(); //将扫描到的java文件加载到list下
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
