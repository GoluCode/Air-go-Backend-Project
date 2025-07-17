package go.base.services.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import go.base.Flight;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessPayment
 */
@WebServlet("/ProcessPayment")
public class ProcessPayment extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flightId = request.getParameter("flightId");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String travelClass = request.getParameter("travelClass");
        String age = request.getParameter("age");

        if (flightId == null || flightId.isEmpty()) {
            response.sendRedirect("error.jsp");
            return;
        }

        HttpSession session = request.getSession();

        // Store passenger info
        List<String> passengerDetails = new ArrayList<>();
        passengerDetails.add(name);
        passengerDetails.add(gender);
        passengerDetails.add(travelClass);
        passengerDetails.add(age);
        session.setAttribute("passenger_details", passengerDetails);

        // Store selected flight
        List<Flight> availableFlights = (List<Flight>) session.getAttribute("available");
        if (availableFlights != null) {
            for (Flight f : availableFlights) {
                if (f.getFlightId().equals(flightId)) {
                    session.setAttribute("selected_flight", f);
                    break;
                }
            }
        }

        
        response.sendRedirect("payment.jsp");
    }
}
