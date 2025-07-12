<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="air.go.files.CreateDocument"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="GetDocxServlet" method="post">
		Path: <input type="text" name="path"> 
		<input type="submit" value="submit">
	</form>
</body>
</html>