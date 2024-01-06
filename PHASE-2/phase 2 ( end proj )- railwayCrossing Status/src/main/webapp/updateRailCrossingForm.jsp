<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Railway Crossing</title>
</head>
<body>
<h2 style="text-align:center">Railway Crossings</h2>
<h4 style="text-align:center">Update Railway Crossing Information</h4>
<form action="updateCrossing" method="post" style="text-align:center">
<label for="crossingId">Crossing ID : </label>
<input type="text" id="crossingId" name="crossingId"
value="${crossing.crossingId}"required><br>
<label for="name">Enter Name : </label>
<input type="text" id="name" name="name" value="${crossing.name}"
required><br>
<label for="address">Address : </label>
<input type="text" id="address" name="address"
value="${crossing.address}" required><br>
<label for="landmark">Landmark : </label>
<input type="text" id="landmark" name="landmark"
value="${crossing.landmark}" required><br>
<label for="trainSchedules">Train Schedules : </label>
<input type="text" id="trainSchedules" name="trainSchedules"
value="${crossing.trainSchedule}" required><br>
<label for="personInCharge">Person in Charge : </label>
<input type="text" id="personInCharge" name="personInCharge"
value="${crossing.personInCharge}" required><br>
<label for="status">Crossing Status : </label>
<select id="status" name="status">
<option value="Open" ${crossing.status == 'Open' ? 'selected' :
''}>Open</option>
<option value="Closed" ${crossing.status == 'Closed' ? 'selected' :
''}>Closed</option>
</select><br>
<button type="submit">Submit</button>
</form>
</body>
</html>