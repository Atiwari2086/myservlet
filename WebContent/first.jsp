<%@page import="com.abhi.bean.LoginUser"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
</head>
<body>
	<%
		Date date = new Date();
		out.print("<h2 align = \"center\">" + date.toString() + "</h2>");
	%>

	<%
		LoginUser user = (LoginUser) session.getAttribute("user");
		System.out.println("user =" + user);
		if (user == null) {
	%><h2>you have not logged in</h2>
	<%
		} else {
	%><h1>
		Welcome
		<%=request.getParameter("login")%>
		to my first jsp page

	</h1>
	<%--<h2><a href="displayupdate">update your profile</a></h2> --%>

	<h2 style="color: Red;">
		<a href="displayupdate">update your profile</a>
	</h2>
	<%
		}
	%>


</body>
</html>