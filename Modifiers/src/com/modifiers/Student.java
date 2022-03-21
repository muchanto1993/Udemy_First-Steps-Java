package com.modifiers;

public class Student {

	private int age;
	
	public Student(int age) {
		this.age = age;
	}
	
	public void showAge() {
		age = age + 2;
		System.out.println("Age is: " + age);
	}
}
