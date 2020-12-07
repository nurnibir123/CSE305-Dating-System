package dao;

import model.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DateDao {
	String dbpath = "jdbc:mysql://localhost:3306/cse305";
	String dbuser = "root";
	String dbpass = "root";

	//tested
    public String addDate(Date date) {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			
			String cmd = String.format("INSERT INTO Date VALUES ('%s', '%s', '%s', '%s', '%s', %d, '%s', %d, %d)", 
					date.getUser1ID(),
					date.getUser2ID(),
					date.getCustRepresentative(),
					date.getDate(),
					date.getGeolocation(),
					date.getBookingfee(),
					date.getComments(),
					date.getUser1Rating(),
					date.getUser2Rating());
			st.execute(cmd);
    	} catch(Exception e) {
			System.out.println(e);
			return "failure";
		}
        return "Success";
    }


    //tested 
    public List<Date> getDatesByCalendar(String calendarDate) {
        List<Date> dates = new ArrayList<Date>();
        
        try {
        	System.out.println("changed date: " + calendarDate);
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Date WHERE Date(Date_Time) = Date('" + calendarDate + "')");
			
			while(rs.next()) {
				Date date = new Date();
				date.setDateID(rs.getString("Profile1") + rs.getString("Profile2") +rs.getString("Date_Time"));
				date.setUser1ID(rs.getString("Profile1"));
				date.setUser2ID(rs.getString("Profile2"));
				date.setDate(rs.getString("Date_Time"));
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(rs.getInt("BookingFee"));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(rs.getInt("User1Rating"));
				date.setUser2Rating(rs.getInt("User2Rating"));
				dates.add(date);
			}
        } catch(Exception e) {
        	System.out.println(e);
        }

        return dates;
    }

    // where?
    public List<Date> getDatesByMonthYear(String month, String year) {
        List<Date> dates = new ArrayList<Date>();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Date WHERE Date(Date_Time) LIKE  Date('" + year + "-" + month + "%')");
			
			while(rs.next()) {
				Date date = new Date();
				date.setDateID(rs.getString("Profile1") + rs.getString("Profile2") +rs.getString("Date_Time"));
				date.setUser1ID(rs.getString("Profile1"));
				date.setUser2ID(rs.getString("Profile2"));
				date.setDate(rs.getString("Date_Time"));
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(rs.getInt("BookingFee"));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(rs.getInt("User1Rating"));
				date.setUser2Rating(rs.getInt("User2Rating"));
				dates.add(date);
			}
        } catch(Exception e) {
        	System.out.println(e);
        }

        return dates;
    }

    //tested
    public List<Date> getDatesByCustomerName(String customerName) {
        List<Date> dates = new ArrayList<Date>();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Date WHERE Profile1 = '" + customerName + "' OR Profile2 = '" + customerName + "'");
			
			while(rs.next()) {
				Date date = new Date();
				date.setDateID(rs.getString("Profile1") + rs.getString("Profile2") +rs.getString("Date_Time"));
				date.setUser1ID(rs.getString("Profile1"));
				date.setUser2ID(rs.getString("Profile2"));
				date.setDate(rs.getString("Date_Time"));
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(rs.getInt("BookingFee"));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(rs.getInt("User1Rating"));
				date.setUser2Rating(rs.getInt("User2Rating"));
				dates.add(date);
			}
        } catch(Exception e) {
        	System.out.println(e);
        }

        return dates;
    }

    public List<Date> getHighestRatedCalendarDate() {
        List<Date> dates = new ArrayList<Date>();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Date ORDER BY (User1Rating+User2Rating) DESC");
			
			while(rs.next()) {
				Date date = new Date();
				date.setDateID(rs.getString("Profile1") + rs.getString("Profile2") +rs.getString("Date_Time"));
				date.setUser1ID(rs.getString("Profile1"));
				date.setUser2ID(rs.getString("Profile2"));
				date.setDate(rs.getString("Date_Time"));
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(rs.getInt("BookingFee"));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(rs.getInt("User1Rating"));
				date.setUser2Rating(rs.getInt("User2Rating"));
				dates.add(date);
			}
        } catch(Exception e) {
        	System.out.println(e);
        }

        return dates;
    }


    public List<Date> getOpenDates() {
        List<Date> dates = new ArrayList<Date>();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			// open dates doesn't have ratings yet
			ResultSet rs = st.executeQuery("SELECT * FROM Date");
			
			while(rs.next()) {
				Date date = new Date();
				date.setDateID(rs.getString("Profile1") + rs.getString("Profile2") +rs.getString("Date_Time"));
				date.setUser1ID(rs.getString("Profile1"));
				date.setUser2ID(rs.getString("Profile2"));
				date.setDate(rs.getString("Date_Time"));
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(rs.getInt("BookingFee"));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(rs.getInt("User1Rating"));
				date.setUser2Rating(rs.getInt("User2Rating"));
				dates.add(date);
			}
        } catch(Exception e) {
        	System.out.println(e);
        }

        return dates;
    }

    public String setNewDate(String user1, String user2) {
    	Date date = new Date();
    	date.setUser1ID(user1);
    	date.setUser2ID(user2);
    	addDate(date);
        return "Successfull date b/w " + user1 + " and " + user2;
    }

    public String cancelDate(String dateID) {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			String cmd = String.format("DELETE FROM Date Where INSTR(%s, Profile1) > 0 AND INSTR(%s, Profile2) > 0 AND INSTR(%s, Date_Time) > 0", dateID, dateID, dateID);
			st.executeQuery(cmd);
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    	
        return "Date - " + dateID + " is now cancelled";
    }

    public String commentDate(String dateID, String comment) {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			String cmd = String.format("UPDATE DATE SET Comment = %s Where INSTR(%s, Profile1) > 0 AND INSTR(%s, Profile2) > 0 AND INSTR(%s, Date_Time) > 0", comment, dateID, dateID, dateID);
			st.executeQuery(cmd);
    	} catch(Exception e) {
    		System.out.println(e);
    	}
        return "Date - " + dateID + " has new comment - " + comment;
    }

    public String getSalesReport(String month, String year) {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			String cmd = String.format("SELECT SUM(BookingFee) FROM Date WHERE Date_Time LIKE '" + year + "-" + month + "%'");
			ResultSet rs = st.executeQuery(cmd);
			return rs.getString(0);
    	} catch(Exception e) {
    		System.out.println(e);
    	}
        return null;
    }

    public List<Date> getPendingDates(String user) {
        List<Date> dates = new ArrayList<Date>();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT P.ProfileID, D.CustRep, D.Date_Time, D.Location "
					+ "FROM Profile AS P "
					+ "INNER JOIN Date AS D "
					+ "ON P.ProfileID=D.Profile1 "
					+ "WHERE P.ProfileID='" + user + "' AND "
					+ "D.Date_Time >= NOW()");
			
			while(rs.next()) {
				Date date = new Date();
				date.setDateID(rs.getString("Profile1") + rs.getString("Profile2") +rs.getString("Date_Time"));
				date.setUser1ID(rs.getString("Profile1"));
				date.setUser2ID(rs.getString("Profile2"));
				date.setDate(rs.getString("Date_Time"));
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(rs.getInt("BookingFee"));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(rs.getInt("User1Rating"));
				date.setUser2Rating(rs.getInt("User2Rating"));
				dates.add(date);
			}
        } catch(Exception e) {
        	System.out.println(e);
        }

        return dates;
    }

    public List<Date> getPastDates(String user) {

        List<Date> dates = new ArrayList<Date>();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT P.ProfileID, D.CustRep, D.Date_Time, D.Location "
					+ "FROM Profile AS P "
					+ "INNER JOIN Date AS D "
					+ "ON P.ProfileID=D.Profile1 "
					+ "WHERE P.ProfileID= '" + user + "' AND "
					+ "D.Date_Time < NOW() ");
			
			while(rs.next()) {
				Date date = new Date();
				date.setDateID(rs.getString("Profile1") + rs.getString("Profile2") +rs.getString("Date_Time"));
				date.setUser1ID(rs.getString("Profile1"));
				date.setUser2ID(rs.getString("Profile2"));
				date.setDate(rs.getString("Date_Time"));
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(rs.getInt("BookingFee"));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(rs.getInt("User1Rating"));
				date.setUser2Rating(rs.getInt("User2Rating"));
				dates.add(date);
			}
        } catch(Exception e) {
        	System.out.println(e);
        }

        return dates;
    }


    public String getMostPopularLocation(String user) {
    	try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT D.Location  "
					+ "FROM Date AS D "
					+ "GROUP BY D.Location "
					+ "ORDER BY COUNT(D.Location) DESC"
					+ "WHERE D.profile1 = " + user);
			return rs.getString(0);
        } catch(Exception e) {
        	System.out.println(e);
        }
    	return null;
    }


    public List<Date> getDateSuggestions(String user) {

        List<Date> dates = new ArrayList<Date>();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();

			String cmd = String.format("SELECT * FROM Profile "
					+ "WHERE ProfileID = '%s' "
					+ "AND INSTR(Profile.Hobbies, hobies) > 0 "
					+ "AND OwnerSSN <> Profile.OwnerSSN", user);
			ResultSet rs = st.executeQuery(cmd);
			
			while(rs.next()) {
				Date date = new Date();
				date.setDateID(rs.getString("Profile1") + rs.getString("Profile2") +rs.getString("Date_Time"));
				date.setUser1ID(rs.getString("Profile1"));
				date.setUser2ID(rs.getString("Profile2"));
				date.setDate(rs.getString("Date_Time"));
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(rs.getInt("BookingFee"));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(rs.getInt("User1Rating"));
				date.setUser2Rating(rs.getInt("User2Rating"));
				dates.add(date);
			}
        } catch(Exception e) {
        	System.out.println(e);
        }

        return dates;
    }

    public List<Date> getRevenueByCalendar(String calendarDate) {
        List<Date> dates = new ArrayList<Date>();

        try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbpath, dbuser, dbpass);
			Statement st = con.createStatement();
			String cmd = String.format("SELECT * FROM Date WHERE Date_Time = " + calendarDate);
			ResultSet rs = st.executeQuery(cmd);
			
			while(rs.next()) {
				Date date = new Date();
				date.setDateID(rs.getString("Profile1") + rs.getString("Profile2") +rs.getString("Date_Time"));
				date.setUser1ID(rs.getString("Profile1"));
				date.setUser2ID(rs.getString("Profile2"));
				date.setDate(rs.getString("Date_Time"));
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(rs.getInt("BookingFee"));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(rs.getInt("User1Rating"));
				date.setUser2Rating(rs.getInt("User2Rating"));
				dates.add(date);
			}
    	} catch(Exception e) {
    		System.out.println(e);
    	}

        return dates;
    }
}
