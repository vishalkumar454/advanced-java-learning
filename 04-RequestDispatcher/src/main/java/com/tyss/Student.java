package com.tyss;

public class Student {
	
	private String name;
	private int age;
	private long number;
	
	
	public Student(String name, int age, long number) {
		this.name = name;
		this.age = age;
		this.number = number;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", number=" + number + "]";
	}
	
}
