package com.tap.connects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class myConnection {
	static Connection con=null;
	private static final String username="root";
	private static final String password="Naveen@135";
	private static final String url="jdbc:mysql://localhost:3306/online_food_delivery";
	

	private myConnection() {
		
	}
	static private myConnection connection=new myConnection();
	public static  myConnection getMyConnection() {
		return connection;
	}
	public static Connection Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
