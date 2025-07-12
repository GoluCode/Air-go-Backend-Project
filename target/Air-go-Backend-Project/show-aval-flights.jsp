<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="go.base.Flight" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Available Flights</h2>

<div class="container">
    <table>
        <thead>
        <tr>
            <th>Vendor Name</th>
            <th>Fly Time</th>
            <th>Available Seats</th>
            <th>Seat Fare / Person</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
        	
            List<Flight> flights = (List<Flight>) session.getAttribute("available");
            if (flights != null && !flights.isEmpty()) {
                for (Flight flight : flights) {
        %>
        <tr>
            <td><%=flight.getVendor() %></td>
            <td><%= flight.getFlyTime() %></td>
            <td><%= flight.getAvailableSeats() %></td>
            <td>₹<%= flight.getFare() %></td>
            <td>
                <form action="booking-form.jsp" method="get">  <!-- This code show a book button crossponds to available flight -->
                    <input type="hidden" name="flightId" value="<%= flight.getFlightId() %>"/>
                    <button type="submit" class="book-btn">Book Now</button>
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">No flights available.</td>
        </tr>
        <%
            }
           
        %>
        </tbody>
    </table>
</div>
	
</body>
</html>