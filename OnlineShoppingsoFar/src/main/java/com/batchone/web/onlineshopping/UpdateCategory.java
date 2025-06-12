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
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/updateCategory")
public class UpdateCategory extends HttpServlet {
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
	    String catIdStr = request.getParameter("catId");
	    String name = request.getParameter("cname");
	    String desc = request.getParameter("cdescription");
	    String imageUrl = request.getParameter("cimageUrl");

	    // Null or empty checks
	    if (catIdStr == null || catIdStr.trim().isEmpty() ||
	        name == null || name.trim().isEmpty() ||
	        desc == null || desc.trim().isEmpty() ||
	        imageUrl == null || imageUrl.trim().isEmpty()) {

	        response.getWriter().println("<font color='red'>Enter all fields while updating <b>Category</b></font>");
	        request.getRequestDispatcher("adminprivlage.html").include(request, response);
	        return; // Don't proceed
	    }

	    Integer categoryId = Integer.parseInt(catIdStr); // Now safe to parse

	    adminDao.updateCategory(categoryId, name, desc, imageUrl);
	    response.getWriter().println("<font color='green'>Updated <b>Category</b></font>");
	    request.getRequestDispatcher("adminprivlage.html").include(request, response);
	}

}
