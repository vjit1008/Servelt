package com.neebalgurukul.service;

import java.sql.SQLException;

import com.neebalgurukul.dao.LoginDao;
import com.neebalgurukul.model.Login;

public class LoginService {
    public boolean isValidUser(String username, String password) {
	boolean flag = false;
	Login login = new Login();
	LoginDao loginDao = new LoginDao();

	try {
	    login = loginDao.getPassword(username);
	    if (login.getPswd().equals(password)) {
		flag = true;
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return flag;
    }

    public void insertLogin(String username, String password) {
	LoginDao loginDao = new LoginDao();
	Login login = new Login();
	login.setUname(username);
	login.setPswd(password);
	login.setActive(true);

	try {
	    boolean flag = loginDao.insertDetails(login);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void makeDeactivate(String username) {
	LoginDao loginDao = new LoginDao();
	try {
	    loginDao.deleteSoft(username);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
