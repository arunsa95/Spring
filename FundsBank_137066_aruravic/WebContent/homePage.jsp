<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Funds Bank Ltd</title>
</head>
<body bgcolor="bisque" align="center">
<h1 align="center"><u>Customer Complaint Request Form</u></h1>

<table align="center">
<form:form method="post"  action="homePage.obj" modelAttribute="homepage" >

<tr>
<td>Account ID:<span style="color:red">*</span></td>
<td><form:input path="accountId"/>
<form:errors path="accountId" style="color:red"/></td>
</tr>
<tr>
<td>Branch Code:<span style="color:red">*</span> </td>
<td><form:input path="branchCode"/>
<form:errors path="branchCode" style="color:red"></form:errors></td>
</tr>

<tr>
<td>Email Id: <span style="color:red">*</span> </td>
<td><form:input path="emailId"/>
<form:errors path="emailId" style="color:red"/></td>
</tr>

<tr>
<td>Complaint Category:<span style="color: red;">*</span></td>
<td><form:select value="" label="select"
	path="category">
	<form:option value="" path="category" >Select</form:option>
<form:option value="Internet Banking" path="category" />Internet Banking
<form:option value="General Banking" path="category" />General Banking
<form:option value="Others" path="category" />Others</form:select></td>
<td style="color: red;"><form:errors path="category"></form:errors></td>
</tr>

<tr>
<td>Description: <span style="color:red">*</span></td>
<td><form:textarea path="description"/>
<form:errors path="description" style="color:red"/></td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="Submit"/></td>
</tr>

</form:form>
<tr>
<td colspan="2" align="center">

<a  href="showRetrieveComplaintForm.obj">Check Status</a>
</td></tr>
</table>

</body>
</html>