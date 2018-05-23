<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Update your profile</h1>
	<form name="formupdate" action="update" method="post">
		enter login <input type="text" value="${user.login}" name="login" disabled/><br>
		enter password <input type="password" value="${user.password}" name="password" /><br>
		enter emailid <input type="text" value="${user.emailid}" name="emailid" /><br>
		<input type="submit" value="update" />

	</form>
</body>
</html>