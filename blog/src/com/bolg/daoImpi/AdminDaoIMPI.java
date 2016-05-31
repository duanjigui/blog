package com.bolg.daoImpi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blog.bean.AdminBean;
import com.blog.dao.IadminDao;
import com.blog.util.ConnectDatabase;
import com.blog.util.MD5Coder;

public class AdminDaoIMPI extends ConnectDatabase implements IadminDao {

	
	@Override
	public boolean isLoginById(int id) {
		boolean flag=false;
		flag= getAllinformationById(id).getStatus().equals("true")? true:false;
		return  flag;
	}
	@Override
	public int getAdminIdByAccount(String account) {
		int id=0;
		List<AdminBean> list=	this.getAllInformation();
		for(AdminBean adminBean:list){
			if (adminBean.getAccount().equals(MD5Coder.encodeMD5Hex(account))) {
					id=adminBean.getId();
					break;
			}
		}
		
		return id;
	}

	@Override
	public AdminBean getAllinformationById(int id) {
		String sql="select * from admin where id =?";
		AdminBean adminBean=new AdminBean();
		Connection connection=	super.getConnection();
		try{
			PreparedStatement preparedStatement=	connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=	preparedStatement.executeQuery();
			while (resultSet.next()) {
				adminBean.setId(id);
				String enctryAccount=resultSet.getString("account");
				adminBean.setAccount(enctryAccount);
				String enctryPassword=resultSet.getString("password");
				adminBean.setPassword(enctryPassword);
				adminBean.setLastLoginTime(resultSet.getString("LastLoginTime"));
				adminBean.setQuestion(resultSet.getString("Question"));
				adminBean.setAnswer(resultSet.getString("Answer"));
				adminBean.setStatus(resultSet.getString("status"));
			}
			super.closeDatabaseResource(connection, null, preparedStatement, resultSet);
		}catch(SQLException e){
			System.out.println("");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminBean;
	}
	@Override
	public boolean judgeLogin(String account, String password) {
		boolean flag=false;
		List<AdminBean> list=	this.getAllInformation();
		for(AdminBean adminBean:list ){
			if (adminBean.getAccount().equals(MD5Coder.encodeMD5Hex(account))&&adminBean.getPassword().equals(MD5Coder.encodeMD5Hex(password))) {
				flag=true;
				break;
			}
		}
		return flag;
	}

	@Override
	public List<AdminBean> getAllInformation() {
		List<AdminBean> list=new ArrayList<>();
		String sql="select * from admin";
		Connection connection=	super.getConnection();
		try {
			Statement statement=	connection.createStatement();
			ResultSet resultSet=	statement.executeQuery(sql);
			while (resultSet.next()) {
				AdminBean adminBean=new AdminBean();
				adminBean.setId(resultSet.getInt("adminId"));
				String enctryAccount=resultSet.getString("account");
				adminBean.setAccount(enctryAccount);
				String enctryPassword=resultSet.getString("password");
				adminBean.setPassword(enctryPassword);
				adminBean.setLastLoginTime(resultSet.getString("LastLoginTime"));
				adminBean.setQuestion(resultSet.getString("Question"));
				adminBean.setAnswer(resultSet.getString("Answer"));
				adminBean.setStatus(resultSet.getString("status"));
				list.add(adminBean);
			}
			super.closeDatabaseResource(connection, statement, null, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean setNewPasswordByAnswer(int id,String pasword, String answer) {
		Boolean bflg=false;
		AdminBean adminBean=	getAllinformationById(id);
		if (null== answer) {
			return false;
		}
		if (answer.equals(adminBean.getAnswer())) {
			String sql="update admin set password=? where adminId =? ";
			Connection connection=	super.getConnection();
			try {
				PreparedStatement preparedStatement=	connection.prepareStatement(sql);
				preparedStatement.setString(1, MD5Coder.encodeMD5Hex(pasword));
				preparedStatement.setInt(2, id);
				int flag=preparedStatement.executeUpdate();
				if (flag==1) {
					bflg=true;
				}
				super.closeDatabaseResource(connection, null, preparedStatement, null);
			} catch (SQLException e) {
				//e.printStackTrace();
				System.err.println("更新失败！");
				bflg=false;
			}
		}
		return bflg;
	}
	@Override
	public Boolean updateLoginTime(String account) {
		boolean bflg=false;
			int id=	this.getAdminIdByAccount(account);
			String sql="update admin set LastLoginTime=? where adminId =? ";
			Connection connection=	super.getConnection();
			try {
				PreparedStatement preparedStatement=	connection.prepareStatement(sql);
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String data=	dateFormat.format(new Date());
				preparedStatement.setString(1,data );
				preparedStatement.setInt(2, id);
				int flag=preparedStatement.executeUpdate();
				if (flag==1) {
					bflg=true;
				}
				super.closeDatabaseResource(connection, null, preparedStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("更新失败！");
				bflg=false;
			}
		
		return bflg;
	}

}
