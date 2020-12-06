package dao;

import model.Customer;
import model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProfileDao {
    /*
     * This class handles all the database operations related to the customer table
     */

    public List<Profile> getProfiles() {
    	
    	List<Profile> profiles = new ArrayList<>();
    	
    	
    		try {
	
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/305project", "root", "root");
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM Profile");
	        
    		while(rs.next()){
    			Profile newProfile = new Profile();
    			newProfile.setProfileID(rs.getString("ProfileID"));
    			newProfile.setOwnerSSN(rs.getString("OwnerSSN"));
    			newProfile.setAge(rs.getInt("Age"));
    			newProfile.setDatingAgeRangeStart(rs.getInt("DatingAgeRangeStart"));
    			newProfile.setDatingAgeRangeEnd(rs.getInt("DatingAgeRangeEnd"));
    			newProfile.setGeoRange(rs.getInt("DatinGeoRange"));
    			newProfile.setGender(rs.getString("M_F"));
    			newProfile.setHobbies(rs.getString("Hobbies"));
    			newProfile.setHeight(rs.getInt("Height"));
    			newProfile.setWeight(rs.getInt("Weight"));
    			newProfile.setHairColor(rs.getString("HairColor"));
    			newProfile.setCreationDate(rs.getString("CreationDate"));
    			newProfile.setLastModDate(rs.getString("LastModDate"));
    			profiles.add(newProfile);
    			
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	


        return profiles;
    }

    public List<Profile> getProfilesByAge(String age) {

    	List<Profile> profiles = new ArrayList<>();
    	
    	try {
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/305project", "root", "root");
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM Profile AS P WHERE P.Age=" + age);
	        
    		while(rs.next()){
    			Profile newProfile = new Profile();
    			newProfile.setProfileID(rs.getString("ProfileID"));
    			newProfile.setOwnerSSN(rs.getString("OwnerSSN"));
    			newProfile.setAge(rs.getInt("Age"));
    			newProfile.setDatingAgeRangeStart(rs.getInt("DatingAgeRangeStart"));
    			newProfile.setDatingAgeRangeEnd(rs.getInt("DatingAgeRangeEnd"));
    			newProfile.setGeoRange(rs.getInt("DatinGeoRange"));
    			newProfile.setGender(rs.getString("M_F"));
    			newProfile.setHobbies(rs.getString("Hobbies"));
    			newProfile.setHeight(rs.getInt("Height"));
    			newProfile.setWeight(rs.getInt("Weight"));
    			newProfile.setHairColor(rs.getString("HairColor"));
    			newProfile.setCreationDate(rs.getString("CreationDate"));
    			newProfile.setLastModDate(rs.getString("LastModDate"));
    			profiles.add(newProfile);
    			
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}


        return profiles;
    }

    public List<Profile> getProfilesByWeight(String weight) {
    	
    	List<Profile> profiles = new ArrayList<>();

    	try {
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/305project", "root", "root");
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM Profile AS P WHERE P.Weight=" + weight);
	        
    		while(rs.next()){
    			Profile newProfile = new Profile();
    			newProfile.setProfileID(rs.getString("ProfileID"));
    			newProfile.setOwnerSSN(rs.getString("OwnerSSN"));
    			newProfile.setAge(rs.getInt("Age"));
    			newProfile.setDatingAgeRangeStart(rs.getInt("DatingAgeRangeStart"));
    			newProfile.setDatingAgeRangeEnd(rs.getInt("DatingAgeRangeEnd"));
    			newProfile.setGeoRange(rs.getInt("DatinGeoRange"));
    			newProfile.setGender(rs.getString("M_F"));
    			newProfile.setHobbies(rs.getString("Hobbies"));
    			newProfile.setHeight(rs.getInt("Height"));
    			newProfile.setWeight(rs.getInt("Weight"));
    			newProfile.setHairColor(rs.getString("HairColor"));
    			newProfile.setCreationDate(rs.getString("CreationDate"));
    			newProfile.setLastModDate(rs.getString("LastModDate"));
    			profiles.add(newProfile);
    			
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
        return profiles;
    }

    public List<Profile> getProfilesByHeight(String height) {

    	List<Profile> profiles = new ArrayList<>();

    	try {
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/305project", "root", "root");
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM Profile AS P WHERE P.Height=" + height);
	        
    		while(rs.next()){
    			Profile newProfile = new Profile();
    			newProfile.setProfileID(rs.getString("ProfileID"));
    			newProfile.setOwnerSSN(rs.getString("OwnerSSN"));
    			newProfile.setAge(rs.getInt("Age"));
    			newProfile.setDatingAgeRangeStart(rs.getInt("DatingAgeRangeStart"));
    			newProfile.setDatingAgeRangeEnd(rs.getInt("DatingAgeRangeEnd"));
    			newProfile.setGeoRange(rs.getInt("DatinGeoRange"));
    			newProfile.setGender(rs.getString("M_F"));
    			newProfile.setHobbies(rs.getString("Hobbies"));
    			newProfile.setHeight(rs.getInt("Height"));
    			newProfile.setWeight(rs.getInt("Weight"));
    			newProfile.setHairColor(rs.getString("HairColor"));
    			newProfile.setCreationDate(rs.getString("CreationDate"));
    			newProfile.setLastModDate(rs.getString("LastModDate"));
    			profiles.add(newProfile);
    			
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}

        return profiles;
    }

    public List<Profile> getProfilesByHairColor(String hairColor) {

       
    	List<Profile> profiles = new ArrayList<>();

    	try {
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/305project", "root", "root");
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM Profile AS P WHERE P.HairColor='"+hairColor+"'");
	        
    		while(rs.next()){
    			Profile newProfile = new Profile();
    			newProfile.setProfileID(rs.getString("ProfileID"));
    			newProfile.setOwnerSSN(rs.getString("OwnerSSN"));
    			newProfile.setAge(rs.getInt("Age"));
    			newProfile.setDatingAgeRangeStart(rs.getInt("DatingAgeRangeStart"));
    			newProfile.setDatingAgeRangeEnd(rs.getInt("DatingAgeRangeEnd"));
    			newProfile.setGeoRange(rs.getInt("DatinGeoRange"));
    			newProfile.setGender(rs.getString("M_F"));
    			newProfile.setHobbies(rs.getString("Hobbies"));
    			newProfile.setHeight(rs.getInt("Height"));
    			newProfile.setWeight(rs.getInt("Weight"));
    			newProfile.setHairColor(rs.getString("HairColor"));
    			newProfile.setCreationDate(rs.getString("CreationDate"));
    			newProfile.setLastModDate(rs.getString("LastModDate"));
    			profiles.add(newProfile);
    			
    			
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}

        return profiles;
    }

}
