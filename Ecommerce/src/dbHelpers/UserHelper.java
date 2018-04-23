package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

/**
 * This class is used to insert, retrieve, and update users in the user table.
 */
public class UserHelper {
	

	private Connection connection;


	public UserHelper() {
		connection = MyDbConnection.getConnection();
	}
	
	/**
	 * Authenticates a user in the database.
	 * @param username  The username for the user.
	 * @param password  The password for the user.
	 * @return A user object if successful, null if unsuccessful.
	 */
	public User authenticateUser(User user) {
		
		String query = "select * from users where username=? and password=?";
		try {
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.executeUpdate();
		ResultSet rs = ps.executeQuery();
			
			//if we've returned a row we have a login
			if (rs.next()) {
				user = new User(rs.getString("username"), rs.getString("password"));
			} else {
				user = null;
			}
		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return user;
	}
}
