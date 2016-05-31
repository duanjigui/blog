package com.blog.bean;

public class ContentManageBean {
		private int contentId;  //博客标识
		private String contentTitle; //博客标题
		private String ContentMessage; //博客内容
		private int contentNum; //浏览次数
		private String contentDate;//发布日期
		private String contentType; //文章类别
		public int getContentId() {
			return contentId;
		}
		public void setContentId(int contentId) {
			this.contentId = contentId;
		}
		public String getContentTitle() {
			return contentTitle;
		}
		public void setContentTitle(String contentTitle) {
			this.contentTitle = contentTitle;
		}
		public String getContentMessage() {
			return ContentMessage;
		}
		public void setContentMessage(String contentMessage) {
			ContentMessage = contentMessage;
		}
		public int getContentNum() {
			return contentNum;
		}
		public void setContentNum(int contentNum) {
			this.contentNum = contentNum;
		}
		public String getContentDate() {
			return contentDate;
		}
		public void setContentDate(String countDate) {
			this.contentDate = countDate;
		}
		public String getContentType() {
			return contentType;
		}
		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
		
		
}
