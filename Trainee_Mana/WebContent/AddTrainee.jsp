<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainee Management System</title>
</head>
<body>
	<h3>Enter Trainee Details</h3>

	<form:form action="AddTrainee.obj" method="post" modelAttribute="add">
		<table>

			<tr>
				<td>Trainee Id<span style="color: red;">*</span></td>
				<td><form:input path="traineeId" /></td>
				<td style="color: red;"><form:errors path="traineeId"></form:errors></td>

			</tr>
			<tr>
				<td>Trainee Name<span style="color: red;">*</span></td>
				<td><form:input path="traineeName" /></td>
				<td style="color: red;"><form:errors path="traineeName"></form:errors></td>

			</tr>

			<%-- <tr>
				<td>Trainee Location<span style="color: red;">*</span></td>
				<td><c:forEach var="locationList" items="${locationList }">
					<form:radiobutton value="${locationList.options}"
						label="${ locationList.options}" path="traineeLocation" />
				</c:forEach></td>
			</tr> --%>

			<tr>
				<td>Trainee Date Of Birth<span style="color: red;">*</span></td>
				<td><form:input path="traineeDob" placeholder="MM/dd/yyyy"  /></td>
				<td style="color: red;"><form:errors path="traineeDob"></form:errors></td>

			</tr>
			

			<%-- <tr>
					<td>Trainee Location<span style="color: red;">*</span></td>
					<td><form:checkbox value="Chennai" path="traineeLocation" />Chennai
					<form:checkbox value="Banglore" path="traineeLocation" />Banglore
					<form:checkbox value="Pune" path="traineeLocation" />Pune
					<form:checkbox value="Mumbai" path="traineeLocation" />Mumbai</td>
					<td style="color: red;"><form:errors path="traineeLocation"></form:errors></td>

				</tr> --%>








			<tr>
				<td>Trainee Domain<span style="color: red;">*</span></td>
				<td><form:select value="" label="Select" path="traineeDomain" >
						<form:option value="" path="traineeDomain" >Select</form:option>
						<form:option value="Java" path="traineeDomain" />Java
					<form:option value="Oracle" path="traineeDomain" />Oracle
					<form:option value="Testing" path="traineeDomain" />Testing</form:select></td>
				<td style="color: red;"><form:errors path="traineeDomain"></form:errors></td>

			</tr>


			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Add Trainee"></input></td>
			</tr>
		</table>
		<tr>
			<td><a href="showHomePage.obj">Click Here To Go to Home</a></td>
		</tr>
	</form:form>
</body>
</html>