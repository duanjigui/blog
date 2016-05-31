package com.blog.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * <p>���������������ݿ⣬��ȡ���Ӻ͹ر�����</p>
 * @author duanjigui
 *@data 2016/5/15
 *@version 1.0
 */
public class ConnectDatabase {
		private String driver;  //����
		private String url;    //���ӵ�url
		private String user;   //�û���
		private String password;   //����
		private Properties properties=new Properties();
		public	ConnectDatabase(){
			try {
				InputStream inputStream=	ConnectDatabase.class.getClassLoader().getResourceAsStream("database_Info.ini");
				properties.load(inputStream);
				this.driver=properties.getProperty("driver");
				this.url=properties.getProperty("url");
				this.user=properties.getProperty("user");
				this.password=properties.getProperty("password");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//��ȡ����
		public Connection getConnection(){
			Connection connection=null;
			try {
				Class.forName(driver);
				connection= DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				System.out.println("û�а�װ���ݿ���������");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("�˺Ż��������");
				e.printStackTrace();
			}
			return connection;
		}
		/**
		 * <p>���ݿ���Դ�ͷ�</p>
		 * @param connection   ����connection
 		 * @param statement   ִ��sql����statement
		 * @param preparedStatement  Ԥ�����statement
		 * @param resultSet  ��ѯ�Ľ����
		 * @throws SQLException  �ر��쳣
		 */
		public void closeDatabaseResource(Connection connection,Statement statement,PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException {
			if (resultSet!=null) {
				resultSet.close();
			}
			if (preparedStatement!=null) {
				preparedStatement.close();
			}
			if (statement!=null) {
				statement.close();
			}
			if (connection!=null) {
				connection.close();
			}
		}
		
}
