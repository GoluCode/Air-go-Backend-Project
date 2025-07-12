package go.base.services.servlets;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import go.base.Flight;
import go.base.services.impl.AdminServicesImpl;

@WebServlet("/AddFlightServlet")
public class AddFlightServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String flightId = request.getParameter("flightId");
            String vendor = request.getParameter("vendor");
            String flyTimeStr = request.getParameter("flyTime");
            String source = request.getParameter("source");
            String destination = request.getParameter("destination");
            int totalSeats = Integer.parseInt(request.getParameter("totalSeats"));
            int availableSeats = Integer.parseInt(request.getParameter("availableSeats"));
            int fare = Integer.parseInt(request.getParameter("fare"));
            char fclass = request.getParameter("fclass").charAt(0);

            Time flyTime = Time.valueOf(flyTimeStr);

            Flight flight = new Flight();
            flight.setFlightId(flightId);
            flight.setVendor(vendor);
            flight.setFlyTime(flyTime);
            flight.setSource(source);
            flight.setDestination(destination);
            flight.setTotalSeats(totalSeats);
            flight.setAvailableSeats(availableSeats);
            flight.setFare(fare);
            flight.setFclass(fclass);

            // ✅ Get admin service from session
            HttpSession session = request.getSession();
            AdminServicesImpl service = (AdminServicesImpl) session.getAttribute("service");

            if (service == null) {
                response.getWriter().println("Admin service not initialized.");
                return;
            }

            if (service.addNewFlights(flight)) {
                response.getWriter().println(" Flight added successfully.");
            } else {
                response.getWriter().println(" Failed to add flight.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(" Error: " + e.getMessage());
        }
    }
}
