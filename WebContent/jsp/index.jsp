<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="/css/registrationTheme.css"> -->
<title>Registration Web App</title>
</head>

<body>
<%
String message = (String) request.getAttribute("errorMessages");
if(message != null && message.trim().length() != 0){
%>
<%=message %>

<%} %>	
	<form method="get"
		action="/RegistrationWebApp/PersonalInformationServlet">

		<h1>Please Register to access the System</h1>
		<table>
			<tr>
				<td><label for="fname">First Name</label></td>
				<td><input type="text" name="fname" id="fname"></td>
			</tr>
			<tr>
				<td><label for="lname">Last Name</label></td>
				<td><input type="text" name="lname" id="lname"></td>
			</tr>
			<tr>
				<td><label for="mname">Middle Name</label></td>
				<td><input type="text" name="mname" id="mname"></td>
			</tr>

			<tr>
				<td><label for="gender"> Gender </label></td>
				<td><input type="radio" name="gender" value="Male">
					Male <input type="radio" name="gender" value="Female">
					Female</td>
			</tr>
		</table>

		<br> <br> <input type=submit name="submit" value="submit" />
	</form>

</body>
</body>
</html>