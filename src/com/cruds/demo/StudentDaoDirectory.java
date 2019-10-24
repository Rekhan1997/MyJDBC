package com.cruds.demo;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cruds.db.StudentDAO;
import com.cruds.services.DaoServices;


public class StudentDaoDirectory {
	
		public static void main(String[] args) {
			
			DaoServices service = new DaoServices();
			



		/*	Student s1=new Student(101,"rekha");
			Student s2=new Student(102,"sagar");
			Student s3=new Student(103,"vidya");


			studs[0]=s1;
			studs[1]=s2;
			studs[2]=s3;
*/
			Scanner sc=new Scanner(System.in);
			String choice="";
			int pos=3;
			int x=0;
			


			do{
				System.out.println("please select an option");
				System.out.println("1.Add name");
				System.out.println("2.search roll number");
				System.out.println("3.search name");
				System.out.println("4.delete name");
				System.out.println("5.list all name");
				System.out.println("6.exit\n\n");
				
				choice=sc.nextLine();
				switch(choice){
				
				
				case"1":
					System.out.println("please enter studen rllno");
					int roll = sc.nextInt();
					System.out.println("please enter student name");
					sc.nextLine();
					String name = sc.nextLine();
					Student s = new Student(roll, name);
					service.create(s);
					break;
					
				case "2":
					System.out.println("please search the roll number");
					roll = sc.nextInt();
					s = service.get(roll);
					System.out.println(s);
					break;
					
				case "3":
					System.out.println("please search the name");
					name = sc.nextLine();
					s = service.get(name);
					System.out.println(s);
					break;
					

				case "4":
					System.out.println("please search the roll number to delete\n\n");
					boolean delete=false;
					roll = sc.nextInt();
					service.delete(roll);
					System.out.println(roll + " Deleted Succesfully\n\n");
					break;
					
				
					
				case "5":
					System.out.println("\t*****names******");
					for(int i=0;i<pos;i++)
					{
						System.out.print("\t\n \t\n");
						System.out.println("\n" + service.getAll() + "\n");
						System.out.println("\n" + service.getAllDept() + "\n");
						break;
					}
				
					
					
					break;

					default:
						break;
				}
				
			}while(!choice.equals("6"));
			sc.close();


		
}
}






