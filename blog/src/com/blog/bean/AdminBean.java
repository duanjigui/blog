package com.blog.bean;
/**
 * <p>����Ա���ݱ���Ϣ</p>
 * @aut hor duanjigui
 *@time  2016/5/20
 *@version 1.0
 */
public class AdminBean {
		private String account; //�˺�
		private String password;//����
		private String LastLoginTime;//�ϴε�¼ʱ��
		private String Question; //�����һ����룬����
		private String Answer; //��
		private String status; //��ǰ״̬���Ƿ��¼
		private int id;  //��ȡid
		
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
