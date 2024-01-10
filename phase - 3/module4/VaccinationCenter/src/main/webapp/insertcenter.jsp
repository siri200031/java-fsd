<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Center</title>
</head>
<body>
<h2>Add New Vaccination Center</h2>
<form action="insertcenter" >
<table>
<tr><td>Center Name</td><td><input type="text" name="name" required></td></tr>
<tr><td>Center City</td><td><input type="text" name="city" required></td></tr>
<tr><td></td><td><input type="submit" value="Add"></td></tr>
</table>
</form>
</body>
</html>