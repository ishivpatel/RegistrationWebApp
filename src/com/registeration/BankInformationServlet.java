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
import com.registeration.beans.BankInformation;
import validators.BankInformationValidator;

/**
 * Servlet implementation class bankInformation 
 * Shiv Patel, v1.0 November 1,2017
 * 
 */
public class BankInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankInformationServlet() {
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

		BankInformation binfo = new BankInformation();
		binfo.setBankname(bankname);
		binfo.setAccountnumber(accountnumber);
		binfo.setRoutingnumber(routingnumber);
		binfo.setSsn(ssn);
		
		// Validation
		BankInformationValidator biv = new BankInformationValidator();
		String error = biv.validateBankInformation(binfo);
		
		if(error.length() !=0) {
			request.setAttribute("errorMessages", error);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/bankInformation.jsp");
			rd.forward(request, response);
		}
		else {
			

			String url = "jdbc:mysql://localhost:3306/registrationapp";
			
			
			Connection myConn = null;
			PreparedStatement pStmt = null;
			int rowsInserted = 0;
			try {
				// 1. Get a connection to database
				Class.forName("com.mysql.jdbc.Driver");
				myConn = DriverManager.getConnection(url, "root", "12345");
				
				// 2. Create a statement
				pStmt = myConn.prepareStatement("INSERT INTO bankInformation  VALUES (?,?,?,?)");
				// 3. Execute SQL query
				pStmt.setString(1, binfo.getBankname());
				pStmt.setString(2,  binfo.getAccountnumber());
				pStmt.setString(3,  binfo.getRoutingnumber());
				pStmt.setString(4,  binfo.getSsn());
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
			session.setAttribute("binfo", binfo);
			response.sendRedirect("jsp/output.jsp");
		}	
	}
}
