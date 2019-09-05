package com.wp.jdbcEmp;

import java.sql.*;
import java.util.Scanner;



public class MenuSystem  {


	public static Scanner sc=new Scanner(System.in);
	
	public Connection con=null;
	public Statement st=null;
	public MenuSystem() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		String server="jdbc:mysql://localhost:3306/abc";
		String user="root";
		String password="root";
		
		con=DriverManager.getConnection(server,user,password);
		st=con.createStatement();
		
	}
															//Add Employee
	
	public void addEmployee() throws Exception
	{
		System.out.println("Enter Employee No.");
		int empNum=sc.nextInt();
		
		System.out.println("Enter Employee Name.");
		String empName=sc.next();
		
		System.out.println("Enter Employee Salary.");
		int empSal=sc.nextInt();
		
		System.out.println("Enter Employee Designation.");
		String empDesig=sc.next();
		
		System.out.println("Enter Employee Department.");
		String empDepartment=sc.next();
		
		String sql = "insert into emp values('"+empNum+"','"+empName+"','"+empSal+"','"+empDesig+"','"+empDepartment+"');";
		
		if(st.executeUpdate(sql)>0)
		{
			System.out.println("\nEmployee Added");
		}
		
		else
			System.out.println("\nCannot Insert");

		
		
		
	}
															//View Employees
	public void viewEmployees() throws Exception
	{
		
		String sql="select * from emp";
		
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println("\nEmployee No :"+rs.getInt(1));
			System.out.println("\nEmployee Name :"+rs.getString(2));
			System.out.println("\nEmployee Sal :"+rs.getInt(3));
			System.out.println("\nEmployee Designation :"+rs.getString(4));
			System.out.println("\nEmployee Department :"+rs.getString(5));
			System.out.println("\n................................");
		}
		
	}
	
															//Remove Employee
	public void removeEmployee() throws Exception
	{
		System.out.println("Enter Employee No.");
		int empNum=sc.nextInt();
		String sql="delete from emp where empno='"+empNum+"';";
		
		if(st.executeUpdate(sql)>0)
			System.out.println("\nRecord Deleted");
		else
			System.out.println("\nCannot Delete");
		
	}
															//Clear Data
	public void clearData() throws Exception
	{
		String sql= "truncate table emp;";

		if(st.executeUpdate(sql)>0)
			System.out.println("\nData Cleared");
		else
			System.out.println("\nCannot Clear Data");
		
	}
															//Change Sal
	public void changeSal() throws Exception
	{
		System.out.println("\n Enter New Salary");
		int newsal=sc.nextInt();
		System.out.println("Enter Employee No.");
		int empNum=sc.nextInt();
		String sql="update emp set esal='"+newsal+"' where empno='"+empNum+"'";
		if(st.executeUpdate(sql)>0)
			System.out.println("\nSalary Updated");
		else
			System.out.println("\nCannot Update Salary");
		
		
	}
																		//Search Employee
	public void searchEmployee() throws Exception
	{
		System.out.println("Enter Employee No.");
		int empNum=sc.nextInt();
		String sql="select * from emp where empno='"+empNum+"'";
		
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println("\nEmployee No :"+rs.getInt(1));
			System.out.println("\nEmployee Name :"+rs.getString(2));
			System.out.println("\nEmployee Sal :"+rs.getInt(3));
			System.out.println("\nEmployee Designation :"+rs.getString(4));
			System.out.println("\nEmployee Department :"+rs.getString(5));
			System.out.println("\n................................");
		}
		
	}
																		//View Dept Wise List
	public void viewDeptWiseList() throws Exception
	{
		System.out.println("\nEnter Department Name");
		String empdep=sc.next();
		String sql="select * from emp where department='"+empdep+"'";
		
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println("\nEmployee No :"+rs.getInt(1));
			System.out.println("\nEmployee Name :"+rs.getString(2));
			System.out.println("\nEmployee Sal :"+rs.getInt(3));
			System.out.println("\nEmployee Designation :"+rs.getString(4));
			System.out.println("\nEmployee Department :"+rs.getString(5));
			System.out.println("\n................................");
		}
		
		
		
		
	}
	
	public void sortEmployees() throws Exception
	{
		System.out.println("\n Sort By empno/ename/esal");
		String basis=sc.next();
		System.out.println("\n asc/desc");
		String order=sc.next();
		
		String sql="select * from emp order by "+basis+" "+order;
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println("\nEmployee No :"+rs.getInt(1));
			System.out.println("\nEmployee Name :"+rs.getString(2));
			System.out.println("\nEmployee Sal :"+rs.getInt(3));
			System.out.println("\nEmployee Designation :"+rs.getString(4));
			System.out.println("\nEmployee Department :"+rs.getString(5));
			System.out.println("\n................................");
		}
		
	}
	
	
																	//Main Function
	public static void main(String[] args) throws Exception{
		
		
		
		MenuSystem menusystem=new MenuSystem();
		
		System.out.println("Menu");
		
		System.out.println("1.Add Employee");
		System.out.println("2.View All Employees");
		System.out.println("3.Remove Employee");
		System.out.println("4.Clear Data");
		System.out.println("5.Change salary of Employee");
		System.out.println("6.Search Employee");
		System.out.println("7.View Department Wise List");
		System.out.println("8.Sort Employee");
		System.out.println("9.Exit");
		System.out.println("\n................................");
		
		int choice=0;
		
		while(true)
		{
		System.out.println("\n Enter Your Choice.....");
		choice=sc.nextInt();
		
		
		switch(choice)
		{
		case 1:
			
			menusystem.addEmployee();
			break;
			
		case 2:
			
			menusystem.viewEmployees();
			break;
			
		case 3:
			menusystem.removeEmployee();
			break;
			
		case 4:
			
			menusystem.clearData();
			break;
			
		case 5:
			menusystem.changeSal();
			break;
			
		case 6:
			menusystem.searchEmployee();
			break;
			
		case 7:
			menusystem.viewDeptWiseList();
			break;
			
		case 8:
			menusystem.sortEmployees();
			break;
			
		case 9:
			menusystem.con.close();
			System.exit(0);
			break;
		
		default:
			System.out.println("Wrong Choice");
		}
		}
		
		

	}

}
