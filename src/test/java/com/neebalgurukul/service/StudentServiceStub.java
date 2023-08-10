package com.neebalgurukul.service;

import java.util.List;

import com.neebalgurukul.business.StudentAPI;
import com.neebalgurukul.model.Student;

public class StudentServiceStub implements StudentAPI {

    @Override
    public List<Student> getAllStudents() {
	// TODO Auto-generated method stub
	return List.of(new Student("Ajay", "ajay@gmail.com", "java", 23),
		new Student("Akshay", "akshay@gmail.com", "java", 23),
		new Student("Shrikant", "shrikant@gmail.com", "java", 23),
		new Student("Chetan", "chetan@gmail.com", "java", 23),
		new Student("Miroy", "miroy@gmail.com", "java", 23));
    }

}
