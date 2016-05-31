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
	private int sizeThreshold;  //�������Ĵ�С
	private File repository;  //��������λ��
	private HttpServletRequest request;   //Ҫ������http����
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
//�����ϴ��ļ��ľ�������
	public void uploadFile() throws FileUploadException {
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(sizeThreshold);		//������ʱ�ֿ��λ��
		factory.setRepository(repository);    //���òֿ�Ĵ�С
		ServletFileUpload servletFileUpload=new ServletFileUpload(factory);
		List<FileItem> list=	servletFileUpload.parseRequest(request);
		for (FileItem item:list) {
			if (item.isFormField()) {  //���ϴ��������Ǳ�ʱ
				Map<String, String>map=parseFormRequest(item);
				request.setAttribute("map", map);   //���ϴ�����Ϊ������ʽ���õ�request����
			}else {                        //���ϴ����������ļ�ʱ
				parseFileRequest(item);
			}
		}
	}
	//����������ֶε�����,���䷵��map���͵�����
	public  Map<String, String> parseFormRequest(FileItem item ){
		Map<String, String> map=new HashMap<>();
		String filedname=	item.getFieldName();
		String value=item.getName();
		map.put(filedname, value);
		return map;
		
	}
	//�����ļ��ϴ�����
	public abstract void parseFileRequest(FileItem item);
}
