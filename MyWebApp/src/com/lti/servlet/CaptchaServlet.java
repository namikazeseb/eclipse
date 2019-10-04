package com.lti.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CaptchaServlet
 */
@WebServlet("/CaptchaServlet")
public class CaptchaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");//MIME type
		ServletOutputStream out = response.getOutputStream();
		// logic for generating random captcha
		String str = "01234756789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String captcha = "";
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 5 ; i ++) {
			int pos = (int)Math.floor(Math.random() * str.length());
			sb.append(str.charAt(pos));
		}
		
		captcha = sb.toString();
		
		//generating an image
		BufferedImage img = new BufferedImage(150, 50, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();   // for drawing an  image use this method
		g.setColor(Color.RED);					
		g.fillRect(0, 0, 150, 50);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("TimesNewRoman",Font.BOLD, 30));
		g.drawString(captcha, 30, 30);
		
		ImageIO.write(img, "jpeg", out);
		
	}

	
}
