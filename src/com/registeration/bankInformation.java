package com.registeration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bankInformation 
 * Shiv Patel, v1.0 November 1,2017
 * 
 */
public class bankInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public bankInformation() {
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
		String bankname = request.getParameter("bankname");
		String accountnumber = request.getParameter("accountnumber");
		String routingnumber = request.getParameter("routingnumber");
		String ssn = request.getParameter("ssn");

		// Print to console
		System.out.println("Bank Name:  " + bankname);
		System.out.println("Account Number:  " + accountnumber + "\n" + "Routing Number: " + routingnumber);
		System.out.println("Social Security: " + ssn);

		// Set Attributes
		request.getSession().setAttribute("bankname", bankname);
		request.getSession().setAttribute("accountnumber", accountnumber);
		request.getSession().setAttribute("routingnumber", routingnumber);
		request.getSession().setAttribute("ssn", ssn);
		response.setContentType("text/html");

		// Redirect to next Page
		response.sendRedirect("jsp/output.jsp");
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
