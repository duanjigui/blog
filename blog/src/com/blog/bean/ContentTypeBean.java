package com.blog.bean;

public class ContentTypeBean {
	private int ContentTypeId;  //类型id
	private String ContentTypeName; //类型标签名
	private int ContentTypeTitleSum;//该类下的文章数目
	public int getContentTypeId() {
		return ContentTypeId;
	}
	public void setContentTypeId(int contentTypeId) {
		ContentTypeId = contentTypeId;
	}
	public String getContentTypeName() {
		return ContentTypeName;
	}
	public void setContentTypeName(String contentTypeName) {
		ContentTypeName = contentTypeName;
	}
	public int getContentTypeTitleSum() {
		return ContentTypeTitleSum;
	}
	public void setContentTypeTitleSum(int contentTypeTitleSum) {
		ContentTypeTitleSum = contentTypeTitleSum;
	}
	
}
