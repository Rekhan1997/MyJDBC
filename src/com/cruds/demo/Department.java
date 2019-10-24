package com.cruds.demo;

public class Department extends Student {
	int dno;
	String dname;
	
	
	
	
	public Department() {
		super();
	}

	public Department(int dno,String dname, int roll) {
		super();
		this.dno=dno;
		this.dname=dname;
		this.roll=roll;
		
	}

	/*public Department(int dno, String dname) {

		this.dno = dno;
		this.dname = dname;
	}*/
	
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + ", roll=" + roll + ", name=" + name + "]";
	}

	
	
	
	

}
