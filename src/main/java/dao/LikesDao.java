package dao;

import model.Customer;
import model.Profile;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class LikesDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	public String setNewLike(String user1, String user2){
		List<Customer> customers = new ArrayList<Customer>();

		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	con.createStatement().executeQuery("INSERT INTO Likes VALUES (\'" + user1 + "\', \'" + user2 + "\', NOW())");
		} catch (Exception e) {
        	System.out.println(e);
        	return "failure";
        }
		return "User - "+user1+" likes "+user2;
	}

	public List<String> getFavorites(String mw){

		/*Sample data begins*/
		List<String> favs = new ArrayList<>();
		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery(
        		"SELECT L.Likee FROM Profile AS P INNER JOIN Likes AS L ON P.ProfileID=L.Liker WHERE P.ProfileID=\'" + mw + "\'");
        	while (rs.next()) {
        		favs.add(rs.getString(0));
        	}
		} catch (Exception e) {
        	System.out.println(e);
        }

		return favs;
	}

}
