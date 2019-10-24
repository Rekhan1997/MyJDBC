package com.cruds.db;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.cruds.demo.Student;




public class StudentDAO {

	public boolean create(Student student)                                                  
	{

		Connection conn = null;
		String insertSQL = "insert into student values(?,?)";
		int row=0;

		try 
		{
			conn = DBConnectionManager.getConnection();

			PreparedStatement ps = conn.prepareStatement(insertSQL);
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.execute();

			System.out.println("Student record inserted successfully");
			ps.close();
			conn.close();


		} 
		catch (SQLException e) {
			e.printStackTrace();


		}
		return row > 0;	
	}

	public boolean delete(int rollno)
	{
		String sql="delete from student where roll=?";
		int row=0;

		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,rollno);
			row=ps.executeUpdate();
			System.out.println("Student record Deleted successfully");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return row > 0;
	}




	public boolean update(Student student)
	{
		String sql="update student set name= ? where rollno=?";
		int rows=0;

		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,student.getName());
			ps.setInt(2,student.getRoll());
			rows=ps.executeUpdate();
			System.out.println("updated successfully");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rows > 0;
	}



	public List<Student> getAll(){
		String sql="Select roll,name from student ";
		List<Student> studlist=new ArrayList<>();
		Student temp=null;
		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs !=null && rs.next())
			{
				temp =new Student(rs.getInt(1),rs.getString(2));
				studlist.add(temp);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return studlist;
	}

	public Student get(int rollno){
		String sql="Select roll,name from student where roll=?";
		Student student=null;

		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,rollno);
			ResultSet rs= ps.executeQuery();
			if(rs !=null && rs.next())
			{
				student =new Student(rs.getInt(1),rs.getString(2));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return student;
	}

	public Student get(String name){
		String sql="Select roll ,name from student where name=?";
		Student student=null;

		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs= ps.executeQuery();
			if(rs !=null && rs.next())
			{
				student =new Student(rs.getInt(1),rs.getString(2));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return student;
	}

	public DefaultTableModel getTableData()
	{
		String sql="Select roll,name from student";
		Vector<String> colNames=new Vector<>();
		Vector<Vector<String>> data=new Vector<>();
		colNames.add("Roll No");
		colNames.add("Name");
		Vector<String> row=null;

		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs !=null && rs.next())
			{
				row=new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
				data.add(row);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return new DefaultTableModel(data,colNames);
	}
}