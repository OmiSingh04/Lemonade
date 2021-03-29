package lemonade.db_manager;

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

	private boolean contains(long id) {// always use next() to check for results or some kind of output from the query

		try {
			PreparedStatement statement = connection.prepareStatement("SELECT authorName from users WHERE longID = ?");
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public long getLemons(long id) {
		if (contains(id)) {
			try {
				PreparedStatement statement = connection.prepareStatement("SELECT Lemons FROM users WHERE longID = ?");
				statement.setLong(1, id);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next())
					return resultSet.getLong(1);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	public boolean addUser(String userName, long id, String guildName, int initialLemons) {// first check if the long
																							// already exists, if not,
																							// add
		if (!contains(id)) {
			try {
				PreparedStatement statement = connection.prepareStatement("INSERT INTO USERS VALUES(?, ?, ?, ?)");
				statement.setLong(1, id);
				statement.setString(2, userName);
				statement.setString(3, guildName);
				statement.setInt(4, initialLemons);
				statement.executeUpdate();
				System.out.println("Added " + userName + " to USERS TABLE");
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	public boolean addLemons(long id, int lemons) {
		if (contains(id)) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("UPDATE users SET lemons = ? + lemons where  longID = ?");
				statement.setInt(1, lemons);
				statement.setLong(2, id);
				int i = statement.executeUpdate();

				return true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}