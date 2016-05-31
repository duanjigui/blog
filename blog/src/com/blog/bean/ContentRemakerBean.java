package com.blog.bean;

public class ContentRemakerBean {
		private int ContentRemakeId; //评论id
		private String ContentRemake;//评论内容
		private int ContentManagaId;//评论文章的id
		private String  ContentRemakeDate;//评论日期
		private String ContentRemakeIp;//评论者的ip地址
		public int getContentRemakeId() {
			return ContentRemakeId;
		}
		public void setContentRemakeId(int contentRemakeId) {
			ContentRemakeId = contentRemakeId;
		}
		public String getContentRemake() {
			return ContentRemake;
		}
		public void setContentRemake(String contentRemake) {
			ContentRemake = contentRemake;
		}
		public int getContentManagaId() {
			return ContentManagaId;
		}
		public void setContentManagaId(int contentManagaId) {
			ContentManagaId = contentManagaId;
		}
		public String getContentRemakeDate() {
			return ContentRemakeDate;
		}
		public void setContentRemakeDate(String contentRemakeDate) {
			ContentRemakeDate = contentRemakeDate;
		}
		public String getContentRemakeIp() {
			return ContentRemakeIp;
		}
		public void setContentRemakeIp(String contentRemakeIp) {
			ContentRemakeIp = contentRemakeIp;
		}
		
}
