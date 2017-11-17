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
<form method="get" action="/RegistrationWebApp/ContactInformationServlet">

		<h1>Contact Information</h1>
		<table>
			<tr>
				<td><label for="address">House Number and Street</label></td>
				<td><input type="text" name="address" id="address"></td>
			</tr>
			<tr>
				<td><label for="city">City</label></td>
				<td><input type="text" name="city" id="city"></td>
			</tr>
			<tr>
				<td><label for="state">State</label></td>
				<td><input type="text" name="state" id="state"></td>
			</tr>
			<tr>
				<td><label for="zip">Zip Code</label></td>
				<td><input type="text" name="zip" id="zip"></td>
			</tr>
			<tr>
				<td><label for="country">Country</label></td>
				<td><input type="text" name="country" id="country"></td>
			</tr>
			
			<tr>
				<td><label for="phone">Phone Number</label></td>
				<td><input type="text" name="phone" id="phone"></td>
			</tr>
			
			
			
		</table>

		<br> <br> <input type=submit name="submit" value="submit" />
	</form>
</body>
</html>