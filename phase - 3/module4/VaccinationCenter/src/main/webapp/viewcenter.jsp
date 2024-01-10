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
<%@include file="home.jsp" %>
    <h2>Center Details</h2>
    <table border="1" style="width:50%;text-align:center">
        <tr>
            <th>Center ID</th>
            <th>Center Name</th>
            <th>Center City</th>
        </tr>
        <tr>
            <td><%= ((Center) request.getAttribute("center")).getId() %></td>
            <td><%= ((Center) request.getAttribute("center")).getCentername() %></td>
            <td><%= ((Center) request.getAttribute("center")).getCentercity() %></td>
        </tr>
    </table>
		
	<br><hr>
	
    <h2>All Citizens of this Center</h2>
    <table border="1" style="width:40%;text-align:center">
        <tr>
            <th>Citizen ID</th>
            <th>Name</th>
            <th>View</th>
           
        </tr>
        <% for (Citizen citizen : (List<Citizen>) request.getAttribute("citizens")) { %>
        <tr>
            <td style="width:120px"><%= citizen.getId() %></td>
            <td><%= citizen.getName() %></td>
            <td style="width:100px"><a href="viewcitizen?id=<%= citizen.getId() %>">View</a></td>
           
        </tr>
        <% } %>
    </table>
</body>
</html>