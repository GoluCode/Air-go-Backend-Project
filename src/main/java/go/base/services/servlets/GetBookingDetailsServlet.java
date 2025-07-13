package go.base.services.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import air.go.files.BookingLogs.BookingEntry;

/**
 * Servlet implementation class GetBookingDetailsServlet
 */
@WebServlet("/GetBookingDetails")
public class GetBookingDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pnr = request.getParameter("pnr");

        if (pnr == null || pnr.trim().isEmpty()) {
            request.setAttribute("error", "Please enter a PNR.");
            request.getRequestDispatcher("view-booking.jsp").forward(request, response);
            return;
        }

        File file = new File("C:\\Shyam Sunder Roy\\Java Workspace\\Air-go-Backend-Project\\src\\main\\resources\\bookings.json"); 
        ObjectMapper mapper = new ObjectMapper();

        if (!file.exists()) {
            request.setAttribute("error", "Booking data not available.");
            request.getRequestDispatcher("view-booking.jsp").forward(request, response);//
            return;
        }

        try {
            BookingEntry[] entries = mapper.readValue(file, BookingEntry[].class);
            for (BookingEntry entry : entries) {
                if (entry.pnr.equalsIgnoreCase(pnr)) {
                    request.setAttribute("bookingEntry", entry);
                    request.getRequestDispatcher("view-booking.jsp").forward(request, response);
                    return;
                }
            }

            request.setAttribute("error", "No booking found for PNR: " + pnr);
            request.getRequestDispatcher("view-booking.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while retrieving booking.");
            request.getRequestDispatcher("view-booking.jsp").forward(request, response);
        }
    }
}
