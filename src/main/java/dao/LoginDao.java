package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Login;

public class LoginDao {
	/*
	 * This class handles all the database operations related to login functionality
	 */
	String dbpath = "jdbc:mysql://localhost:3306/cse305";
	String dbuser = "root";
	String dbpass = "root";
	
	
	public Login login(String username, String password) {
		/*
		 * Return a Login object with role as "manager", "customerRepresentative" or "customer" if successful login
		 * Else, return null
		 * The role depends on the type of the user, which has to be handled in the database
		 * username, which is the email address of the user, is given as method parameter
		 * password, which is the password of the user, is given as method parameter
		 * Query to verify the username and password and fetch the role of the user, must be implemented
		 */
	
		Login login = new Login();
		try {
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT L.Role FROM Login AS L WHERE L.Email='"+username+"' AND L.Password='"+password+"'");
    		
    		if(rs.next()) {
    			String role = rs.getString("Role");
    			login.setUsername(username);
    			login.setPassword(password);
    			login.setRole(role);
    			
    		} else {
    			login = null;
    		}
    		
		} catch(Exception e) {
			System.out.println(e);
		}

		return login;	
	}
	
	public String addUser(Login login) {
		/*
		 * Query to insert a new record for user login must be implemented
		 * login, which is the "Login" Class object containing username and password for the new user, is given as method parameter
		 * The username and password from login can get accessed using getter methods in the "Login" model
		 * e.g. getUsername() method will return the username encapsulated in login object
		 * Return "success" on successful insertion of a new user
		 * Return "failure" for an unsuccessful database operation
		 */
		
		
		
		try {      
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		      ResultSet uprs = stmt.executeQuery("SELECT * FROM COFFEES");
		      uprs.moveToInsertRow();
		      uprs.updateString("Email", login.getUsername());
		      uprs.updateString("Password", login.getPassword());
		      uprs.updateString("Role", login.getRole());
		     
		      uprs.insertRow();
		      uprs.beforeFirst();

		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		return "success";
		
	}

}
