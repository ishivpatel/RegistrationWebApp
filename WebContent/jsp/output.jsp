<HTML>
<BODY>
<%
    // This is a scriptlet.  Notice that the "date"
    // variable we declare here is available in the
    // embedded expression later on.
    System.out.println( "Evaluating date now" );
    java.util.Date date = new java.util.Date();   
%>

<jsp:useBean id="pinfo" class="com.registeration.beans.PersonalInformation" scope="session"/>
<jsp:useBean id="cinfo" class="com.registeration.beans.ContactInformation" scope="session"/>
<jsp:useBean id="binfo" class="com.registeration.beans.BankInformation" scope="session"/>

<font color="green"> Todays Date: </font><%= date %>

<h1> <font color="red"> Registration Complete </font> </h1>
<font color="blue">================ You entered following Values ==================</font>
<br>
<br>
<br>
<font color="black">First Name :</font>
<jsp:getProperty property="firstName" name="pinfo"/>
<br>
<font color="black">Middle Name :</font>
<jsp:getProperty property="middleName" name="pinfo"/>
<br>
<font color="black">Last Name :</font>
<jsp:getProperty property="lastName" name="pinfo"/>
<br>
<font color="blue">================ Contact Information =============================</font>
<br>
<font color="black">Address :</font>
<jsp:getProperty property="address" name="cinfo"/>
<br>
<font color="black">City :</font>
<jsp:getProperty property="city" name="cinfo"/>
<br>
<font color="black">State :</font>
<jsp:getProperty property="state" name="cinfo"/>
<br>
<font color="black">Zip :</font>
<jsp:getProperty property="zip" name="cinfo"/>
<br>
<font color="black">Country :</font>
<jsp:getProperty property="country" name="cinfo"/>
<br>
<font color="black">Phone :</font>
<jsp:getProperty property="phone" name="cinfo"/>
<br>
<font color="blue">================ Bank Information =============================</font>
<br>
<font color="black">Bank Name :</font>
<jsp:getProperty property="bankname" name="binfo"/>
<br>
<font color="black">Account Number :</font>
<jsp:getProperty property="accountnumber" name="binfo"/>
<br>
<font color="black">Routing Number :</font>
<jsp:getProperty property="routingnumber" name="binfo"/>
<br>
<font color="black">SSN :</font>
<jsp:getProperty property="ssn" name="binfo"/>
<br>
<font color="blue">================ End of the display=============================</font>
</BODY>
</HTML>