package com.batch1.web.onlineShopping;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/auth")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String DB_URI = "jdbc:mysql://localhost:3306/onlineshopping";
		final String userName = "root";
		final String passWord = "my-secret-pw";
		
		try(Connection dbConnection = DriverManager.getConnection(DB_URI,userName,passWord);
				PreparedStatement psget = dbConnection.prepareStatement("select * from users where username=? and password=?")){
			
			PrintWriter out = response.getWriter();
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			psget.setString(1, username);
			psget.setString(2, password);
			
			ResultSet result = psget.executeQuery();
			
			if(result.next()) {
				out.println("user Authenticated succesfully");
			}else {
				out.println("<h1 style=\"color:red;text-align:center;\">Invald user</h1>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
