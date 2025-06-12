package com.batchone.web.onlineshopping;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.batchone.web.onlineshopping.cart.Cart;
import com.batchone.web.onlineshopping.cart.CartProduct;
import com.batchone.web.onlineshopping.cart.ShoppigCart;


@WebServlet("/addCart")
public class AddCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(); // Ensure session is created
            if (session == null) {
                response.sendRedirect("login.html");
                return;
            }

            Integer productId = Integer.parseInt(request.getParameter("productId")); 
            Integer categoryId = Integer.parseInt(request.getParameter("categoryId")); 
            Float price = Float.parseFloat(request.getParameter("price"));

            CartProduct prod = new CartProduct(categoryId, productId, price);

            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new ShoppigCart(); // Note: still has a typo if you care about naming
                session.setAttribute("cart", cart);
            }

            cart.addToCart(prod);
            System.out.println("Added to cart: " + prod);

            response.sendRedirect("listCart.jsp");

        } catch (Exception e) {
            e.printStackTrace(); // log to server, not client
            response.sendRedirect("login.html");
        }
    }
}
