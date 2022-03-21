package com.udemy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost/test_db";
	private final static String USERNAME = "balazs";
	private final static String PASSWORD = "balazs";

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {

			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();

			String sql = "SELECT first_name,last_name,email,age FROM STUDENT";

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");

				System.out.println("Student: " + firstName + "-" + lastName + "-" + email + "-" + age);
			}
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
