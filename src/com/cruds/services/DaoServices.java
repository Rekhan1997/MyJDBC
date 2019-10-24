package com.cruds.services;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.cruds.db.DepartmentDAO;
import com.cruds.db.StudentDAO;
import com.cruds.demo.Department;
import com.cruds.demo.Student;

public class DaoServices {

StudentDAO sdao = new StudentDAO();

DepartmentDAO ddao = new DepartmentDAO();
	
	public List<Student> getAll(){
		return sdao.getAll();
	}
	public boolean create(Student student) {
		return sdao.create(student);
		
	}
	public boolean delete(int rollno){
		return sdao.delete(rollno);
	}
	
	public Student get(int rollno){
		return sdao.get(rollno);
	}
	
	public Student get(String name){
		return sdao.get(name);
	}
	
	

	public boolean createDept(Department department)
	{
		return ddao.createDept(department);
	}
	public boolean deleteDept(int dno)
	{
		return ddao.deleteDept(dno);
	}
	public boolean updateDept(Department department)
	{
		return ddao.updateDept(department);
	}
	public List<Department> getAllDept()
	{
		return ddao.getAllDept();
	}
	public Department getDeptId(int dno)
	{
		return ddao.getDeptId(dno);
	}
	public Department getDeptName(String dname)
	{
		return ddao.getDeptName(dname);
	}
	
	public DefaultTableModel getTableData(){
		return sdao.getTableData();
		
	}
}
