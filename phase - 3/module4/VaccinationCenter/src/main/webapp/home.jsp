<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
td {
  width: 400px; 
}
 a {
        font-size: 20px;
        font-weight: bold;
     }
</style>
</head>
<body>
<table align="center" cellpadding=20>
<tr align="center">
<td><a href="/citizens">Citizens</a></td>
<td><a href="/vaccinationcenter">Vaccination Centers</a></td>
<td><a href="/logout">Logout</a></td>
<td>Welcome <%= session.getAttribute("email") %></td>
</tr>
</table>
<hr>
</body>
</html>