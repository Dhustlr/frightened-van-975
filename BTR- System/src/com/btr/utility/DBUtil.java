package com.btr.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getConnetion() {

		Connection con = null;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/BTR";

		try {
			
			con = DriverManager.getConnection(url, "root", "428728");
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
}
