<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Yahoo!</title>
</head>
<body>
	<form action="register.do" method="post">
	  <h1>Student Registration</h1>
      <label for="name" style="display: block">Name:</label>
      <input type="text" name="name" id="name" />
      <label for="email" style="display: block">Email:</label>
      <input type="email" name="email" id="email" />
      <label for="course" style="display: block">Course:</label>
      <input type="text" name="course" id="course" />
      <label for="age" style="display: block">Age:</label>
      <input type="text" name="age" id="age" />
      <label for="username" style="display: block">Username:</label>
      <input type="text" name="username" id="username" />
      <label for="password" style="display: block">Password:</label>
      <input type="password" name="password" id="password" />
      <button type="submit">Register</button>
    </form>
</body>
</html>