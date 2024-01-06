<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="com.RailwayCrossing"%>
<%@ page import="com.RailwayCrossingDAO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Railway Crossings - User Home Page</title>
</head>
<body>
<h1>User Home Page</h1>
<!-- Display Home button -->
<button onclick="location.href='HomePage.jsp'">Home</button>
<!-- Display All button -->
<button onclick="location.href='userHome.jsp'">All Crossings</button>
<!-- Display Favorite Crossings button -->
<button onclick="location.href='userHomeFavoriteCrossing.jsp'">Favorite Crossings</button>
<!-- Display Search Crossings button -->
<button onclick="location.href='userSearchCrossing.jsp'">Search Crossings</button>
<!-- Logout button -->
<button onclick="location.href='userLogin.jsp'">Logout</button>
<%-- Create an instance of RailwayCrossingDAO --%>
<%
RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
List<RailwayCrossing> allCrossings = crossingDAO.getAllCrossings();
for (RailwayCrossing crossing : allCrossings) {
String status = crossing.getStatus();
String statusClass = status.equalsIgnoreCase("Open") ? "status-open" : "status-closed";
%>
<h3><%=crossing.getName()%></h3>
<p>
Status: <strong><span class="status
<%=statusClass%>"><%=crossing.getStatus()%></span></strong>
</p>
<p>
Person in Charge:
<strong><%=crossing.getPersonInCharge()%></strong>
</p>
<p>
Train Schedules: <strong><%=crossing.getTrainSchedule()%></strong>
</p>
<p>
Landmark: <strong><%=crossing.getLandmark()%></strong>
</p>
<p>
Address: <strong><%=crossing.getAddress()%></strong>
</p>
<form action="AddToFavoritesServlet" method="post">
<input type="hidden" name="crossingId"
value="<%=crossing.getId()%>">
<button type="submit">ADD TO FAVORITES</button>
</form>
<%
}
%>
</body>
</html>