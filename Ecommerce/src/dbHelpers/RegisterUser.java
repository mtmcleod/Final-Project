package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class RegisterUser {

	private Connection connection;

	public RegisterUser() {
		connection = MyDbConnection.getConnection();
	}
	
	public void doAdd(User user){
		String query = "INSERT INTO users (username, firstname, lastname, email, password) values (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFirstname());
			ps.setString(3, user.getLastname());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block; add real error handling!
			e.printStackTrace();
		}
	}

}
