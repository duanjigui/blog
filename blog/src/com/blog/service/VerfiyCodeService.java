package com.blog.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VerfiyCodeService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");  //����ͼƬ����
		response.setHeader("Pragma", "No-cache");  
		response.setHeader("Cache-Control", "No-cache");  
		response.setDateHeader("Expires", 0);    //�������
	  
		String [] library={"0","1","2","3","4","5","6","7","8","9","a","b","c","d",
								"e","f","g","h","i","j","k","l","m","n","o","p","q","r",
								"s","t","u","v","w","x","y","z","A","B","C","D","E","F",
								"G","H","I","J","K","L","M","N","O","P","Q","R","S","T",
								"U","V","W","X","Y","Z"
								};  //��62���ַ�������֤��������ЩԪ�ع���
			StringBuilder builder=new StringBuilder();
			for(int i=0;i<4;i++){
				int num=	(int) (Math.random()*62);
				builder.append(library[num]);
			}
			String value=builder.toString();
			request.getSession().setAttribute("verfiyCode",value);
			BufferedImage bufferedImage=new BufferedImage(170, 170, BufferedImage.TYPE_INT_RGB);
			Graphics g=	bufferedImage.getGraphics();
			g.setColor(Color.white);
			g.fillRect(0, 0, 170,170);  //���Ǻ�����ͼƬ����ɫһ���ľ��Σ����ã�����Ĭ�ϵĺ�ɫ�ı���
			g.setColor(Color.red);
			g.setFont(new Font("΢���ź�", Font.BOLD, 40));
			g.drawString(value, 10,160);  //�����ɵ���֤����Ƶ�������
			g.setColor(Color.WHITE);
			g.dispose();//�ͷŻ滭����Դ
			OutputStream outputStream=	response.getOutputStream();
			ImageIO.createImageOutputStream(outputStream);
			ImageIO.write(bufferedImage, "JPEG", outputStream);   //ͨ��imageio��ͼƬ��jpeg��ʽ������������
	}

}
