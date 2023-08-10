<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Yahoo!</title>
</head>
<body>
	<p><font color="red"><%= request.getAttribute("name") %></font></p>
	<!-- form action="/BasicWeb/servelt1.do" method="GET" -->
	<form action="/login.do" method="POST">
	name : <input name="name" type="text" />
	password: <input name="password" type="password" />
	<input type="submit" />
	</form>
</body>
</html>