<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Web App</title>
</head>
<body>
<%
String message = (String) request.getAttribute("errorMessages");
if(message != null && message.trim().length() != 0){
%>
<%=message %>

<%} %>
<form method="get" action="/RegistrationWebApp/BankInformationServlet">

		<h1>Bank Information</h1>
		<table>
			<tr>
				<td><label for="bankname">Bank Name</label></td>
				<td><input type="text" name="bankname" id="bankname"></td>
			</tr>
			<tr>
				<td><label for="accountnumber">Account Number</label></td>
				<td><input type="text" name="accountnumber" id="accountnumber"></td>
			</tr>
			<tr>
				<td><label for="routingnumber">Routing Number</label></td>
				<td><input type="text" name="routingnumber" id="routingnumber"></td>
			</tr>
			<tr>
				<td><label for="ssn">Social Security</label></td>
				<td><input type="text" name="ssn" id="ssn"></td>
			</tr>
			
		</table>

		<br> <br> <input type=submit name="submit" value="submit" />
	</form>
</body>
</html>