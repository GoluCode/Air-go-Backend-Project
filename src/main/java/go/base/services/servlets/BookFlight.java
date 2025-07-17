package go.base.services.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



import air.go.files.BookingLogs;
import go.base.BookingDetails;
import go.base.Flight;
import go.base.dao.FlightsDao;
import go.base.dao.HelperDao;
import go.base.dao.TransactionDao;
import go.base.services.UserService;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class BookFlight
 */
@WebServlet("/BookFlight")
public class BookFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setStatus(HttpServletResponse.SC_OK);

		String from = request.getParameter("from");
		String to = request.getParameter("to");

		List<Flight> available_flights = FlightsDao.getAvailableFlights(from, to);
		HttpSession session = request.getSession();
		session.setAttribute("available", available_flights);
		response.sendRedirect("show-aval-flights.jsp"); // this jsp is will show list of available flight

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// Fix 1: Correct session object type
		Flight selectedFlight = (Flight) session.getAttribute("selected_flight");
		if (selectedFlight == null) {
			response.getWriter().println("No flight selected.");
			return;
		}
		String flight_id = selectedFlight.getFlightId();

		// Fix 2: Correctly generate and assign Booking + Transaction IDs
		String bookingId = TransactionDao.generateBookingID();
		String transactionId = bookingId; // Ensure this method exists

		// Passenger data from session
		List<String> userFormData = (List<String>) session.getAttribute("passenger_details");
		if (userFormData == null || userFormData.size() < 1) {
			response.getWriter().println("Passenger info missing.");
			return;
		}
		String passenger_name = userFormData.get(0);
		String fclass = userFormData.get(2);
		String vendor = selectedFlight.getVendor();
		String pnr = HelperDao.generatePNR();

		// Fill booking details
		BookingDetails details = new BookingDetails();
		details.setBookigId(bookingId);
		details.setTransectionNo(transactionId); // THIS LINE FIXES THE ORA-01400
		details.setFlightId(flight_id);
		details.setPassengerName(passenger_name);
		details.setPnr(pnr);

		// Save in session for confirmation display (optional)
		session.setAttribute("bookingId", bookingId);
		session.setAttribute("transactionId", transactionId);
		session.setAttribute("pnr", pnr);

		// Book flight
		UserService sf = (UserService) session.getAttribute("service");
		PrintWriter out = response.getWriter();

		if (!sf.bookFilght(details)) {
			out.print("Booking failed");
		} else {
			BookingLogs.writeBookingDetail(bookingId, passenger_name, flight_id, vendor, fclass,pnr);
			response.sendRedirect("confirm.jsp");
		}
	}

}
