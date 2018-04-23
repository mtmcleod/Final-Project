package model;
/**
 * Java representation of the User table in the database
 * @author Brian
 *
 */
public class User {
	//not using id - pk is username
	//private int id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;	
	private String password;
	
	public User() {
		
		this.username = "no username";
		this.firstname = "no firstname";
		this.lastname = "no lastname";
		this.email = "no email";
		this.password = "no password";
	}
	
	//User Authentication
	public User(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	
	//User Registration
	public User(String username, String firstname, String lastname, String email, String password) {
		
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}



	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}



	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}


