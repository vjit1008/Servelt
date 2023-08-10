package com.neebalgurukul.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neebalgurukul.dao.StudentDao;
import com.neebalgurukul.model.Student;

public class StudentService {

    public void insertStudent(String name, String email, String Course, int age, String username) {
	StudentDao studentDao = new StudentDao();

	Student student = new Student();
	student.setName(name);
	student.setEmail(email);
	student.setCourse(Course);
	student.setAge(age);

	try {
	    boolean flag = studentDao.insertDetails(student, username);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public boolean isPresent(String username) {
	StudentDao studentDao = new StudentDao();

	boolean flag = false;
	flag = studentDao.getUsernameDetails(username);
	return flag;
    }

    public List<Student> getAllStudent(String query) {
	StudentDao studentDao = new StudentDao();
	List<Student> list;
	List<Student> listA = new ArrayList<>();
	try {
	    list = studentDao.getStudentDetails();
	    for (Student s : list) {
		if (s.getName().startsWith(query)) {
		    listA.add(s);
		}
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return listA;
    }

}
