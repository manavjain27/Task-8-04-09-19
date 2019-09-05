package com.wp.jdbcFunc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallableFunction {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String server = "jdbc:mysql://localhost:3306/abc";
		String user = "root";
		String password = "root";

		Connection con = DriverManager.getConnection(server, user, password);

		System.out.println("\nEnter Employee No for which Salary is Calculated.");
		int empNum = sc.nextInt();

		String sql = "{? = CALL func_getSal(?)}";
		CallableStatement st = con.prepareCall(sql);

		st.setInt(2, empNum);

		st.registerOutParameter(1, Types.INTEGER);

		st.execute();

		System.out.println("\nSalary of Employee No " + empNum + " is :  " + st.getInt(1));

		sc.close();
		
		con.close();
	}
}
