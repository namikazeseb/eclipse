package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello.php")
public class HelloServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		out.println("<h1>Hello "+name+" "+pwd+" "+" </h1>");
		
		if(pwd.equals("abc")&&name.equals("seb")) {
			
			String rememberMe = request.getParameter("rememberMe");
			if(rememberMe !=null && rememberMe.equals("yes")) {
				Cookie c1 = new Cookie("seb", Base64.getEncoder().encodeToString(name.getBytes()));
				c1.setMaxAge(60 * 60); //seconds
				Cookie c2 = new Cookie("abc", Base64.getEncoder().encodeToString(pwd.getBytes()));
				c2.setMaxAge(60 * 60); //seconds
				response.addCookie(c1);
				response.addCookie(c2);
				response.sendRedirect("welcome.html");
			}
				
		}
		else {	
			int attempt = 1; int allowed = 5;
			String page = "form.html";
				Cookie[] cookies = request.getCookies();
					if(cookies!=null){
						for(Cookie cookie : cookies) {
								if(cookie.getName().equals("attempt")) {
							attempt = Integer.parseInt(cookie.getValue());
							attempt ++;
					break;
				}
				{
				if(attempt >= allowed)
					page = "lock.html";
		} 
						}
					}
					
				else {
						Cookie cookie1 = new Cookie("attempt", String.valueOf(attempt));
						cookie1.setMaxAge(5*30);
						response.addCookie(cookie1);
						response.sendRedirect("form.html");
			}		
						
		out.println("<h1>Hello Everyone </h1>");
					
				
			
		}}}
