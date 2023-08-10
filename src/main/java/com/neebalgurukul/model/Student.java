package com.neebalgurukul.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;
    private int age;
    private String username;

    public Student() {
    };

    public Student(String name, String email, String course, int age) {
	this.name = name;
	this.email = email;
	this.course = course;
	this.age = age;
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getCourse() {
	return course;
    }

    public void setCourse(String course) {
	this.course = course;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    @Override
    public String toString() {
	return "StudentModel [id=" + id + ", name=" + name + ", email=" + email + ", course=" + course + ", age=" + age
		+ "]";
    }

}
