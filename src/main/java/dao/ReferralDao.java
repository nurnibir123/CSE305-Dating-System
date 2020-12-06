package dao;
import java.sql.*;

import model.Customer;

public class ReferralDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	
	public String referProfile(String profileA, String profileB, String profileC){		
		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	con.createStatement().executeQuery(
        		"INSERT TO BlindDate VALUES (\'" + profileA + "\', \'" + profileB + "\', \'" + profileC + "\', NOW())");
		} catch (Exception e) {
        	System.out.println(e);
        	return "failure";
        }

		return profileA +" has referred " + profileB + "  to " + profileC;
	}
}
