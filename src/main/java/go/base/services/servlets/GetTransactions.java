package go.base.services.servlets;

import java.io.IOException;
import java.util.List;



import go.base.Transactions;
import go.base.services.impl.AdminServicesImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GetTransactions
 */
@WebServlet("/GetTransactions")
public class GetTransactions extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("service") == null) {
            response.getWriter().println("Session expired or service not initialized.");
            return;
        }

        AdminServicesImpl userService = (AdminServicesImpl) session.getAttribute("service");

        try {
            List<Transactions> txList = userService.getAllTransactions(); 
            request.setAttribute("transactions", txList);
            request.getRequestDispatcher("view-transactions.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error fetching transactions.");
        }
    }
}
