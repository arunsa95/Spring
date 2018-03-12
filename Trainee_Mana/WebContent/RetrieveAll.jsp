<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Trainee List</h1>

	<table border=1>
		<tr>
			<th bgcolor="bisque">Trainee Id</th>
			<th bgcolor="bisque">Trainee Name</th>
			<th bgcolor="bisque">Trainee Domain</th>
			<th bgcolor="bisque">Trainee Location</th>
			<th bgcolor="bisque">Trainee Date of Birth</th>

		</tr>
		<c:forEach var="traineeList" items="${list}">
			<tr>
				<td>${traineeList.traineeId}</td>
				<td>${traineeList.traineeName}</td>
				<td>${traineeList.traineeDomain}</td>
				<td>${traineeList.traineeLocation}</td>
				<td>${traineeList.traineeDob}</td>

			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center"><a href="showHomePage.obj">Click
					Here To Go to Home</a></td>
		</tr>
	</table>


</body>
</html>