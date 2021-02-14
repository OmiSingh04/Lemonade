package com.dev.os.lemonade.db_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
//list of methods to get required SQL queries done
	
	private String userName, password, URLConnection;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private Connection connection;
	
	public DatabaseManager(String URLConnection, String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.URLConnection = URLConnection;
		connect();
		
	}
	
	private boolean connect() {
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(this.URLConnection, this.userName, this.password);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public long getLemons(long id) {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT Lemons FROM USERS WHERE longID = ?");
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			return resultSet.getLong(1);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public boolean addUser(String userName, String id, String guildName, int initialLemons) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO USERS VALUES(?, ?, ?, ?)");
			statement.setString(1, id);
			statement.setString(2, userName);
			statement.setString(3, guildName);
			statement.setInt(4, initialLemons);
			statement.executeUpdate();
			System.out.println("Added " + userName + " to USERS TABLE");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
}
