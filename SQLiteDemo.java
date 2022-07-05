package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDemo {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:sqlite:/D:\\sqlite\\sqlite-tools-win32-x86-3390000\\sqlite-tools-win32-x86-3390000";
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT * FROM users";
			
			Statement statement = connection.createStatement();
			
			ResultSet result= statement.executeQuery(sql);
			
			while(result.next()) {
				String name = result.getString("name");
				String email = result.getString("email");
				
				System.out.println(name+" | " + email);
			}
			
		
		} catch (SQLException e) {
			System.out.println("Error connecting to SQLite database");
			e.printStackTrace();
		}

	}

}
