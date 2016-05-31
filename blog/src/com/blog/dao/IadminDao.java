package com.blog.dao;

import java.util.List;

import com.blog.bean.AdminBean;

public interface IadminDao {
	
		public boolean isLoginById(int id);  //判断登录的状态【当前用户是否已经登录】
		
		public  int  getAdminIdByAccount(String account);
		
		public AdminBean getAllinformationById(int id);
		
		public boolean judgeLogin(String account,String password);  //判断账号和密码是否正确
		
		public boolean setNewPasswordByAnswer(int id, String pasword,String answer);  //重置密码
		
		public List<AdminBean> getAllInformation();  //获取所有的管理员账号
		
		public Boolean updateLoginTime(String account);  //更新登录时间
}
