package com.cruds.demo;

public class Student {
	
	int roll;
	String name;
	
	
	
	public Student() {
		
	}


	public Student(int roll, String name) {
	
		this.roll = roll;
		this.name = name;
	}


	public int getRoll() {
		return roll;
	}


	public void setRoll(int roll) {
		this.roll = roll;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "\n Student [roll=" + roll + ", name=" + name + "]\n";
	}
	
	
	

}
