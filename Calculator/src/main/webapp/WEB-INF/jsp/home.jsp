<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
    function submitForm(action)
    {
        document.getElementById('form').action = action;
        document.getElementById('form').submit();
    }
</script>
<title>Insert title here</title>
</head>
<body>
<u><h1 align="center">Calculator</h1></u>
<form id="form"  name="form" method="post">
<table align="center">
<tr><td><label>First Number</label>
<td><input type="text" name="fno"/></td></tr>
<tr><td><label>Second Number</label>
<td><input type="text" name="sno"/></td></tr>
<tr><td><label>Result</label>
<td><input type="text" value="${res}" readonly="readonly"/></td></tr><tr>

<td><input type="submit" name="add"  onclick="submitForm('/add')" value="ADD"/></td>
<td><input type="submit" name="sub"  onclick="submitForm('/sub')" value="SUBTRACT"/></td></tr><tr>
<td><input type="submit" name="div" onclick="submitForm('/div')" value="DIVIDE"/></td>
<td><input type="submit" name="mul" onclick="submitForm('/mul')" value="MULTIPLY"/></td>
</tr>
</table>
</form>
</body>
</html>