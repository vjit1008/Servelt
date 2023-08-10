package com.neebalgurukul;

import java.util.ArrayList;
import java.util.List;

import com.neebalgurukul.dao.StudentDao;
import com.neebalgurukul.model.Student;

public class StudentTest {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	StudentDao dao = new StudentDao();
	Student obj = new Student();
	List<Student> studentList = new ArrayList<>();

	try {
	    // to read the table

	    studentList = dao.getStudentDetails();
	    for (Student s : studentList) {
		System.out.println(s);
	    }

	    // to add a student

//	    Student toAdd = new Student("Hulk", "hulk@brazil.com", "chemistry", 52);
//	    dao.insertDetails(toAdd);

	    // to delete a student enrty

//	    dao.deleteHard(5);

	    // to update the table

//	    dao.updateCourse(3, "Physics");

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
