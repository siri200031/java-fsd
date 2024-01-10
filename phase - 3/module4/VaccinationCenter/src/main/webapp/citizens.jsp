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
<title>Citizen</title>

</head>
<body>
<%@include file="home.jsp" %>
<br><br>
<form action="addcitizen"><input type="submit" value="Add Citizen"></form>
<%List<Citizen> c=(List<Citizen>)request.getAttribute("list"); %>
<table border="1" cellpadding=10>
<tr><th>Id</th><th>Name</th><th>City</th><th>No.of Dose</th><th>Vaccination Status</th><th>Vaccination Center</th><th>Action</th></tr>
<%for(Citizen citizen:c){ %>

<tr style="text-align:center">
<td style="width:10px"><%=citizen.getId() %></td>
<td><%=citizen.getName() %></td>
<td><%=citizen.getCity() %></td>
<td style="width:200px"><%=citizen.getDose() %></td>
<td><%=citizen.getStatus() %></td>
<td><%=citizen.getCenter().getCentername() %></td>
<td>
<a href="viewcitizen?id=<%= citizen.getId() %>">View</a>&ensp;
<a href="editcitizen?id=<%= citizen.getId() %>">Edit</a>&ensp;
<a href="deletecitizen?id=<%= citizen.getId() %>">Delete</a>
</td>
</tr>

<%} %>
</table>

</body>
</html>