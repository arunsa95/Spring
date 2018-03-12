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
	<h3>Modify Trainee Operations</h3>

	<form:form action="ModifyTrainee.obj" method="post"
		modelAttribute="trainee">
		<table>

			<tr>
				<td>Please Enter Trainee Id<span style="color: red;">*</span></td>
				<td><form:input path="traineeId" /></td>
				<td style="color: red;"><form:errors path="traineeId"></form:errors></td>

				<td colspan="2"><input type="submit" name="submit"
					value="modify"></input></td>
			</tr>


		</table>

	</form:form>
	<c:if test="${isFirst==false}">
		<form:form action="oModifyTrainee.obj" method="post"
			modelAttribute="bean">
			<center>
				<u><h2>Trainee Information</h2></u>
			</center>

			<table border="1" align="center">
				<tr>
					<th bgcolor="bisque">Trainee Id</th>

					<td>${bean.traineeId}</td>
				</tr>

				<tr>
					<td>Trainee Name<span style="color: red;">*</span></td>
					<td><form:input path="traineeName"
							value="${bean.traineeName }" /> <form:errors style="color: red;"
							path="traineeName"></form:errors></td>

				</tr>


				<tr>
					<td>Trainee Location<span style="color: red;">*</span></td>
					<td><form:input path="traineeLocation"
							value="${bean.traineeLocation }" /> <form:errors
							style="color: red;" path="traineeLocation"></form:errors></td>

				</tr>

				<tr>
					<td>Trainee Date Of Birth<span style="color: red;">*</span></td>
					<td><form:input path="traineeDob" value="${bean.traineeDob }" />
						<form:errors style="color: red;" path="traineeDob"></form:errors></td>

				</tr>

				<tr>
					<td>Trainee Domain<span style="color: red;">*</span></td>
					<td><form:input path="traineeDomain"
							value="${bean.traineeDomain }" /> <form:errors
							style="color: red;" path="traineeDomain"></form:errors></td>


				</tr>



				<tr>

					<form:hidden path="traineeId" value="${bean.traineeId }" />
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Update"></input></td>
				</tr>

			</table>


		</form:form>
	</c:if>
	<tr>
		<td><a href="showHomePage.obj">Click Here To Go to Home</a></td>
	</tr>
</body>
</html>