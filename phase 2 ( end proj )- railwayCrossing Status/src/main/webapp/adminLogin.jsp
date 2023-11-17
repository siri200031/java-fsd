<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body>
<h2 style = "text-align:center">Railway Crossing</h2>
<h4 style = "text-align:center">Admin Login</h4>
<form action="adminLogin" method="post" style = "text-align:center">
<label for="email">Email : </label>
<input type="text" id="email" name="email" required><br> <br>
<label for="password">Password : </label>
<input type="password" id="password" name="password"
required><br><br>
<button type="submit">Login</button>
</form>
</body>
</html>