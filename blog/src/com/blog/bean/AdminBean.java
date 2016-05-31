package com.blog.bean;
/**
 * <p>管理员数据表信息</p>
 * @aut hor duanjigui
 *@time  2016/5/20
 *@version 1.0
 */
public class AdminBean {
		private String account; //账号
		private String password;//密码
		private String LastLoginTime;//上次登录时间
		private String Question; //用于找回密码，问题
		private String Answer; //答案
		private String status; //当前状态，是否登录
		private int id;  //获取id
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLastLoginTime() {
			return LastLoginTime;
		}
		public void setLastLoginTime(String lastLoginTime) {
			LastLoginTime = lastLoginTime;
		}
		public String getQuestion() {
			return Question;
		}
		public void setQuestion(String question) {
			Question = question;
		}
		public String getAnswer() {
			return Answer;
		}
		public void setAnswer(String answer) {
			Answer = answer;
		}
		
}
