<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="com.RailwayCrossing"%>
<%@ page import="com.RailwayCrossingDAO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Railway Crossings - Search Crossings</title>
<script>
function searchCrossings() {
var input = document.getElementById("searchInput");
var filter = input.value.toUpperCase();
var crossings = document.getElementsByClassName("crossing");
for (var i = 0; i < crossings.length; i++) {
var crossing = crossings[i];
var name = crossing.getElementsByTagName("h3")[0].innerText;
if (name.toUpperCase().indexOf(filter) > -1) {
crossing.style.display = "";
} else {
crossing.style.display = "none";
}
}
}
</script>
</head>
<body>
<h2>Search Crossings</h2>
<!-- Display All button -->
<button onclick="location.href='userHome.jsp'"
class="allCrossing-button"
style="border-radius: 10px; font-weight: bold;">All Crossings</button>
<!-- Display Favorite Crossings button -->
<button onclick="location.href='userHomeFavoriteCrossing.jsp'"
class="favouriteCrossing-button"
style="border-radius: 10px; font-weight: bold;">Favorite
Crossings</button>
<!-- Search input -->
<input type="text" id="searchInput" placeholder="Search by name"
onkeyup="searchCrossings()">
<!-- Logout button -->
<button onclick="location.href='userLogin.jsp'">Logout</button>
<!-- Search Results Container -->
<%
RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
List<RailwayCrossing> allCrossings = crossingDAO.getAllCrossings();
for (RailwayCrossing crossing : allCrossings) {
String status = crossing.getStatus();
String statusClass = status.equalsIgnoreCase("Open") ? "status-open" :
"status-closed";
%>
<h3><%=crossing.getName()%></h3>
<p>
Status: <b><span class="status
<%=statusClass%>"><%=crossing.getStatus()%></span></b>
</p>
<p>
Person in Charge: <b><%=crossing.getPersonInCharge()%></b>
</p>
<p>
Train Schedules: <b><%=crossing.getTrainSchedule()%></b>
</p>
<p>
Landmark: <b><%=crossing.getLandmark()%></b>
</p>
<p>
Address: <b><%=crossing.getAddress()%></b>
</p>
<form action="addToFavorites" method="post" style="display: inline;">
<input type="hidden" name="crossingId"
value="<%=crossing.getId()%>">
<button type="submit"
style="border-radius: 10px; font-weight: bold; margin-top:
10px; margin-left: 0px;">ADD
TO FAVORITES</button>
</form>
<%
}
%>
</body>
</html>