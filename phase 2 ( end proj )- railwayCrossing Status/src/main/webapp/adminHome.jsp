<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="com.RailwayCrossing"%>
<%@ page import="com.RailwayCrossingDAO"%>
<%@ page import="java.util.List"%>
<%
// Create an instance of RailwayCrossingDAO
RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
// Retrieve all crossings from the DAO
List<RailwayCrossing> crossings = crossingDAO.getAllCrossings();
// Get the ID from the search request parameter
String searchId = request.getParameter("searchId");
// Check if the searchId parameter is provided
if (searchId != null && !searchId.isEmpty()) {
// Parse the searchId as an int
int crossingId = Integer.parseInt(searchId);
// Retrieve the crossing by ID from the DAO
RailwayCrossing searchedCrossing = crossingDAO.getCrossingById(crossingId);
// Set the crossing as an attribute to be displayed in the table
request.setAttribute("crossing", searchedCrossing);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>
</head>
<body>
<h1>Admin Home Page</h1>
<h3>
Railway Crossing[<%=crossings.size()%>]
</h3>
<form action="HomePage.jsp" method="post">
<button type="submit">Home</button>
</form>
<form action="addRailCrossingForm.jsp" method="post">
<button type="submit">Add Railway Crossing</button>
</form>
<form action="searchCrossing" method="post">
<input type="text" name="searchId" placeholder="Enter ID">
<button type="submit">Search Crossing</button>
</form>
<form action="adminHome.jsp" method="post">
<button type="submit">Display All Railway Crossings</button>
</form>
<!-- Logout Button -->
<form action="adminLogin.jsp" method="post">
<button type="submit">Logout</button>
</form>
<!-- Table -->
<table width = "100%" border = "1">
<thead>
<tr>
<th>Sr.No</th>
<th>Name</th>
<th>Address</th>
<th>Landmark</th>
<th>Train Schedule</th>
<th>Person In-Charge</th>
<th>Status</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<%
if (request.getAttribute("crossing") != null) { // Check if a specific crossing is found
RailwayCrossing crossing = (RailwayCrossing)
request.getAttribute("crossing");
%>
<tr>
<td><%=crossing.getId()%></td>
<td><%=crossing.getName()%></td>
<td><%=crossing.getAddress()%></td>
<td><%=crossing.getLandmark()%></td>
<td><%=crossing.getTrainSchedule()%></td>
<td><%=crossing.getPersonInCharge()%></td>
<td><%=crossing.getStatus()%></td>
<td></td>
</tr>
<%
} else { // Display all crossings
for (RailwayCrossing anotherCrossing : crossings) {
%>
<tr>
<td><%=anotherCrossing.getId()%></td>
<td><%=anotherCrossing.getName()%></td>
<td><%=anotherCrossing.getAddress()%></td>
<td><%=anotherCrossing.getLandmark()%></td>
<td><%=anotherCrossing.getTrainSchedule()%></td>
<td><%=anotherCrossing.getPersonInCharge()%></td>
<td><%=anotherCrossing.getStatus()%></td>
<td>
<form action="updateRailCrossingForm.jsp" method="post">
<input type="hidden" name="id"
value="<%=anotherCrossing.getId()%>">
<button type="submit" class="update-button">Update</button>
</form>
<form action="deleteCrossing" method="post">
<input type="hidden" name="id"
value="<%=anotherCrossing.getId()%>">
<button type="submit" class="delete-button">Delete</button>
</form>
</td>
</tr>
<%
}
}
%>
</tbody>
</table>
</body>
</html>