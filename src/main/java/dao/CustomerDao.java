package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;
import model.Customer;

import java.util.stream.IntStream;

public class CustomerDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	
	/**
	 * @return ArrayList<Customer> object
	 */
	// tested
	public List<Customer> getCustomers() {
		/*
		 * This method fetches one or more customers and returns it as an ArrayList
		 */

		List<Customer> customers = new ArrayList<Customer>();

		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery(
        		"SELECT * FROM Account AS A, Person AS P, User AS U WHERE A.OwnerSSN = P.SSN AND P.SSN = U.SSN");
        	while (rs.next()) {
        		Customer customer = new Customer();
        		customer.setPassword(rs.getString("Password"));
    			customer.setUserID(rs.getString("SSN"));
    			customer.setUserSSN(rs.getString("SSN"));
    			customer.setFirstName(rs.getString("FirstName"));
    			customer.setLastName(rs.getString("LastName"));
    			customer.setAddress(rs.getString("Street"));
    			customer.setCity(rs.getString("City"));
    			customer.setState(rs.getString("State"));
    			customer.setZipCode(rs.getInt("Zipcode"));
    			customer.setTelephone(rs.getString("Telephone"));
    			customer.setEmail(rs.getString("Email"));
    			customer.setAccNum(rs.getString("AcctNum"));
    			customer.setAccCreateDate(rs.getString("AcctCreationDate"));
    			customer.setCreditCard(rs.getString("CardNumber"));
    			customer.setPpp(rs.getString("PPP"));
    			customer.setRating(rs.getInt("Rating"));
    			customer.setDateLastActive(rs.getString("DateOfLastAct"));
    			customers.add(customer);
        	}
		} catch (Exception e) {
        	System.out.println(e);
        }
		
		return customers;
	}

	public List<Customer> getCustomerMailingList() {

		/*
		 * This method fetches the all customer mailing details and returns it
		 * The students code to fetch data from the database will be written here
		 * Each customer record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		return this.getCustomers();
	}

	public Customer getCustomer(String customerID) {

		/*
		 * This method fetches the customer details and returns it
		 * customerID, which is the Customer's ID who's details have to be fetched, is given as method parameter
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */
		
		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery(
        		"SELECT * FROM (Account FULL JOIN Person ON Account.SSN = Person.SSN FULL JOIN User ON Account.SSN = User.SSN) WHERE SSN = \'"
        		+ customerID + "\'");
        	if (rs.next()) {
        		Customer customer = new Customer();
        		customer.setPassword(rs.getString("Password"));
    			customer.setUserID(rs.getString("SSN"));
    			customer.setUserSSN(rs.getString("SSN"));
    			customer.setFirstName(rs.getString("FirstName"));
    			customer.setLastName(rs.getString("LastName"));
    			customer.setAddress(rs.getString("Street"));
    			customer.setCity(rs.getString("City"));
    			customer.setState(rs.getString("State"));
    			customer.setZipCode(rs.getInt("Zipcode"));
    			customer.setTelephone(rs.getString("Telephone"));
    			customer.setEmail(rs.getString("Email"));
    			customer.setAccNum(rs.getString("AcctNum"));
    			customer.setAccCreateDate(rs.getString("AcctCreationDate"));
    			customer.setCreditCard(rs.getString("CardNumber"));
    			customer.setPpp(rs.getString("PPP"));
    			customer.setRating(rs.getInt("Rating"));
    			customer.setDateLastActive(rs.getString("DateOfLastAct"));
    			return customer;
        	}
		} catch (Exception e) {
        	System.out.println(e);
        }

		return null;
	}
	
	public String deleteCustomer(String customerID) {

		/*
		 * This method deletes a customer returns "success" string on success, else returns "failure"
		 * The students code to delete the data from the database will be written here
		 * customerID, which is the Customer's ID who's details have to be deleted, is given as method parameter
		 */

		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	con.createStatement().executeQuery("DELETE * FROM Account WHERE SSN = \'" + customerID + "\'");
        	return "success";
		} catch (Exception e) {
        	System.out.println(e);
        }
		return "failure";
	}


	public String getCustomerID(String username) {
		/*
		 * This method returns the Customer's ID based on the provided email address
		 * The students code to fetch data from the database will be written here
		 * username, which is the email address of the customer, who's ID has to be returned, is given as method parameter
		 * The Customer's ID is required to be returned as a String
		 */
		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Person WHERE Email = \'" + username + "\'");
        	if (rs.next()) {
    			return rs.getString("SSN");
        	}
		} catch (Exception e) {
        	System.out.println(e);
        }
		return null;
	}


	public String addCustomer(Customer customer) {

		/*
		 * All the values of the add customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the customer details and return "success" or "failure" based on result of the database insertion.
		 */
		
		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	con.createStatement().executeQuery(
        		"INSERT INTO Person VALUES (\'" + customer.getUserID() + "\', \'" + customer.getPassword() + "\', \'"
        		+ customer.getFirstName() + "\', \'" + customer.getLastName() + "\', \'" + customer.getAddress() + "\', \'"
        		+ customer.getCity() + "\', \'" + customer.getState() + "\', " + customer.getZipCode() + ", NULL, NULL, \'"
        		+ customer.getEmail() + "\', \'" + customer.getTelephone() + "\'); INSERT INTO User VALUES (\'" + customer.getUserID()
        		+ "\', \'" + customer.getPpp() + "\', " + customer.getRating() + ", \'" + customer.getDateLastActive()
        		+ "\'); INSERT INTO Account VALUES (\'" + customer.getUserID() + "\', " + customer.getCreditCard() + ", \'"
        		+ customer.getAccNum() + "\', \'" + customer.getAccCreateDate() + "\')");
        	return "success";
		} catch (Exception e) {
        	System.out.println(e);
        }
		return "failure";

	}

	public String editCustomer(Customer customer) {
		/*
		 * All the values of the edit customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		return this.addCustomer(customer);
	}



	public List<Customer>  getMostActiveUser(){
		List<Customer> customers = new ArrayList<Customer>();

		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery(
        		"SELECT * FROM (Likes FULL JOIN Profile ON Likes.Liker = Profile.ProfileID FULL JOIN User ON Profile.OwnerSSN = User.SSN) GROUP BY Liker ORDER BY COUNT(Liker) DESC");
        	while (rs.next()) {
        		Customer customer = new Customer();
        		customer.setPassword(rs.getString("Password"));
    			customer.setUserID(rs.getString("ProfileID"));
    			customer.setUserSSN(rs.getString("SSN"));
    			customer.setFirstName(rs.getString("FirstName"));
    			customer.setLastName(rs.getString("LastName"));
    			customer.setAddress(rs.getString("Street"));
    			customer.setCity(rs.getString("City"));
    			customer.setState(rs.getString("State"));
    			customer.setZipCode(rs.getInt("Zipcode"));
    			customer.setTelephone(rs.getString("Telephone"));
    			customer.setEmail(rs.getString("Email"));
    			customer.setAccNum(rs.getString("AcctNum"));
    			customer.setAccCreateDate(rs.getString("AcctCreationDate"));
    			customer.setCreditCard(rs.getString("CardNumber"));
    			customer.setPpp(rs.getString("PPP"));
    			customer.setRating(rs.getInt("Rating"));
    			customer.setDateLastActive(rs.getString("DateOfLastAct"));
    			customers.add(customer);
        	}
		} catch (Exception e) {
        	System.out.println(e);
        }

		return customers;
	}

	public List<Customer> getDatedCustomers(String primary){
		List<Customer> customers = new ArrayList<Customer>();

		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery(
        		"SELECT Date.Profile1 FROM User, Date WHERE Date.Profile2 = \'" + primary
        		+ "\' UNION SELECT Date.Profile2 FROM User, Date WHERE Date.Profile1 = \'" + primary + "\';");
        	while (rs.next()) {
        		Customer customer = new Customer();
        		customer.setPassword(rs.getString("Password"));
    			customer.setUserID(rs.getString("SSN"));
    			customer.setUserSSN(rs.getString("SSN"));
    			customer.setFirstName(rs.getString("FirstName"));
    			customer.setLastName(rs.getString("LastName"));
    			customer.setAddress(rs.getString("Street"));
    			customer.setCity(rs.getString("City"));
    			customer.setState(rs.getString("State"));
    			customer.setZipCode(rs.getInt("Zipcode"));
    			customer.setTelephone(rs.getString("Telephone"));
    			customer.setEmail(rs.getString("Email"));
    			customer.setAccNum(rs.getString("AcctNum"));
    			customer.setAccCreateDate(rs.getString("AcctCreationDate"));
    			customer.setCreditCard(rs.getString("CardNumber"));
    			customer.setPpp(rs.getString("PPP"));
    			customer.setRating(rs.getInt("Rating"));
    			customer.setDateLastActive(rs.getString("DateOfLastAct"));
    			customers.add(customer);
        	}
		} catch (Exception e) {
        	System.out.println(e);
        }

		return customers;
	}

	public List<Customer> getHighestRatedCustomer(){
		List<Customer> customers = new ArrayList<Customer>();

		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery(
        		"SELECT Profile1 FROM Date ORDER BY (SELECT Sum(User2Rating) FROM Date WHERE Profile1 = Date.Profile1) DESC;");
        	while (rs.next()) {
        		Customer customer = new Customer();
        		customer.setPassword(rs.getString("Password"));
    			customer.setUserID(rs.getString("SSN"));
    			customer.setUserSSN(rs.getString("SSN"));
    			customer.setFirstName(rs.getString("FirstName"));
    			customer.setLastName(rs.getString("LastName"));
    			customer.setAddress(rs.getString("Street"));
    			customer.setCity(rs.getString("City"));
    			customer.setState(rs.getString("State"));
    			customer.setZipCode(rs.getInt("Zipcode"));
    			customer.setTelephone(rs.getString("Telephone"));
    			customer.setEmail(rs.getString("Email"));
    			customer.setAccNum(rs.getString("AcctNum"));
    			customer.setAccCreateDate(rs.getString("AcctCreationDate"));
    			customer.setCreditCard(rs.getString("CardNumber"));
    			customer.setPpp(rs.getString("PPP"));
    			customer.setRating(rs.getInt("Rating"));
    			customer.setDateLastActive(rs.getString("DateOfLastAct"));
    			customers.add(customer);
        	}
		} catch (Exception e) {
        	System.out.println(e);
        }

		return customers;
	}


	public List<Customer> getDateSuggestions(String userID) {
		List<Customer> customers = new ArrayList<Customer>();

		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery(
        		"SELECT p.* FROM Profile p, Date d WHERE d.Profile1 = \'"
        		+ userID + "\' AND d.Profile2 = p.ProfileID AND (User1Rating+User2Rating) > 3");
        	while (rs.next()) {
        		Customer customer = new Customer();
        		customer.setPassword(rs.getString("Password"));
    			customer.setUserID(rs.getString("SSN"));
    			customer.setUserSSN(rs.getString("SSN"));
    			customer.setFirstName(rs.getString("FirstName"));
    			customer.setLastName(rs.getString("LastName"));
    			customer.setAddress(rs.getString("Street"));
    			customer.setCity(rs.getString("City"));
    			customer.setState(rs.getString("State"));
    			customer.setZipCode(rs.getInt("Zipcode"));
    			customer.setTelephone(rs.getString("Telephone"));
    			customer.setEmail(rs.getString("Email"));
    			customer.setAccNum(rs.getString("AcctNum"));
    			customer.setAccCreateDate(rs.getString("AcctCreationDate"));
    			customer.setCreditCard(rs.getString("CardNumber"));
    			customer.setPpp(rs.getString("PPP"));
    			customer.setRating(rs.getInt("Rating"));
    			customer.setDateLastActive(rs.getString("DateOfLastAct"));
    			customers.add(customer);
        	}
		} catch (Exception e) {
        	System.out.println(e);
        }

		return customers;
	}


}
