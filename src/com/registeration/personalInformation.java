package com.registeration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class personalInformation 
 * Shiv Patel, v1.0 November 1,2017
 * 
 */
public class personalInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public personalInformation() {
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

		// Print to console
		System.out.println("First Name is " + firstName);
		System.out.println("Last Name is " + lastName);
		System.out.println("Gender is " + gender);

		// Set Attributes
		request.getSession().setAttribute("ofname", firstName);
		request.getSession().setAttribute("omname", middleName);
		request.getSession().setAttribute("olname", lastName);
		request.getSession().setAttribute("ogender", gender);
		response.setContentType("text/html");

		// Redirect to next page
		response.sendRedirect("html/contactInfo.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
