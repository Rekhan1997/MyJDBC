package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.demo.Department;


public class DepartmentDAO {

	
	
		
		public boolean createDept(Department department)
		{

				Connection conn = null;
				String insertSQL = "insert into department values(?,?,?)";
				int row=0;

				try 
				{
					conn = DBConnectionManager.getConnection();
					
				PreparedStatement ps = conn.prepareStatement(insertSQL);
					ps.setInt(1, department.getDno());
					ps.setString(2, department.getDname());
					ps.setInt(3, department.getRoll());
					ps.execute();
					
					System.out.println("Department record inserted successfully");
					ps.close();
					conn.close();
					
					
				} 
					catch (SQLException e) {
					e.printStackTrace();
					
					
					}
				return row>0;	
		}
		
		public boolean deleteDept(int dno)
		{
			String sql="delete from department where dno=?";
			int row=0;
			
			try(Connection conn=DBConnectionManager.getConnection())
			{
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1,dno);
				row=ps.executeUpdate();
				System.out.println("department record Deleted successfully");
			}
			catch(SQLException e){
				e.printStackTrace();
			}
	     return row>0;
	     
		}

				


	public boolean updateDept(Department department)
	{
		String sql="update Department set dname= ? where dno=? where roll=?";
		int row=0;
		
		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,department.getDname());
			ps.setInt(2,department.getDno());
			ps.setInt(3, department.getRoll());
			row=ps.executeUpdate();
			System.out.println("updated successfully");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return row> 0;
		}
		


	public List<Department> getAllDept(){
		String sql="Select dno,dname,roll from department ";
		List<Department> deptlist=new ArrayList<>();
		Department temp=null;
		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs !=null && rs.next())
			{
				temp =new Department(rs.getInt(1),rs.getString(2),rs.getInt(3));
				deptlist.add(temp);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return deptlist;
	}

	public Department getDeptId(int dno){
		String sql="Select dno,dname,roll from department where dno=?";
		Department department=null;

	try(Connection conn=DBConnectionManager.getConnection())
	{
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,dno);
		ResultSet rs= ps.executeQuery();
		if(rs !=null && rs.next())
		{
			department=new Department(rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return department;
	}

	public Department getDeptName(String dname){
		String sql="Select dno ,dname,roll from department where dname=?";
		Department department=null;

	try(Connection conn=DBConnectionManager.getConnection())
	{
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, dname);
		ResultSet rs= ps.executeQuery();
		if(rs !=null && rs.next())
		{
			department =new Department(rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return department;
	
	}
}


	



