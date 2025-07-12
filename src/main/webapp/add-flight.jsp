<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Flight</title>
</head>
<body>

<h2>🛫 Add New Flight</h2>

<form action="AddFlightServlet" method="post">
    <p>
        <label>Flight ID:</label>
        <input type="text" name="flightId" required />
    </p>
    <p>
        <label>Vendor:</label>
        <input type="text" name="vendor" required />
    </p>
    <p>
        <label>Fly Time (HH:mm:ss):</label>
        <input type="text" name="flyTime" placeholder="e.g. 14:30:00" required />
    </p>
    <p>
        <label>Source:</label>
        <input type="text" name="source" required />
    </p>
    <p>
        <label>Destination:</label>
        <input type="text" name="destination" required />
    </p>
    <p>
        <label>Total Seats:</label>
        <input type="number" name="totalSeats" required />
    </p>
    <p>
        <label>Available Seats:</label>
        <input type="number" name="availableSeats" required />
    </p>
    <p>
        <label>Fare (₹):</label>
        <input type="number" name="fare" required />
    </p>
    <p>
        <label>Class:</label>
        <select name="fclass" required>
            <option value="E">Economy</option>
            <option value="B">Business</option>
            <option value="F">First Class</option>
        </select>
    </p>

    <input type="submit" value="Add Flight" />
</form>

</body>
</html>
