package com.batchone.web.onlineshopping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.batchone.web.onlineshopping.admin.AdminDAO;
import com.batchone.web.onlineshopping.admin.AdminDAOImpl;

/**
 * Servlet implementation class AddCategory
 */
@WebServlet("/addCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

AdminDAO adminDao = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		adminDao = new AdminDAOImpl(getServletContext());
	}



	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		adminDao.close();
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String name = request.getParameter("name");
		String desc = request.getParameter("description");
		String Image_url= request.getParameter("imageUrl");
		
		if(name == null || desc == null || Image_url == null ) {
			response.getWriter().println("<font color='red'>Enter all fields while adding <b>Category</b></font>");
			request.getRequestDispatcher("adminprivlage.html").include(request, response);
		}
		
		adminDao.addCategory( name, desc, Image_url);
		response.getWriter().println("<font color='green'>added <b>Category</b></font>");
		request.getRequestDispatcher("adminprivlage.html").include(request, response);
		
	}


}
