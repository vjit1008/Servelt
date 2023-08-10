<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Yahoo!</title>
</head>
<body>
	<h1>Student Registered!</h1>
	<h3>Search for students</h3>
    <form action="/search.do" method="post">
      <label for="search" style="display: block">Name:</label>
      <input type="text" name="search" id="search" />
      <button type="submit"></button>
    </form>
</body>
</html>
