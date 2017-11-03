<HTML>
<BODY>
<%
    // This is a scriptlet.  Notice that the "date"
    // variable we declare here is available in the
    // embedded expression later on.
    System.out.println( "Evaluating date now" );
    java.util.Date date = new java.util.Date();
    
    
%>
<font color="green"> Todays Date: </font><%= date %>

<h1> <font color="red"> Registration Complete </font> </h1>
<font color="blue">================ You entered following Values ==================</font>
<br>
<br>
<br>
<%
String varFirstName = (String) request.getSession().getAttribute("ofname");
String varLastName = (String) request.getSession().getAttribute("olname");
String varMiddleName = (String) request.getSession().getAttribute("omname");
String gender = (String) request.getSession().getAttribute("ogender");
String address = (String) request.getSession().getAttribute("address");
String city = (String) request.getSession().getAttribute("city");
String state = (String) request.getSession().getAttribute("state");
String zip = (String) request.getSession().getAttribute("zip");
String country = (String) request.getSession().getAttribute("country");
String phone = (String) request.getSession().getAttribute("phone");
String bankname = (String) request.getSession().getAttribute("bankname");
String accountnumber = (String) request.getSession().getAttribute("accountnumber");
String routingnumber = (String) request.getSession().getAttribute("routingnumber");
String ssn = (String) request.getSession().getAttribute("ssn");

%>
<%if (varFirstName != null){%>
	FitstName = <%=varFirstName%>
	<br>
<%}%>
<%if (varLastName != null){%>
	LastName = <%=varLastName%>
	<br>
<%}%>
<%if (varMiddleName != null){%>
	MiddleName = <%=varMiddleName%>
	<br>
<%}%>
<%if (gender != null){%>
	Gender = <%=gender%>
	<br>
<%}%>
<br>
<font color="blue">================ End of the Personal Information=============================</font>
<br>
<font color="blue">================  Contact Information  =============================</font>
<%if (address != null){%>
	Address = <%=address%>
	<br>
<%}%>
<%if (city != null){%>
	City = <%=city%>
	<br>
<%}%>
<%if (state != null){%>
	State = <%=state%>
	<br>
<%}%>
<%if (zip != null){%>
	Zip Code = <%=zip%>
	<br>
<%}%>
<%if (country != null){%>
	Country = <%=country%>
	<br>
<%}%>
<%if (phone != null){%>
	Phone Number = <%=phone%>
	<br>
<%}%>
<font color="blue">================ End of the Contact Information=============================</font>
<br>
<font color="blue">================  Bank Information  =============================</font>
<br>
<%if (bankname != null){%>
	Bank Name = <%=bankname%>
	<br>
<%}%>
<%if (accountnumber != null){%>
	Account Number = <%=accountnumber%>
	<br>
<%}%>
<%if (routingnumber != null){%>
	Routing Number = <%=routingnumber%>
	<br>
<%}%>
<%if (ssn != null){%>
	Social Security = <%=ssn%>
	<br>
<%}%>
<font color="blue">================ End of the Bank Information=============================</font>
<br>
<font color="blue">================ End of the display=============================</font>
</BODY>
</HTML>