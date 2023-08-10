package com.neebalgurukul.business.impl;

import java.util.ArrayList;
import java.util.List;

import com.neebalgurukul.business.StudentAPI;
import com.neebalgurukul.model.Student;

public class StudentServiceImpl {
    StudentAPI studentAPI;

    /*
     * public StudentServiceImpl() {
     * 
     * }
     */

    public StudentServiceImpl(StudentAPI mockStudentAPI) {
	// TODO Auto-generated constructor stub
	studentAPI = mockStudentAPI;
    }

    public List<Student> getStudentsStartingWithA() {
	List<Student> list = studentAPI.getAllStudents();
	List<Student> listA = new ArrayList<>();
	for (Student s : list) {
	    if (s.getName().startsWith("A")) {
		listA.add(s);
	    }
	}
	return listA;
    }
}
