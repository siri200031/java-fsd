<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.* "%>
    
    <%@ page import="com.example.demo.User.Center" %>
    <%@ page import="com.example.demo.User.Citizen" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Center</title>
</head>
<body>
<h2>Edit City Hospital</h2>
<form action="updatecenter">
<table>
<input type="hidden" value="<%= ((Center) request.getAttribute("center")).getId()%>" name="id">
<tr>
<th>Center Name</th><td><input type="text" value="<%= ((Center) request.getAttribute("center")).getCentername() %>" name="cname"></td>
</tr>
<tr><th>Center City</th><td><input type="text" value=" <%= ((Center) request.getAttribute("center")).getCentercity() %>" name="ccity"></td></tr>
<tr><td></td><td><input type="submit" value="Edit"></td></tr>
</table>
</form>

</body>
</html>