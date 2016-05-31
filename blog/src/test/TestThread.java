package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestThread extends Thread {
	@Override
	public void run() {
			try {
				URL url=new URL("http://119.29.9.200");
			HttpURLConnection connection=	(HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			
			System.out.println("sadsd");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			TestThread testThread=new TestThread();
			testThread.start();
		}
		System.err.println("execute!");
	}
}
