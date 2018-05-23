<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function checklogin() {
		val = formlogin.login.value;
		xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4) {
				user = xmlhttp.responseText;

				if (user == "login-incorrect") {
					alert("login-incorrect");
					
					
				}
			}

		}
		xmlhttp.open("GET", "login?login=" + val, true);
		xmlhttp.send(null);
	}
</script>

</head>
<body>
	<h1>
		hello
		<%=request.getParameter("mname")%>, Welcome to my home page
	</h1>

	<form name="formlogin" action="login" method="post">
		enter login <input type="text" value="" name="login" onblur="checklogin()" /><br> 
		enter password <input type="password" value="" name="password" /><br> 
		<input type="submit" value="Login" />
	</form>
</body>
</html>