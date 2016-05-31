package com.blog.bean;
/**
 *<p> 用来保存文件的上传信息</p>
 * @author duanjigui
 *@version 1.0
 */
public class ImageBean {
	private int ImageNum;  //主键
	private String ImageTrueName;  //图片的真实名字
	private String ImageSaveName;  //存在upload文件目录下的名字
	private String ImageSavePath;  //文件存储的位置
	private String	ImageType;   //文件属于哪个标签的类别
	private String ImageUploadTime;  //文件上传的时间
	private String ImageUploadUser;  //文件上传者
	private int ImageclickNun;  //文件点击次数
	public int getImageNum() {
		return ImageNum;
	}
	public void setImageNum(int imageNum) {
		ImageNum = imageNum;
	}
	public String getImageTrueName() {
		return ImageTrueName;
	}
	public void setImageTrueName(String imageTrueName) {
		ImageTrueName = imageTrueName;
	}
	public String getImageSaveName() {
		return ImageSaveName;
	}
	public void setImageSaveName(String imageSaveName) {
		ImageSaveName = imageSaveName;
	}
	public String getImageSavePath() {
		return ImageSavePath;
	}
	public void setImageSavePath(String imageSavePath) {
		ImageSavePath = imageSavePath;
	}
	public String getImageType() {
		return ImageType;
	}
	public void setImageType(String imageType) {
		ImageType = imageType;
	}
	public String getImageUploadTime() {
		return ImageUploadTime;
	}
	public void setImageUploadTime(String imageUploadTime) {
		ImageUploadTime = imageUploadTime;
	}
	public String getImageUploadUser() {
		return ImageUploadUser;
	}
	public void setImageUploadUser(String imageUploadUser) {
		ImageUploadUser = imageUploadUser;
	}
	public int getImageclickNun() {
		return ImageclickNun;
	}
	public void setImageclickNun(int imageclickNun) {
		ImageclickNun = imageclickNun;
	}
	
}
