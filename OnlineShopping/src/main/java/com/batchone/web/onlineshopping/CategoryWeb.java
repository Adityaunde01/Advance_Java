package com.batchone.web.onlineshopping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import com.batchone.web.onlineshopping.dao.CategoryDAO;
import com.batchone.web.onlineshopping.dao.CategoryDAOImpl;

/**
 * Servlet implementation class CategoryWeb
 */
@WebServlet("/Category")
public class CategoryWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbConnection = null;
	PreparedStatement psCategory = null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		
		ServletContext application = config.getServletContext();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url = application.getInitParameter("db_url"); 
			String user = application.getInitParameter("user");
			String pass = application.getInitParameter("pass");
			dbConnection = DriverManager.getConnection(db_url,user,pass);
			psCategory = dbConnection.prepareStatement("Select * from categories");
			System.out.println("Db Connected succesfully");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Db connectoin failed" + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();
		 CategoryDAO dao = new CategoryDAOImpl();
		 Iterator<com.batchone.web.onlineshopping.dao.Category> allCategories = dao.getAllCategory(psCategory); 
		 
		 	out.println("<html><head><title>Category List</title></head><body>");
		    out.println("<h2>Category Table</h2>");
		    out.println("<table border='1' cellpadding='10'>");
		    out.println("<tr>");
		    out.println("<th>ID</th>");
		    out.println("<th>Name</th>");
		    out.println("<th>Description</th>");
		    out.println("<th>Image</th>");
		    out.println("</tr>");
		    
		    while (allCategories.hasNext()) {
		        com.batchone.web.onlineshopping.dao.Category cat = allCategories.next();
		        out.println("<tr>");
		        out.println("<td>" + cat.getCategoryId() + "</td>");
		        out.println("<td><a href='Products?catId="+cat.getCategoryId()+"'>" + cat.getCatagoryName() + "</a></td>");
		        out.println("<td>" + cat.getCategoryDesc() + "</td>");
		        out.println("<td><img src='" + cat.getCategoryImage() + "' alt='Image' width='100'/></td>");
		        out.println("</tr>");
		    }

		    out.println("</table>");
		    out.println("</body></html>");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		
		try {
			if(dbConnection != null)
				dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
