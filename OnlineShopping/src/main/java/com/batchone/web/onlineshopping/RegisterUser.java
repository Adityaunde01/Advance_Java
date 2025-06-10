package com.batchone.web.onlineshopping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.batchone.web.onlineshopping.dao.User;
import com.batchone.web.onlineshopping.dao.UserDAOImpl;
import com.batchone.web.onlineshopping.dao.UserDao;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao userDao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		userDao = new UserDAOImpl(config.getServletContext());
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		userDao.close();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String userName  = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User registeduser = userDao.registerUser(userName, email, password);
			System.out.println(registeduser);
			if(registeduser == null) {
				response.getWriter().println("<font color='red'>Some error Occured</font>");
				return;
			}
			
			response.sendRedirect("login.html");
			
	}

}
