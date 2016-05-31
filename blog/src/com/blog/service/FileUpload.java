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
 * ʵ�����ϴ��ļ����ֵ�ʵ��
 * @author duanjigui
 *@version 1.0
 */

public class FileUpload extends UploadFileUtil{

	@Override
	public void parseFileRequest(FileItem item) {
		String value=	item.getName();  //�ϴ��ļ���ֵ��value��
		String filename=	value.substring(value.lastIndexOf("\\")+1); //�ļ���
		String fileType=filename.substring(filename.lastIndexOf(".")+1); //�ļ�����
		String newFileName=	UUID.randomUUID()+"."+fileType;  //��uuid������ļ�����Ϊ�˷�ֹ����
		HttpServletRequest request=	super.getRequest();
		String uploadMenu=	request.getServletContext().getRealPath("/upload"); //upload�ļ���·��
		File uploadMenuFile=new File(uploadMenu);
		if (!uploadMenuFile.exists()) {     //��û���ļ�ʱ�����ļ�
			uploadMenuFile.mkdir();
		}
		File uplodeFile=new File(uploadMenu,newFileName);
		//������Ҫ����һЩ���ݿ�洢�־û������ļ���ӳ��ϵ���ȥ
		//  filename ��ʵ�ļ���   newFileName���ϴ���upload�е�����
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
		String now=		simpleDateFormat.format(new Date());  //��ǰ����
		ImageBean imageBean=new ImageBean();
		imageBean.setImageclickNun(0);
		imageBean.setImageSaveName(newFileName);
		imageBean.setImageSavePath(uploadMenu);
		imageBean.setImageTrueName(filename);
		imageBean.setImageUploadTime(now);
		imageBean.setImageUploadUser("root"); //���������������Ҫ�޸�
		imageBean.setImageType("����");  //�������������Ҳ��Ҫ�޸�
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
					System.out.println("�ع�ʧ��!");
					e.printStackTrace();
				}
				e1.printStackTrace();
				System.out.println("error!");
		}
	
		System.out.println(uploadMenu);
		
		//
		if (!uplodeFile.exists()) {
			try {
				uplodeFile.createNewFile();   //�����洢��upload�ļ����µ��ļ�
			} catch (IOException e) {
				System.out.println("�����ļ�ʧ�ܣ�");
			}
		}
		try {
			FileUtils.copyInputStreamToFile(item.getInputStream(), uplodeFile);  //������Ϣ
		} catch (IOException e) {
			System.out.println("�����ļ�ʧ�ܣ�");
		}
	}



}
