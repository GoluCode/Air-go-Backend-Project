<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="go.base.Flight" %>

<%
    String flightId = request.getParameter("flightId");
    Flight selectedFlight = null;

    List<Flight> availableFlights = (List<Flight>) session.getAttribute("available");

    if (availableFlights != null && flightId != null) {
        for (Flight f : availableFlights) {
            if (f.getFlightId().equals(flightId)) {
                selectedFlight = f;
                session.setAttribute("selected_flight", f); // Store for later use
                break;
            }
        }
    }

    if (selectedFlight == null) {
%>
    <p>Invalid flight selection. Please go back and try again.</p>
<%
    }
%>

<form action="ProcessPayment" method="get">
    <input type="hidden" name="flightId" value="<%= selectedFlight.getFlightId() %>" />

    <p>
        Name: <input type="text" name="name" required>
    </p>
    <p>
        Gender:
        <label><input type="radio" name="gender" value="Male" required> Male</label>
        <label><input type="radio" name="gender" value="Female"> Female</label>
        <label><input type="radio" name="gender" value="Other"> Other</label>
    </p>
    <p>
        Class:
        <select name="travelClass" required>
            <option value="">--Select--</option>
            <option value="Economy">Economy</option>
            <option value="Business">Business</option>
            <option value="First">First</option>
        </select>
    </p>
    <p>
        Age: <input type="number" name="age" min="1" max="120" required>
    </p>
    <p>
        <input type="submit" value="Submit Payment">
    </p>
</form>

