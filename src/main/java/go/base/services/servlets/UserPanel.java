package go.base.services.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UserPanel
 * Handles user navigation based on selected options.
 * Supports redirection to booking or booking-details JSP pages.
 */
@WebServlet("/UserPanel")
public class UserPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET requests and redirects the user based on their selected choice.
	 * Choices:
	 * 1 → Redirects to book-flight.jsp
	 * 2 → Redirects to booking-details.jsp
	 * Any other input → Responds with "Invalid choice"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Set status to 200 OK as the request is being processed
		response.setStatus(HttpServletResponse.SC_OK);

        String choice = request.getParameter("choice");

        if (choice == null) {
            // Initial load — just forward to admin.jsp
            request.getRequestDispatcher("admin.jsp").forward(request, response);
            return;
        }

        switch (choice) {
            case "1":
                response.sendRedirect("book-flight.jsp"); 
                break;
            case "2":
                response.sendRedirect("view-booking.jsp");
                break;
            default:
                response.sendRedirect("user.jsp?error=InvalidChoice");
        }
	}
}
