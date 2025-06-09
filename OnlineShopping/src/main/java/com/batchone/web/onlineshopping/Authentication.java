package com.batchone.web.onlineshopping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/auth")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection dbConnection = null;
	private PreparedStatement psAuth = null;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/onlineshop"; 
			String user = "root";
			String pass = "my-secret-pw";
			dbConnection = DriverManager.getConnection(db_url,user,pass);
			psAuth = dbConnection.prepareStatement("Select * from users where name=? and password=?");
			System.out.println("Db Connected succesfully");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Db connectoin failed");
			throw new ServletException("Connection failed", e);
		}
		
	}
	
	
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		try {
			if(psAuth != null)
				psAuth.close();
			if(dbConnection != null)
				dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("Invalid Usernam and pasword");
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
			
			String userName = request.getParameter("username");

			String password = request.getParameter("password");
			
			System.out.println(userName+ " " +password);
			ResultSet result = null;
			try {
				psAuth.setString(1, userName);
				psAuth.setString(2, password);
				result = psAuth.executeQuery();
				//result.next();
				
				if(result.next()) {
					System.out.println(result.getString(2));
					HttpSession session = request.getSession();
					session.setAttribute("username", userName);
					response.sendRedirect("Category");
				}else {
					doGet(request, response);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(result != null) {
						result.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			
	}

	

}
