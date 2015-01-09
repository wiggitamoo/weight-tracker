<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goal Report</title>
</head>
<body>
	<table>
	<tr>
		<th>Minutes</th><th>Exercise Minutes</th><th>Activity</th>
	</tr>
	<c:forEach items="${goalReports}" var="goalReport">
		<tr>
			<td>${goalReport.goalMinutes}</td>
			<td>${goalReport.exerciseMinutes}</td>
			<td>${goalReport.exerciseActivity}</td> 
		</tr>
	</c:forEach>
	</table>
</body>
</html>