<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
	String str = "Hello";
	Date d = new Date(); 
	
%>
<h1><%= str %> <%= LocalDate.now() %> <%= d %></h1>
<center><%
	for(int i = 1; i < 6 ; i ++){
	%>
		<font size = "<%= i %>">Hello World</font><br>
	<%
	}
%>
</center>
</body>
</html>