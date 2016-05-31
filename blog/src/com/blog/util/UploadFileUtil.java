package com.blog.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public abstract class UploadFileUtil {
	private int sizeThreshold;  //缓存区的大小
	private File repository;  //缓存区的位置
	private HttpServletRequest request;   //要解析的http请求
	public int getSizeThreshold() {
		return sizeThreshold;
	}

	public void setSizeThreshold(int sizeThreshold) {
		this.sizeThreshold = sizeThreshold;
	}

	public File getRepository() {
		return repository;
	}

	public void setRepository(File repository) {
		this.repository = repository;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
//处理上传文件的具体事项
	public void uploadFile() throws FileUploadException {
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(sizeThreshold);		//设置临时仓库的位置
		factory.setRepository(repository);    //设置仓库的大小
		ServletFileUpload servletFileUpload=new ServletFileUpload(factory);
		List<FileItem> list=	servletFileUpload.parseRequest(request);
		for (FileItem item:list) {
			if (item.isFormField()) {  //当上传的数据是表单时
				Map<String, String>map=parseFormRequest(item);
				request.setAttribute("map", map);   //当上传数据为表单的样式设置到request域中
			}else {                        //当上传的数据是文件时
				parseFileRequest(item);
			}
		}
	}
	//处理表单请求字段的请求,将其返回map类型的数据
	public  Map<String, String> parseFormRequest(FileItem item ){
		Map<String, String> map=new HashMap<>();
		String filedname=	item.getFieldName();
		String value=item.getName();
		map.put(filedname, value);
		return map;
		
	}
	//处理文件上传请求
	public abstract void parseFileRequest(FileItem item);
}
