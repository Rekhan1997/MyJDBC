package com.cruds.demo;


import java.util.ArrayList;
import java.util.List;

import com.cruds.db.StudentDAO;
import com.cruds.services.DaoServices;


public class StudentImp {
	
	public static void main(String[] args){
		
		/*Student s = new Student(109,"abc");
		Student s1= new Student(108, "xyz");
		Student s2 = new Student(107,"jay");
		Student s3= new Student(106, "dee");*/
		StudentDAO dao=new StudentDAO();
		
		Student s4= new Student(11, "vid");
		DaoServices service = new DaoServices();
		
		boolean flag = false;
		flag=dao.create(s4);
		
		List<Student> studentList= new ArrayList<>();
		studentList = service.getAll();
		
		for(Student s : studentList){
			
			System.out.println(s);
		}
		
		List<Department> departmentList=new ArrayList<>();
		departmentList =service.getAllDept();
		
		for( Department d: departmentList){
			//System.out.println();
		}
		/*
		flag = dao.create(s);
		flag=dao.create(s1);
		flag = dao.create(s2);
		flag=dao.create(s3);

		
		flag = dao.delete(102);*/
		
	
		
/*
		if(flag==true){
			System.out.println("Student added Successfull");
		}
		else{
			System.out.println("not added");
		}*/
	}
	
	
	

}
