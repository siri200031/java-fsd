<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h1>Register Here to enter the portal</h1>
<form action="register" method="post">
<table>
<tr><td>Name</td><td><input type="text" name="username" required></td></tr>
<tr><td>Email</td><td><input type="text" name="email" required></td></tr>
<tr><td>Password</td><td><input type="password" name="password" required></td></tr>
<tr><td></td><td><input type="submit" value="Register"></td></tr>
</table>
</form>
</body>
</html>