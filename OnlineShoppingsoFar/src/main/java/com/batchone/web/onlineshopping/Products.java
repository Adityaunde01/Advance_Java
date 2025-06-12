package com.batchone.web.onlineshopping;

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
import java.sql.SQLException;
import java.util.Iterator;

import com.batchone.web.onlineshopping.dao.Product;
import com.batchone.web.onlineshopping.dao.ProductDAO;
import com.batchone.web.onlineshopping.dao.ProductDAOImpl;
import com.batchone.web.onlineshopping.dao.User;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
	
	Connection dbConnection = null;
	
	
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
		
			System.out.println("Db Connected succesfully");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Db connectoin failed" + e.getMessage());
		}
			
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

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession(false); //coming from client
		//if present then forword and if not  return null and redirect to login
		
		
		
		if( session == null ) {
			response.sendRedirect("login.html");
			return;
		}
		
		String custID = request.getParameter("catId");
		PrintWriter out = response.getWriter();
		ProductDAO dao = new ProductDAOImpl();
		Iterator<Product> products = dao.getProducts(custID,dbConnection);
		out.println("<html><head><title>Product List</title></head><body>");
	    out.println("<h2>Product Table</h2>");
	    out.println("<table border='1' cellpadding='10'>");
	    out.println("<tr>");
	    out.println("<th>ID</th>");
	    out.println("<th>Name</th>");
	    out.println("<th>Description</th>");
	    out.println("<th>Price</th>");
	    out.println("<th>Image</th>");
	    out.println("</tr>");
	    while (products.hasNext()) {
	        Product current = products.next();
	        out.println("<tr>");
	        out.println("<td>" + current.getPid() + "</td>");
	        out.println("<td>" + current.getName() + "</td>");
	        out.println("<td>" + current.getDesc() + "</td>");
	        out.println("<td>$" + current.getPrice() + "</td>");
	        out.println("<td><img src='" + current.getImgUrl() + "' alt='Product Image' width='100'/></td>");
	        out.println("</tr>");
	    }

	    out.println("</table>");
	    out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
