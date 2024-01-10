<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.*" %>
<%@ page import="java.util.* "%>
<%@ page import="com.example.demo.User.Center" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Citizen</title>
</head>
<body>
    <h1>Add Citizen Details</h1>
    <form action="insertcitizen">
        <% List<Center> centers = (List<Center>) request.getAttribute("list"); %>
        <table>
            <tr>
                <td>Citizen Name</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>Citizen City</td>
                <td>
                    <select name="city" id="citySelect" required>
                        <% for (Center center : centers) { %>
                            <option value="<%= center.getCentercity() %>"><%= center.getCentercity() %></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Center Name</td>
                <td>
                    <select name="center" id="centerSelect" required>
                        <% for (Center center : centers) { %>
                            <option value="<%= center.getCentername() %>"><%= center.getCentername() %></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add"></td>
            </tr>
        </table>
    </form>
    
    <script>
        document.getElementById('citySelect').addEventListener('change', function() {
            var selectedCity = this.value;
            var centerSelect = document.getElementById('centerSelect');
            
            // Clear existing options
            centerSelect.innerHTML = '';
            
            // Add options for centers in the selected city
            <% for (Center center : centers) { %>
                if ("<%= center.getCentercity() %>" === selectedCity) {
                    var option = document.createElement('option');
                    option.value = '<%= center.getCentername() %>';
                    option.innerHTML = '<%= center.getCentername() %>';
                    centerSelect.appendChild(option);
                }
            <% } %>
        });
    </script>
</body>
</html>