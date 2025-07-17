package go.base.services.servlets;

import java.io.IOException;
import java.io.PrintWriter;



import go.base.dao.HelperDao;
import go.base.services.impl.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import go.base.services.UserService;

/**
 * Servlet implementation class LoginServlet
 * Handles login requests and sets up session based on user roles (admin/manager/user).
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handles HTTP GET requests for user login.
	 * Validates user credentials, determines user role,
	 * creates session, and displays role-based options.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HelperDao dao = new HelperDao();
		PrintWriter out = response.getWriter();

		if (!dao.isExistingUser(username, password)) {
			out.println("Invalid user");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		String user_is = dao.getRole(username, password);
		ServiceFactory factory = new ServiceFactory();
		UserService service = factory.getServiceForRole(username, password);

		// Create HTTP session and store user-related information
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("role", user_is.toLowerCase());
		session.setAttribute("service", service); // Only if UserService is serializable or safely storable

		out.println("Select your Options:");

		switch (user_is.toLowerCase()) {
		case "admin":
			
			/**
			 * Creates session for Admin.
			 * Stores username, role, and service in session for centralized access.
			 * Admin has full privileges including booking, editing, and transaction viewing.
			 */
			
			response.sendRedirect("admin.jsp");
			
			break;

		case "manager":
			
			/**
			 * Creates session for Manager.
			 * Manager can book flights, view bookings, and edit flight/user details.
			 */
			
			response.sendRedirect("manager.jsp");
	
			
			break;

		case "user":
			
			/**
			 * Creates session for regular User.
			 * User has basic privileges such as booking and viewing their own bookings.
			 */
			
			response.sendRedirect("user.jsp");
			
			break;

		default:
			// Handles undefined roles
			out.print("Invalid role detected.");
			break;
		}
	}
}
