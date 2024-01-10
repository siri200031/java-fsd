<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h1>Please Login to access the Portal</h1>
<form action="login" method="post" >
<table>
<tr><td>Email</td><td><input type="text" name="email" required></td></tr>
<tr><td>Password</td><td><input type="password" name="password" required></td></tr>
<tr><td></td><td><input type="submit" value="Login"></td></tr>
</table>
</form>
<br><br>
<form action="register.jsp">
<input type="submit" value="New User? Click to Register">
</form>

</body>
</html>