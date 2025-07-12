<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AdminPanel" method="get">
    <label>Select your Option:</label>
    <select name="choice">
        <option value="1">Book Flight</option>
        <option value="2">Booking Details</option>
        <option value="3">Edit Flight Details</option>
        <option value="4">Edit User Password</option>
        <option value="5">Transaction Details</option>
        <option value="6">Add New Flight</option>
    </select>
    <input type="submit" value="Submit">
</form>

</body>
</html>