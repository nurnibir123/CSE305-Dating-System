package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;

public class EmployeeDao {
	/*
	 * This class handles all the database operations related to the employee table
	 */
	
	public String addEmployee(Employee employee) {

		/*
		 * All the values of the add employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the employee details and return "success" or "failure" based on result of the database insertion.
		 */
		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	con.createStatement().execute(
        			"INSERT INTO Person VALUES (\'" + employee.getEmployeeID() + "\', \'"
        			+ employee.getPassword() + "\', \'" + employee.getFirstName() + "\', \'" + employee.getLastName()
        			+ "\', \'" + employee.getAddress() + "\', \'" + employee.getCity() + "\', \'" + employee.getState()
        			+ "\', " + employee.getZipCode() + ", NULL, NULL, \'" + employee.getEmail() + "\', \'"
        			+ employee.getTelephone() + "\')");
        	con.createStatement().execute(
        			"INSERT INTO Employee (\'" + employee.getEmployeeID() + "\', \'"
        			+ employee.getEmployeeRole() + "\', \'" + employee.getStartDate() + "\', "
        			+ employee.getHourlyRate() + ")");
        } catch (Exception e) {
        	System.out.println(e);
        	return "failure";
        }
        return "success";

	}

	public String editEmployee(Employee employee) {
		/*
		 * All the values of the edit employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		
		return this.addEmployee(employee);

	}

	public String deleteEmployee(String employeeID) {
		/*
		 * employeeID, which is the Employee's ID which has to be deleted, is given as method parameter
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
		
		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	con.createStatement().execute("DELETE FROM Employee WHERE SSN = \'" + employeeID + "\')");
        } catch (Exception e) {
        	System.out.println(e);
        	return "failure";
        }
        return "success";

	}

	
	public List<Employee> getEmployees() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Query to return details about all the employees must be implemented
		 * Each record is required to be encapsulated as a "Employee" class object and added to the "employees" List
		 */

		List<Employee> employees = new ArrayList<Employee>();
		
		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Employee AS E, Person AS P WHERE E.SSN = P.SSN)");
        	while (rs.next()) {
        		Employee employee = new Employee();
    			employee.setEmail(rs.getString("Email"));
    			employee.setFirstName(rs.getString("FirstName"));
    			employee.setLastName(rs.getString("LastName"));
    			employee.setEmployeeRole(rs.getString("EmployeeRole"));
    			employee.setAddress(rs.getString("Street"));
    			employee.setCity(rs.getString("City"));
    			employee.setStartDate(rs.getString("StartDate"));
    			employee.setState(rs.getString("State"));
    			employee.setZipCode(rs.getInt("Zipcode"));
    			employee.setTelephone(rs.getString("Telephone"));
    			employee.setEmployeeID(rs.getString("SSN"));
    			employee.setHourlyRate(rs.getFloat("HourlyRate"));
    			employees.add(employee);
        	}
		} catch (Exception e) {
        	System.out.println(e);
        }
		
		return employees;
	}

	public Employee getEmployee(String employeeID) {

		/*
		 * The students code to fetch data from the database based on "employeeID" will be written here
		 * employeeID, which is the Employee's ID who's details have to be fetched, is given as method parameter
		 * The record is required to be encapsulated as a "Employee" class object
		 */
		
		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery(
        		"SELECT * FROM Employee AS E, Person AS P WHERE E.SSN = P.SSN AND P.Email = \'"
        		+ employeeID + "\'");
        	rs.next();
    		Employee employee = new Employee();
			employee.setEmail(rs.getString("Email"));
			employee.setFirstName(rs.getString("FirstName"));
			employee.setLastName(rs.getString("LastName"));
			employee.setEmployeeRole(rs.getString("EmployeeRole"));
			employee.setAddress(rs.getString("Street"));
			employee.setCity(rs.getString("City"));
			employee.setStartDate(rs.getString("StartDate"));
			employee.setState(rs.getString("State"));
			employee.setZipCode(rs.getInt("Zipcode"));
			employee.setTelephone(rs.getString("Telephone"));
			employee.setEmployeeID(rs.getString("SSN"));
			employee.setHourlyRate(rs.getFloat("HourlyRate"));
			return employee;
		} catch (Exception e) {
        	System.out.println(e);
        }
		return null;
	}
	
	public String getEmployeeID(String username) {
		/*
		 * The students code to fetch data from the database based on "username" will be written here
		 * username, which is the Employee's email address who's Employee ID has to be fetched, is given as method parameter
		 * The Employee ID is required to be returned as a String
		 */

		try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305", "root", "root");
        	ResultSet rs = con.createStatement().executeQuery("SELECT SSN FROM Person WHERE Email = \'" + username + "\'");
        	rs.next();
			return rs.getString("SSN");
		} catch (Exception e) {
        	System.out.println(e);
        }
		return null;
	}

}
