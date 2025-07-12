package go.base.services.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPanel
 */
@WebServlet("/AdminPanel")
public class AdminPanel extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "3":
                response.sendRedirect("edit-flight.jsp");
                break;
            case "4":
                response.sendRedirect("edit-password.jsp");
                break;
            case "5":
                response.sendRedirect("View-transactions.jsp");
                break;
            case "6":
                response.sendRedirect("add-flight.jsp");
                break;
            default:
                response.sendRedirect("admin.jsp?error=InvalidChoice");
        }
    }
}
