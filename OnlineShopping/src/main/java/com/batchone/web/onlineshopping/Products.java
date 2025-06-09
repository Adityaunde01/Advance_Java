package com.batchone.web.onlineshopping;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import com.batchone.web.onlineshopping.dao.Product;
import com.batchone.web.onlineshopping.dao.ProductDAO;
import com.batchone.web.onlineshopping.dao.ProductDAOImpl;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
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
		// TODO Auto-generated method stub
		String custID = request.getParameter("catId");
		PrintWriter out = response.getWriter();
		ProductDAO dao = new ProductDAOImpl();
		Iterator<Product> products = dao.getProducts(custID);
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
