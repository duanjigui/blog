package com.blog.service;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;

public class UploadService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String tempath=	request.getServletContext().getRealPath("/temp"); //获取缓存区的为准1
			
			FileUpload fileUploadServelt=new FileUpload();
			fileUploadServelt.setSizeThreshold(1000*1000*10);
			fileUploadServelt.setRepository(new File(tempath));
			fileUploadServelt.setRequest(request);
			try {
				fileUploadServelt.uploadFile();
			} catch (FileUploadException e) {
				e.printStackTrace();
			}	
			request.getRequestDispatcher("display.jsp").forward(request, response);
			
	}

}
