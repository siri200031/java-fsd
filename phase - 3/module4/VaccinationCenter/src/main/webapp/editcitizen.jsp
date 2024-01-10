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
<title>Edit Citizen</title>
</head>
<body>
<h2>Edit Citizen</h2>
<form action="updatecitizen">
<%List<Center> centers=(List<Center>)request.getAttribute("list"); %>
<table>

<input type="hidden" value="<%= ((Citizen) request.getAttribute("citizen")).getId()%>" name="id">
<tr>
<th>Citizen Name</th><td><input type="text" value="<%= ((Citizen) request.getAttribute("citizen")).getName() %>" name="name"></td>
</tr>
<tr><th>Citizen City</th><td>
                    <select name="city" required>
                        <% for (Center center : centers) { %>
                            <option value="<%= center.getCentercity() %>"
                            <% if (center.getCentercity().equals(((Citizen) request.getAttribute("citizen")).getCity())) { %>
                        selected
                    <% } %>
                            ><%= center.getCentercity() %></option>
                        <% } %>
                    </select>
                </td></tr>
<tr><th>Center Name</th> <td>
                    <select name="center" required>
                        <% for (Center center : centers) { %>
                            <option value="<%= center.getCentername() %>"
                             <% if (center.getCentercity().equals(((Citizen) request.getAttribute("citizen")).getCenter().getCentername())) { %>
                        selected
                    <% } %>
                            ><%= center.getCentername() %></option>
                        <% } %>
                    </select>
                </td></tr>
<tr><th>No.of Dose</th><td><input type="number" value="<%= ((Citizen) request.getAttribute("citizen")).getDose() %>" name="dose"></td></tr>
<tr><td></td><td><input type="submit" value="Edit"></td></tr>
</table>
</form>

</body>
</html>