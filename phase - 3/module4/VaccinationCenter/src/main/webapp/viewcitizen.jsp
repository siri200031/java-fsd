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
<title>View</title>
</head>
<body>
<%@include file="home.jsp" %><br><br>
    <h2 align="center">Citizen Information</h2>
    <table border="1" cellpadding=20 align="center" style="width:400px;text-align:center">
    	<tr><th colspan="5"><%= ((Citizen) request.getAttribute("citizen")).getName() %></th></tr>
       
            <tr> <th> ID</th><td><%= ((Citizen) request.getAttribute("citizen")).getId() %></td> </tr>
            <tr> <th>City</th> <td><%= ((Citizen) request.getAttribute("citizen")).getCity() %></td> </tr>
            <tr> <th>No.of Dose</th><td><%= ((Citizen) request.getAttribute("citizen")).getDose() %></td> </tr>
            <tr> <th>Vaccination Status</th><td><%= ((Citizen) request.getAttribute("citizen")).getStatus() %></td> </tr>
            <tr> <th>Vaccination Center</th><td><a href="viewcenter?id=<%= ((Citizen) request.getAttribute("citizen")).getCenter().getId() %>">
            <%= ((Citizen) request.getAttribute("citizen")).getCenter().getCentername() %></a></td> </tr>

    </table>
</body>
</html>