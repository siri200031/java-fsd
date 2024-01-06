<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
<h2>Railway Crossing</h2>
<h4>User Login</h4>
<form action="login" method="post">
<label for="email">Email:</label> <input type="text" id="email"
name="email" required><br> <label
for="password">Password:</label>
<input type="password" id="password" name="password" required><br>
<button type="submit">Login</button>
</form>
<p>
Don't have an account? <a href="userRegister.jsp">Create New
Account</a>
</p>
</body>
</html>