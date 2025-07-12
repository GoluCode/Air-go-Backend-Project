<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="go.base.Flight" %>
<%@ page import="java.util.List" %>

<%
    String bookingId = (String) session.getAttribute("bookingId");
    String pnr = (String) session.getAttribute("pnr");
    List<String> passenger = (List<String>) session.getAttribute("passenger_details");
    Flight flight = (Flight) session.getAttribute("selected_flight");

    if (bookingId == null || pnr == null || passenger == null || flight == null) {
%>
    <p style="color:red;">Error: Some booking data is missing.</p>
<%
    } else {
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Confirmed</title>
</head>
<body>

<h2>🎉 Booking Confirmed!</h2>

<h3>Booking Summary</h3>
<table border="1">
    <tr><th>Booking ID</th><td><%= bookingId %></td></tr>
    <tr><th>Transaction ID</th><td><%= bookingId %></td></tr>
    <tr><th>PNR</th><td><%= pnr %></td></tr>
</table>

<h3>Passenger Details</h3>
<table border="1">
    <tr><th>Name</th><td><%= passenger.get(0) %></td></tr>
    <tr><th>Gender</th><td><%= passenger.get(1) %></td></tr>
    <tr><th>Class</th><td><%= passenger.get(2) %></td></tr>
    <tr><th>Age</th><td><%= passenger.get(3) %></td></tr>
</table>

<h3>Flight Details</h3>
<table border="1">
    <tr><th>Vendor</th><td><%= flight.getVendor() %></td></tr>
    <tr><th>Fly Time</th><td><%= flight.getFlyTime() %></td></tr>
    <tr><th>Fare</th><td>₹<%= flight.getFare() %></td></tr>
    <tr><th>Route</th><td><%= flight.getSource() %> → <%= flight.getDestination() %></td></tr>
</table>

<br>
<p>Thank you for booking with us! ✅</p>

<form action="LogoutServlet" method="post" style="display:inline; margin-left:20px;">
    <button type="submit">🔒 Logout</button>
</form>

</body>
</html>
<%
    }
%>
