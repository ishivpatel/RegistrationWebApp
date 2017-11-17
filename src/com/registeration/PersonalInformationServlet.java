package com.registeration;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registeration.beans.PersonalInformation;

import validators.PersonalInformationValidator;

/**
 * Servlet implementation class personalInformation Shiv Patel, v1.0 November
 * 1,2017
 * 
 */
public class PersonalInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public PersonalInformationServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get registration details
		String firstName = request.getParameter("fname");
		String middleName = request.getParameter("mname");
		String lastName = request.getParameter("lname");
		String gender = request.getParameter("gender");

		PersonalInformation pinfo = new PersonalInformation();
		pinfo.setFirstName(firstName);
		pinfo.setLastName(lastName);
		pinfo.setMiddleName(middleName);
		pinfo.setGender(gender);

		// Validation
		PersonalInformationValidator piv = new PersonalInformationValidator();
		String error = piv.validatePersonalInformation(pinfo);

		// db

		if (error.length() != 0) {
			request.setAttribute("errorMessages", error);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/index.jsp");
			rd.forward(request, response);
		} else {

		
		String url = "jdbc:mysql://localhost:3306/registrationapp";
		
		
		Connection myConn = null;
		PreparedStatement pStmt = null;
		int rowsInserted = 0;
		try {
			// 1. Get a connection to database
			Class.forName("com.mysql.jdbc.Driver");
			myConn = DriverManager.getConnection(url, "root", "12345");
			
			// 2. Create a statement
			pStmt = myConn.prepareStatement("INSERT INTO personalInformation  VALUES (?,?,?,?)");
			// 3. Execute SQL query
			pStmt.setString(1, pinfo.getFirstName());
			pStmt.setString(2,  pinfo.getMiddleName());
			pStmt.setString(3,  pinfo.getLastName());
			pStmt.setString(4,  pinfo.getGender());
			rowsInserted = pStmt.executeUpdate();

			if (rowsInserted != 1) {
				throw new Exception("Error in inserting the row");
	   		}
					
			
			System.out.println("Insert complete.");
			pStmt.close();
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}

			// Set Attributes
			HttpSession session = request.getSession();
			session.setAttribute("pinfo", pinfo);
			response.sendRedirect("jsp/contactInfo.jsp");
		}
	}

}
