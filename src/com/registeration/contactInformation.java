package com.registeration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class contactInformation 
 * Shiv Patel, v1.0 November 1, 2017
 * 
 */
public class contactInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public contactInformation() {
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

		// Print to console
		System.out.println("address:  " + address + "\n" + city + ", " + state + " " + zip);
		System.out.println(country);
		System.out.println("Ph: " + phone);

		// Set Attributes
		request.getSession().setAttribute("address", address);
		request.getSession().setAttribute("city", city);
		request.getSession().setAttribute("state", state);
		request.getSession().setAttribute("zip", zip);
		request.getSession().setAttribute("country", country);
		request.getSession().setAttribute("phone", phone);
		response.setContentType("text/html");

		// Redirect to next page
		response.sendRedirect("html/bankInformation.html");
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
