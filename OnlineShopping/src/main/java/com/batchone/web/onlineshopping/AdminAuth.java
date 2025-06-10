package com.batchone.web.onlineshopping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.batchone.web.onlineshopping.admin.Admin;
import com.batchone.web.onlineshopping.admin.AdminDAO;
import com.batchone.web.onlineshopping.admin.AdminDAOImpl;

/**
 * Servlet implementation class AdminAuth
 */
@WebServlet("/adminauth")
public class AdminAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminDAO adminDao = null;
 
    public AdminAuth() {
        super();

    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		adminDao = new AdminDAOImpl(getServletContext());
	}

	@Override
	public void destroy() {
		super.destroy();
		adminDao.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = adminDao.getAdmin(username, password);
		
		if(admin == null) {
			response.getWriter().println("<font color='red'>Invald Credentials</font>");
			request.getRequestDispatcher("adminlogin.html").include(request, response);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute(admin.getCode(), admin);
		response.sendRedirect("adminprivlage.html");
		
	}

}
