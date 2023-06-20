package com.connection.shoppingcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection con = null;
	
//	@SuppressWarnings("deprecation")
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if(con==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfully completed");
			con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "1234");
		}
		return con;
	}
	
}
