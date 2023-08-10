package com.neebalgurukul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neebalgurukul.model.Login;

public class LoginDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    DataSource ds = new DataSource();

    public List<Login> getLoginDetails() throws SQLException {
	String query = "Select username, password from login";
	conn = ds.getConnection();
	List<Login> loginList = new ArrayList<>();
	try {
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if (rs != null) {
		while (rs.next()) {
		    Login obj = new Login();
		    obj.setUname(rs.getString("username"));
		    obj.setPswd(rs.getString("password"));
//		    System.out.println(obj.getUname() + ", " + obj.getPswd());
		    loginList.add(obj);
		}
	    }
	    return loginList;
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	    return null;
	} finally {

	    conn.close();
	}
    }

    public Login getPassword(String username) throws SQLException {
	String query = "Select username, password from login where username = ?";
	conn = ds.getConnection();
	Login loginObj = new Login();
	try {
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, username);
	    ResultSet rs = pstmt.executeQuery();
	    if (rs != null) {
		while (rs.next()) {
		    loginObj.setUname(rs.getString("username"));
		    loginObj.setPswd(rs.getString("password"));
//		    System.out.println(obj.getUname() + ", " + obj.getPswd());
		}
	    }
	    return loginObj;
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	    return null;
	} finally {
	    conn.close();
	}
    }

    public boolean insertDetails(Login login) throws SQLException {
	conn = ds.getConnection();
	String query = "insert into login(username,password, lastModifiedDate, active) values(?, ?, ?, ?)";
	int i = 0;
	int loginId;
	boolean loginCreated = false;
	try {
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	    pstmt.setString(1, login.getUname());
	    pstmt.setString(2, login.getPswd());
	    java.util.Date utilDate = new java.util.Date();
	    java.sql.Date dt = new java.sql.Date(utilDate.getTime());
	    pstmt.setDate(3, dt);
	    pstmt.setBoolean(4, login.isActive());

	    i = pstmt.executeUpdate();
	    if (i != 0) {
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
		    loginId = rs.getInt(1);
		    loginCreated = true;
		    System.out.println("StudentId = " + loginId);
		}
	    }

	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	} finally {
	    conn.close();
	}
	return loginCreated;
    }

    public void deleteSoft(String username) throws SQLException {
	String query = "update login set active=0 where username=?";
	conn = ds.getConnection();
	try {
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, username);
	    int i = pstmt.executeUpdate();
	    if (i != 0) {
		System.out.println(username + " is not active");
	    } else {
		System.out.println("Can not execute the query");
	    }
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	} finally {
	    conn.close();
	}
    }

    public void deleteHard(String username) throws SQLException {
	String query = "delete from login where username=?";
	conn = ds.getConnection();
	try {
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, username);
	    int i = pstmt.executeUpdate();
	    if (i != 0) {
		System.out.println(username + " is deleted.");
	    } else {
		System.out.println("Can not execute the query");
	    }
	} catch (SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	} finally {
	    conn.close();
	}
    }

}
