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
<title>Vaccinaion Center</title>

</head>

<%@include file="home.jsp" %>
<br><br>
<form action="insertcenter.jsp"><input type="submit" value="Add New Center"></form>
<%List<Center> c=(List<Center>)request.getAttribute("list"); %>
<table border="1" cellpadding=10 style="width:60%;text-align:center">
<tr><th>Id</th><th>Name</th><th>City</th><th>Action</th></tr>
<%for(Center center:c){ %>

<tr>
<td><%=center.getId() %></td>
<td><%=center.getCentername() %></td>
<td><%=center.getCentercity() %></td>
<td>
<a href="viewcenter?id=<%= center.getId() %>">View</a>&ensp;
<a href="editcenter?id=<%= center.getId() %>">Edit</a>&ensp;
<a href="deletecenter?id=<%= center.getId() %>">Delete</a>
</td>
</tr>

<%} %>
</table>


</html>