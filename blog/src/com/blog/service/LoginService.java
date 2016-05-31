package com.blog.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.IadminDao;
import com.bolg.daoImpi.AdminDaoIMPI;
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String adminAccount=	request.getParameter("account");
			String adminPassword=	request.getParameter("password");
			String verfiyCode=request.getParameter("verfiyCode");
			String dispatchUrl="/admin/adminLogin.jsp";  //Ĭ�ϵĵ�¼ҳ��
			
			//�������֤����ʾ��Ϣ�����tip������
			if (null==request.getSession().getAttribute("verfiyCode")) {
				request.setAttribute("tip", "������ˢ��ҳ���Լ�����֤��");
			}else if (null==adminAccount||null==adminPassword||"".equals(adminAccount)||"".equals(adminPassword)) {
				request.setAttribute("tip","�˺Ż������벻��Ϊ�գ�");
			}else if (adminAccount.length()<6||adminPassword.length()<6) {
				request.setAttribute("tip","�˺Ż����벻��С��6λ��");
			}else if (!request.getSession().getAttribute("verfiyCode").equals(verfiyCode)) {
				request.setAttribute("tip", "��֤���������!");
			}else{
				IadminDao adminDao=new AdminDaoIMPI();
			if (!adminDao.judgeLogin(adminAccount, adminPassword)) {
				request.setAttribute("tip","�˺Ż����������");
			}else {
				adminDao.updateLoginTime(adminAccount);
				dispatchUrl="welcome.jsp";//��¼�ɹ���ҳ��
				request.setAttribute("adminAccount", adminAccount);
			}	
			
			}
			
			request.setAttribute("adminAccount", adminAccount);
			request.getRequestDispatcher(dispatchUrl).forward(request, response);
	}

}
