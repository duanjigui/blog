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
			String dispatchUrl="/admin/adminLogin.jsp";  //默认的登录页面
			
			//服务端验证，提示信息存放于tip属性中
			if (null==request.getSession().getAttribute("verfiyCode")) {
				request.setAttribute("tip", "请重新刷新页面以加载验证码");
			}else if (null==adminAccount||null==adminPassword||"".equals(adminAccount)||"".equals(adminPassword)) {
				request.setAttribute("tip","账号或者密码不能为空！");
			}else if (adminAccount.length()<6||adminPassword.length()<6) {
				request.setAttribute("tip","账号或密码不能小于6位！");
			}else if (!request.getSession().getAttribute("verfiyCode").equals(verfiyCode)) {
				request.setAttribute("tip", "验证码输入错误!");
			}else{
				IadminDao adminDao=new AdminDaoIMPI();
			if (!adminDao.judgeLogin(adminAccount, adminPassword)) {
				request.setAttribute("tip","账号或者密码错误！");
			}else {
				adminDao.updateLoginTime(adminAccount);
				dispatchUrl="welcome.jsp";//登录成功的页面
				request.setAttribute("adminAccount", adminAccount);
			}	
			
			}
			
			request.setAttribute("adminAccount", adminAccount);
			request.getRequestDispatcher(dispatchUrl).forward(request, response);
	}

}
