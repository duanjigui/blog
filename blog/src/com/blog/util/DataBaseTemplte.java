package com.blog.util;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
@Deprecated
/**
 *���ݿ����� ��д���������ʹ�����
 * @author duanjigui
 *
 */
public abstract class DataBaseTemplte {
	@Deprecated
	private PreparedStatement SqlPreparedMethod(String sql){
		PreparedStatement preparedStatement=null;
		ConnectDatabase connectDatabase=new ConnectDatabase();
		Connection connection=	connectDatabase.getConnection();
		try {
			preparedStatement=	connection.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("ִ��sql������");
			e.printStackTrace();
		}
		
		return preparedStatement;
	}
	@Deprecated
	public abstract Object   getResult (Object[] objects ,PreparedStatement preparedStatement);
	@Deprecated
	public Object  SqlQuery(String sql,Object[] objects){
		PreparedStatement preparedStatement=	SqlPreparedMethod(sql);
		return getResult(objects,preparedStatement);
	}
	@Deprecated
	public void  SqlUpdate(String sql,Object[] objects){
		
	}
	@Deprecated
	public void SqlDelete(String sql,Object[] objects){
		
	}
	
	
}
