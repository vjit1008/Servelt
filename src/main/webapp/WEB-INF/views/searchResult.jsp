<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.neebalgurukul.model.Student" %>
<html>
<head>
<title>Yahoo!</title>
</head>
<body>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Age</th>
            <th>Delete</th>
        </tr>
        <%
            java.util.List<Student> studentList = (java.util.List<Student>) request.getAttribute("searchResult");
            for (Student student : studentList) {
        %>
            <tr>
                <td><%= student.getName() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getCourse() %></td>
                <td><%= student.getAge() %></td>
                <td>
                    <form action="/delete.do" method="post">
                        <input type="hidden" name="deleteUsername" value="<%= student.getUsername() %>">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
