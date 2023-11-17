<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
<h2>Railway Crossing</h2>
<h4>User Register</h4>
<form action="register" method="post">
<label for="name">Name:</label> <input type="text" id="name"
name="name" required><br> <label for="email">Email:</label>
<input type="text" id="email" name="email" required><br>
<label for="password">Password:</label> <input type="password"
id="password" name="password" required><br>
<button type="submit">Register</button>
</form>
<p>
Already have an account? <a href="userLogin.jsp">Sign in</a>
</p>
</body>
</html>