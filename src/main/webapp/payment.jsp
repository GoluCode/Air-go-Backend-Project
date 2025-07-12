<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="go.base.Flight" %>
<%@ page import="java.util.List" %>

<%
    Flight flight = (Flight) session.getAttribute("selected_flight");
    List<String> passenger = (List<String>) session.getAttribute("passenger_details");

    if (flight == null || passenger == null) {
%>
    <p>Error: Missing booking information. Please go back and retry.</p>
<%
    } else {
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Confirmation</title>
</head>
<body>

<h2>Booking Confirmation</h2>

<h3>Flight Details</h3>
<table border="1">
    <tr><th>Vendor</th><td><%= flight.getVendor() %></td></tr>
    <tr><th>Fly Time</th><td><%= flight.getFlyTime() %></td></tr>
    <tr><th>Fare</th><td>₹<%= flight.getFare() %></td></tr>
    <tr><th>Seats Available</th><td><%= flight.getAvailableSeats() %></td></tr>
</table>

<h3>Passenger Details</h3>
<table border="1">
    <tr><th>Name</th><td><%= passenger.get(0) %></td></tr>
    <tr><th>Gender</th><td><%= passenger.get(1) %></td></tr>
    <tr><th>Class</th><td><%= passenger.get(2) %></td></tr>
    <tr><th>Age</th><td><%= passenger.get(3) %></td></tr>
    
</table>

<br>

<form action="BookFlight" method="post">
    <input type="submit" value="Confirm Booking & Pay">
</form>

</body>
</html>
<%
    }
%>
