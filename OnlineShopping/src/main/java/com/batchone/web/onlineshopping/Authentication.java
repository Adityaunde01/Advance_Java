package com.batchone.web.onlineshopping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
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

import com.batchone.web.onlineshopping.dao.User;
import com.batchone.web.onlineshopping.dao.UserDAOImpl;
import com.batchone.web.onlineshopping.dao.UserDao;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/auth")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = null;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		 userDao = new UserDAOImpl(getServletContext());
		
	}
	
	
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		userDao.close();
	}
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		
//		out.println("Invalid Usernam and pasword");
//	}
//	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String userName = request.getParameter("username");

			String password = request.getParameter("password");
			
			User user = userDao.getUser(userName, password);
					
			
			
			if(user == null ) {
				response.getWriter().println("<font color='red'>Invalid User</font");
				RequestDispatcher dispatch = request.getRequestDispatcher("login.html");
				dispatch.include(request, response);
				return;
			}
			HttpSession session = request.getSession(true);
			session.setAttribute("userObj", user);
			response.sendRedirect("Category");		
	}
}
