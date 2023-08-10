package com.neebalgurukul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neebalgurukul.exception.IdNotFoundException;
import com.neebalgurukul.model.Student;

public class StudentDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    DataSource ds = new DataSource();

    public List<Student> getStudentDetails() throws SQLException {
	String query = "Select * from students";
	conn = ds.getConnection();
	List<Student> StudentList = new ArrayList<>();
	try {
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if (rs != null) {
		while (rs.next()) {
		    Student obj = new Student();
		    obj.setName(rs.getString("name"));
		    obj.setEmail(rs.getString("email"));
		    obj.setCourse(rs.getString("course"));
		    obj.setAge(rs.getInt("age"));
		    obj.setUsername(rs.getString("username"));
//		    System.out.println(obj.getUname() + ", " + obj.getPswd());
		    StudentList.add(obj);
		}
	    }
	    return StudentList;
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	    return null;
	} finally {

	    conn.close();
	}
    }

    public boolean checkEmailExist(String email) {
	boolean doesExist = false;
	conn = ds.getConnection();
	String query = "select * from where email = ?";

	try {
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, email);
	    int i = pstmt.executeUpdate();
	    if (i != 0) {
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
		    doesExist = true;
		}
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return doesExist;
    }

    public boolean insertDetails(Student student, String username) throws SQLException {
	conn = ds.getConnection();
	String query = "insert into students(name, email, course, age, username) values(?, ?, ?, ?,?)";
	int i = 0;
	int studentId;
	boolean studentCreated = false;
	try {

	    if (checkEmailExist(student.getEmail())) {
		System.out.println("Email already exists in the database");
	    } else {
		PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, student.getName());
		pstmt.setString(2, student.getEmail());
		pstmt.setString(3, student.getCourse());
		pstmt.setInt(4, student.getAge());
		pstmt.setString(5, username);

		i = pstmt.executeUpdate();
		if (i != 0) {
		    ResultSet rs = pstmt.getGeneratedKeys();
		    if (rs.next()) {
			studentId = rs.getInt(1);
			studentCreated = true;
			System.out.println("StudentId = " + studentId);
		    }
		}
	    }
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	} finally {
	    conn.close();
	}
	return studentCreated;
    }

    public void deleteHard(int id) throws SQLException, IdNotFoundException {
	String query = "delete from students where id=?";
	conn = ds.getConnection();
	try {
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setInt(1, id);
	    int i = pstmt.executeUpdate();
	    if (i != 0) {
		System.out.println(id + " is deleted.");
	    } else {
		throw new IdNotFoundException(id + " not found in the database.");
	    }
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	} finally {
	    conn.close();
	}
    }

    public void updateCourse(int id, String course) throws SQLException, IdNotFoundException {
	String query = "update students set course=? where id=?";
	conn = ds.getConnection();
	try {
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, course);
	    pstmt.setInt(2, id);

	    int i = pstmt.executeUpdate();
	    if (i != 0) {
		System.out.println("Course of " + id + " is changed to " + course);
	    } else {
		throw new IdNotFoundException(id + " not found in the database.");
	    }
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	} finally {
	    conn.close();
	}
    }

    public boolean getUsernameDetails(String username) {
	boolean flag = false;
	String query = "select * from students where username = ?";
	conn = ds.getConnection();

	try {
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, username);
	    ResultSet rs = pstmt.executeQuery();

	    if (rs.next()) {
		flag = true;
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    try {
		conn.close();
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

	return flag;
    }

}
