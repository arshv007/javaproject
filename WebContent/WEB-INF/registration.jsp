<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

<h1>Registration Form</h1>

<form action="EmployeeController" method="post">
<input type="hidden" name="command" value="ADD">

<%
    String msg = (String)request.getAttribute("msg");
if(msg != null) {
	%>
	<h3 style="color: red;"> <%= msg %></h3>
	
  <%}
%>

<table>
<tr>
<td> Employee ID: </td> <td> <input type="text" name="employeeId"> </td>
</tr>
<tr>
<td> Password : </td><td> <input type="password" name="password"> </td>
</tr>
<tr>
<td> Employee Name : </td><td> <input type="text" name="employeeName"> </td>
</tr>
<tr>
<td> City : </td><td> <input type="text" name="city"></td>
</tr>
<tr>
<td> Phone Number : </td><td> <input type="number" name="phoneNumber"> </td>
</tr>
<tr>
<td colspan="2"> </td><td> <input type="submit" name="Submit"> </td>
</tr>
</table>

</body>
</html>