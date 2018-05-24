package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "password";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		
		// Adding comments for testing.
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connection to database : " + jdbcUrl);

			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
			
			out.println("Connection successful, ROEL CANTU");
			
			connection.close();
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

}
