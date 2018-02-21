<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Funds Bank Ltd</title>
</head>
<body bgcolor="bisque" align="center">
	<h3 align="center">
		<u>Check Status</u>
	</h3>

	<form:form action="RetrieveComplaint.obj" method="post"
		modelAttribute="showstatus">
		<table align="center">

			<tr>
				<td>Complaint Id:<span style="color: red;">*</span></td>
				<td><form:input path="complaintId" /></td>
				<td style="color: red;"><form:errors path="complaintId"></form:errors></td>

			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" name="submit"
					value="Check Status"></input></td>
			</tr>
			

		</table>

	</form:form>

	<c:if test="${isFirst!=true}">

		<table bgcolor="skyblue" border="1" align="center">
			<tr>
				<th bgcolor="bisque">Complaint Id</th>
				<th bgcolor="bisque">Description</th>
				<th bgcolor="bisque">Status</th>
			</tr>
			<tr>
				<td><c:out value="${tBean.complaintId}" /></td>
				<td><c:out value="${tBean.description}" /></td>
				<td><c:out value="${tBean.status}" /></td>
			</tr>
			
		</table>

	</c:if>
	<table align="center" >
	<tr>
				<td align="center"><a href="homePageForm.obj">Raise
						Complaint</a></td>
			</tr></table>

</body>
</html>