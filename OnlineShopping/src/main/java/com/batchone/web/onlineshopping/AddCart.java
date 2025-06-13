package com.batchone.web.onlineshopping;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.batchone.web.onlineshopping.cart.Cart;
import com.batchone.web.onlineshopping.cart.CartProduct;
import com.batchone.web.onlineshopping.cart.ShoppigCart;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/addCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false);
			if(session == null) {
				response.sendRedirect("login.html");
			}
			Integer produtId =  Integer.parseInt(request.getParameter("productId")); 
			Integer customerId =  Integer.parseInt(request.getParameter("categoryId")); 
			Float price =  Float.parseFloat(request.getParameter("price"));
			CartProduct prod = new CartProduct(customerId, produtId, price);
			 Cart cart = (Cart)session.getAttribute("cart");
			 if(cart == null) {
				 cart = new ShoppigCart();
			 }
			 cart.addToCart(prod);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Exception Occured" + e.getMessage());
			response.sendRedirect("login.html");
		}
	}

}
