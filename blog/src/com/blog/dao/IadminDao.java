package com.blog.dao;

import java.util.List;

import com.blog.bean.AdminBean;

public interface IadminDao {
	
		public boolean isLoginById(int id);  //�жϵ�¼��״̬����ǰ�û��Ƿ��Ѿ���¼��
		
		public  int  getAdminIdByAccount(String account);
		
		public AdminBean getAllinformationById(int id);
		
		public boolean judgeLogin(String account,String password);  //�ж��˺ź������Ƿ���ȷ
		
		public boolean setNewPasswordByAnswer(int id, String pasword,String answer);  //��������
		
		public List<AdminBean> getAllInformation();  //��ȡ���еĹ���Ա�˺�
		
		public Boolean updateLoginTime(String account);  //���µ�¼ʱ��
}
