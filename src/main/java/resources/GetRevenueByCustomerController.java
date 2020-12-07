package resources;

import dao.DateDao;
import dao.ProfileDao;
import model.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class GetDatesByCalendarDateController
 */
public class GetRevenueByCustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRevenueByCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String searchKeyword = request.getParameter("customer_name");

        DateDao dao = new DateDao();
        ProfileDao pdao = new ProfileDao();

        // Use these daos to get the result

        List<Date> dates = new ArrayList<Date>();

        /*Sample data begins*/
        for (int i = 0; i < 10; i++) {
            Date date = new Date();
            date.setDateID(request.getParameter(""));
    		date.setUser1ID(request.getParameter("user1ID"));
    		date.setUser2ID(request.getParameter("user2ID"));
    		date.setDate(request.getParameter("date"));
    		date.setGeolocation(request.getParameter("Location"));
    		date.setBookingfee(Integer.parseInt(request.getParameter("fee")));
    		date.setCustRepresentative(request.getParameter("custRep"));
    		date.setComments(request.getParameter("Comments"));
    		date.setUser1Rating(Integer.parseInt(request.getParameter("user1Rating")));
    		date.setUser2Rating(Integer.parseInt(request.getParameter("user2Rating")));
            dates.add(date);
        }
        /*Sample data ends*/

        request.setAttribute("dates", dates);
        request.setAttribute("customer", "cust_id");

        RequestDispatcher rd = request.getRequestDispatcher("showRevenueByCustomer.jsp");
        rd.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
