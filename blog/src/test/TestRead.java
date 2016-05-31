package test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestRead {
	public static void main(String[] args) throws IOException {
		File file=new File("./src/database_Info.ini");
		Properties properties=new Properties();
		properties.load(new FileReader(file));
		System.out.println(properties.getProperty("url"));
//		properties.setProperty("url", "root");
//		properties.setProperty("driver", "");
//		properties.setProperty("user", "");
//		properties.setProperty("password", "");
//		properties.store(new FileWriter(file), "This is a link database information");
//		System.out.println("have execute");
	}
}
