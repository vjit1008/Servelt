package com.neebalgurukul.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.neebalgurukul.business.impl.StudentServiceImpl;
import com.neebalgurukul.model.Student;
import com.neebalgurukul.service.StudentServiceStub;

public class StudentServiceImplTest {

    @Test
    public void testGetStudentsStartingWithA() {
	StudentServiceStub stub = new StudentServiceStub();

	int expectedOutput = 2;

	List<Student> studList = stub.getAllStudents();
	List<Student> listA = new ArrayList<Student>();

	for (Student st : studList) {
	    if (st.getName().startsWith("A")) {
		listA.add(st);
	    }
	}
	assertEquals(expectedOutput, listA.size());
    }

    @Test
    public void testGetStudentsStartingWithA_usingMock() {
	StudentAPI mockStudentAPI = mock(StudentAPI.class);

	int expectedOutput = 2;
	List<Student> students = List.of(new Student("Ajay", "ajay@gmail.com", "java", 23),
		new Student("Akshay", "akshay@gmail.com", "java", 23),
		new Student("Shrikant", "shrikant@gmail.com", "java", 23),
		new Student("Chetan", "chetan@gmail.com", "java", 23),
		new Student("Miroy", "miroy@gmail.com", "java", 23));

	when(mockStudentAPI.getAllStudents()).thenReturn(students);

	// Above three line are similar to creating a stub

	StudentServiceImpl studServiceImpl = new StudentServiceImpl(mockStudentAPI);

	assertEquals(expectedOutput, studServiceImpl.getStudentsStartingWithA().size());

    }
}