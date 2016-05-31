package com.blog.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;

import com.blog.bean.ImageBean;
import com.blog.util.ConnectDatabase;
import com.blog.util.UploadFileUtil;
/**
 * 实现了上传文件部分的实现
 * @author duanjigui
 *@version 1.0
 */

public class FileUpload extends UploadFileUtil{

	@Override
	public void parseFileRequest(FileItem item) {
		String value=	item.getName();  //上传文件的值（value）
		String filename=	value.substring(value.lastIndexOf("\\")+1); //文件名
		String fileType=filename.substring(filename.lastIndexOf(".")+1); //文件类型
		String newFileName=	UUID.randomUUID()+"."+fileType;  //以uuid编码的文件名，为了防止重名
		HttpServletRequest request=	super.getRequest();
		String uploadMenu=	request.getServletContext().getRealPath("/upload"); //upload文件的路径
		File uploadMenuFile=new File(uploadMenu);
		if (!uploadMenuFile.exists()) {     //当没有文件时创建文件
			uploadMenuFile.mkdir();
		}
		File uplodeFile=new File(uploadMenu,newFileName);
		//这里需要插入一些数据库存储持久化，将文件对映关系插进去
		//  filename 真实文件名   newFileName在上传到upload中的名字
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
		String now=		simpleDateFormat.format(new Date());  //当前日期
		ImageBean imageBean=new ImageBean();
		imageBean.setImageclickNun(0);
		imageBean.setImageSaveName(newFileName);
		imageBean.setImageSavePath(uploadMenu);
		imageBean.setImageTrueName(filename);
		imageBean.setImageUploadTime(now);
		imageBean.setImageUploadUser("root"); //这里变量，后期需要修改
		imageBean.setImageType("景观");  //这里变量，后期也需要修改
		ConnectDatabase connectDatabase=new ConnectDatabase();
		Connection connection=	connectDatabase.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql="insert into bolgImage (ImageTrueName,ImageSaveName,ImageSavePath,ImageType,ImageUploadTime,ImageUploadUser,ImageclickNun) values(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=	connection.prepareStatement(sql);
			preparedStatement.setString(1, imageBean.getImageTrueName());
			preparedStatement.setString(2, imageBean.getImageSaveName());
			preparedStatement.setString(3, imageBean.getImageSavePath());
			preparedStatement.setString(4, imageBean.getImageType());
			preparedStatement.setString(5, imageBean.getImageUploadTime());
			preparedStatement.setString(6, imageBean.getImageUploadUser());
			preparedStatement.setInt(7, imageBean.getImageclickNun());
			preparedStatement.executeUpdate();
			connection.commit();
			connectDatabase.closeDatabaseResource(connection, null, preparedStatement, null);
		} catch (SQLException e1) {
				try {
					connection.rollback();
				} catch (SQLException e) {
					System.out.println("回滚失败!");
					e.printStackTrace();
				}
				e1.printStackTrace();
				System.out.println("error!");
		}
	
		System.out.println(uploadMenu);
		
		//
		if (!uplodeFile.exists()) {
			try {
				uplodeFile.createNewFile();   //创建存储到upload文件夹下的文件
			} catch (IOException e) {
				System.out.println("创建文件失败！");
			}
		}
		try {
			FileUtils.copyInputStreamToFile(item.getInputStream(), uplodeFile);  //复制信息
		} catch (IOException e) {
			System.out.println("复制文件失败！");
		}
	}



}
