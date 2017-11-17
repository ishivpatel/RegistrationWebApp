package com.registeration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registeration.beans.ContactInformation;

import validators.ContactInformationValidator;

/**
 * Servlet implementation class contactInformation Shiv Patel, v1.0 November 1,
 * 2017
 * 
 */
public class ContactInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactInformationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get registration details
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");

		ContactInformation cinfo = new ContactInformation();
		cinfo.setAddress(address);
		cinfo.setCity(city);
		cinfo.setState(state);
		cinfo.setZip(zip);
		cinfo.setCountry(country);
		cinfo.setPhone(phone);

		// Validation
		ContactInformationValidator civ = new ContactInformationValidator();
		String error = civ.validateContactInformation(cinfo);

		if (error.length() != 0) {
			request.setAttribute("errorMessages", error);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/contactInfo.jsp");
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
				pStmt = myConn.prepareStatement("INSERT INTO contactInformation  VALUES (?,?,?,?,?,?)");
				// 3. Execute SQL query
				pStmt.setString(1, cinfo.getAddress());
				pStmt.setString(2,  cinfo.getCity());
				pStmt.setString(3,  cinfo.getState());
				pStmt.setString(4,  cinfo.getZip());
				pStmt.setString(5,  cinfo.getCountry());
				pStmt.setString(6,  cinfo.getPhone());
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
			session.setAttribute("cinfo", cinfo);
			response.sendRedirect("jsp/bankInformation.jsp");
		}
	}
}
