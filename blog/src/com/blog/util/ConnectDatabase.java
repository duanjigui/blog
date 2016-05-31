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
 * <p>此类用于连接数据库，获取连接和关闭连接</p>
 * @author duanjigui
 *@data 2016/5/15
 *@version 1.0
 */
public class ConnectDatabase {
		private String driver;  //驱动
		private String url;    //连接的url
		private String user;   //用户名
		private String password;   //密码
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
		//获取连接
		public Connection getConnection(){
			Connection connection=null;
			try {
				Class.forName(driver);
				connection= DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				System.out.println("没有安装数据库驱动程序！");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("账号或密码错误！");
				e.printStackTrace();
			}
			return connection;
		}
		/**
		 * <p>数据库资源释放</p>
		 * @param connection   连接connection
 		 * @param statement   执行sql语句的statement
		 * @param preparedStatement  预编译的statement
		 * @param resultSet  查询的结果集
		 * @throws SQLException  关闭异常
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
