package com.wp.jdbcProc;

import java.util.*;
import java.sql.*;

public class Callable {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String server = "jdbc:mysql://localhost:3306/abc";
		String user = "root";
		String password = "root";

		Connection con = DriverManager.getConnection(server, user, password);

		System.out.println("\nEnter Details of New Employee ");
		
		System.out.println("Enter Employee No.");
		int empNum = sc.nextInt();

		System.out.println("Enter Employee Name.");
		String empName = sc.next();

		System.out.println("Enter Employee Salary.");
		int empSal = sc.nextInt();

		System.out.println("Enter Employee Designation.");
		String empDesig = sc.next();

		System.out.println("Enter Employee Department.");
		String empDepartment = sc.next();

		String sql = "{CALL proc_InsertEmployee(?,?,?,?,?)}";
		CallableStatement st = con.prepareCall(sql);

		st.setInt(1, empNum);
		st.setString(2, empName);
		st.setInt(3, empSal);
		st.setString(4, empDesig);
		st.setString(5, empDepartment);

		st.execute();

		System.out.println("\nEmployee Added");

		sc.close();
		con.close();
	}

}
