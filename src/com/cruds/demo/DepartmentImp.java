/*package com.cruds.demo;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import com.cruds.db.DepartmentDAO;

import com.cruds.services.DepartmentDaoService;


public class DepartmentImp {

	public static void main(String[] args) {
		DepartmentDAO dao = new DepartmentDAO();
		
		Department d=new Department(1, "cse", 109);
		Department d1=new Department(2, "ise",108);
		Department d2=new Department(3, "tc",102);
		Department d3=new Department(4, "ec",103);

		
		
		
		
		List<Department> departmentList=new ArrayList<>();
		departmentList =service.getAll();
		
		if(Department d : departmentList){
			System.out.println();
		}
		
		
		
		
		
		
		
		
		flag=dao.create(d);
		flag=dao.create(d1);
		flag=dao.create(d2);
		flag=dao.create(d3);
		
		//flag=dao.delete(04);
		
		if(flag==true){
			System.out.println("Department added Successfull");
		}
		else{
			System.out.println("not added");
		}

		
	}

}
*/