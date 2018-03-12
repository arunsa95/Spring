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
<body>
	<h3>Delete Operations</h3>

	<form:form action="DelTrainee.obj" method="post"
		modelAttribute="trainee">
		<table>

			<tr>
				<td>Please Enter Trainee Id<span style="color: red;">*</span></td>
				<td><form:input path="traineeId" /></td>
				<td style="color: red;"><form:errors path="traineeId"></form:errors></td>




				<td colspan="2"><input type="submit" name="submit"
					value="Delete"></input></td>
			</tr>

		</table>

	</form:form>

	<c:if test="${isFirst==false}">
		<form:form action="oDeleteTrainee.obj" method="post"
			modelAttribute="bean">
			<center>
				<h2><u>Trainee Information</u></h2>
			</center>

			<table border="1" align="center">
				<tr>
					<th bgcolor="bisque">Trainee Id</th>
					<th bgcolor="bisque">Trainee Name</th>
					<th bgcolor="bisque">Trainee Domain</th>
					<th bgcolor="bisque">Trainee Location</th>
					<th bgcolor="bisque">Trainee DOB</th>

				</tr>
				<tr>
					<td>${bean.traineeId}</td>
					<td>${bean.traineeName}</td>
					<td>${bean.traineeDomain}</td>
					<td>${bean.traineeLocation}</td>
					<td>${bean.traineeDob}</td>

				</tr>
				<tr>

					<form:hidden path="traineeId" value="${bean.traineeId }" />
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Delete"></input></td>
				</tr>

			</table>


		</form:form>
	</c:if>

	<tr>
		<td><a href="showHomePage.obj">Click Here To Go to Home</a></td>
	</tr>
</body>
</html>