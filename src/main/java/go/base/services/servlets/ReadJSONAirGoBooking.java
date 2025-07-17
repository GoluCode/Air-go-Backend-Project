package go.base.services.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;




import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ReadJSONAirGoBooking
 */
@WebServlet("/ReadJSONAirGoBooking")
public class ReadJSONAirGoBooking extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();

		// Adjust the path if needed based on where your Data.json is deployed
		String filePath = "C:\\Shyam Sunder Roy\\Java Workspace\\Air-go-Backend-Project\\src\\main\\resources\\bookings.json";
		File file = new File(filePath);

		if (!file.exists()) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			out.println("{\"error\": \"JSON file not found\"}");
			return;
		}

		JsonNode root = objectMapper.readTree(file);


		if (!root.isArray()) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("{\"error\": \"JSON root is not an array\"}");
			return;
		}

		String idParam = request.getParameter("pnr");

		
		if (idParam == null) {
			response.setStatus(HttpServletResponse.SC_OK);
			out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
			return;
		}

		ArrayNode array = (ArrayNode) root;
		boolean found = false;

		for (JsonNode node : array) {
			JsonNode idNode = node.get("pnr");

			if (idNode != null && idNode.asText().equals(idParam)) {
				response.setStatus(HttpServletResponse.SC_OK);
				out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node));
				found = true;
				break;
			}
		}

		if (!found) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			out.println("{\"error\": \"No entry found for pnr: " + idParam + "\"}");
		}
	}
}
