<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<h3>Retrieve Operations</h3>

	<form:form action="RetrieveTrainee.obj" method="post"
		modelAttribute="retrieve">
		<table>

			<tr>
				<td>Please Enter Trainee Id<span style="color: red;">*</span></td>
				<td><form:input path="traineeId" /></td>
				<td style="color: red;"><form:errors path="traineeId"></form:errors></td>
				<td colspan="2"><input type="submit" name="submit"
					value="retrieve"></input></td>
			</tr>



		</table>

	</form:form>


	<c:if test="${isFirst!=true}">

		<u><h2>Trainee Information</h2></u>

		<table bgcolor="skyblue" border="1" align="center">
			<tr>
				<th bgcolor="bisque">Trainee Id</th>
				<th bgcolor="bisque">Trainee Name</th>
				<th bgcolor="bisque">Trainee Domain</th>
				<th bgcolor="bisque">Trainee Location</th>
				<th bgcolor="bisque">Trainee DOB</th>

			</tr>
			<tr>
				<td><c:out value="${tBean.traineeId}" /></td>
				<td><c:out value="${tBean.traineeName}" /></td>
				<td><c:out value="${tBean.traineeDomain}" /></td>
				<td><c:out value="${tBean.traineeLocation}" /></td>
				<td><c:out value="${tBean.traineeDob}" /></td>

			</tr>

		</table>

	</c:if>

	<tr>
		<td><a href="showHomePage.obj">Click Here To Go to Home</a></td>
	</tr>
</body>
</html>
