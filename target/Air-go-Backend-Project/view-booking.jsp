<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="air.go.files.BookingLogs.BookingEntry"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check My Booking</title>
</head>
<body>

	<h2>🔎 Check Your Booking</h2>

	<form method="get" action="GetBookingDetails">
		<label for="pnr">Enter your PNR:</label> <input type="text" id="pnr"
			name="pnr" required> <input type="submit"
			value="View Booking">
	</form>

	<%
    BookingEntry entry = (BookingEntry) request.getAttribute("bookingEntry");
    String error = (String) request.getAttribute("error");

    if (entry != null) {
%>
	<h3>✅ Booking Details</h3>
	<ul>
		<li><strong>Name:</strong> <%= entry.name %></li>
		<li><strong>Booking ID:</strong> <%= entry.bookingId %></li>
		<li><strong>Flight ID:</strong> <%= entry.flightId %></li>
		<li><strong>Vendor:</strong> <%= entry.vendor %></li>
		<li><strong>Class:</strong> <%= entry.travelClass %></li>
		<li><strong>PNR:</strong> <%= entry.pnr %></li>
	</ul>

	<form action="LogoutServlet" method="post"
		style="display: inline; margin-left: 20px;">
		<button type="submit">🔒 Logout</button>
	</form>
	<%
    } else if (error != null) {
%>
	<p style="color: red;"><%= error %></p>
	<%
    }
%>

</body>
</html>
