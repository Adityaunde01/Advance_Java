<%@page import="com.batchone.web.onlineshopping.cart.CartProduct"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.batchone.web.onlineshopping.cart.ShoppigCart"%>
<%@page import="com.batchone.web.onlineshopping.cart.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    
    <%
    if( session == null ) {
		response.sendRedirect("login.html");
		return;
	}
	
    Cart cart = (Cart)session.getAttribute("cart");

    if (cart == null) {
        response.sendRedirect("emptycart.jsp"); // Or show an error message
        return;
    }

    Iterator<CartProduct> products = cart.getFromCart();
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Cart</title>
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f8f9fa;
        }

        h2 {
            text-align: center;
            color: #343a40;
        }

        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px 16px;
            text-align: center;
            border: 1px solid #dee2e6;
        }

        th {
            background-color: #343a40;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f1f1f1;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        img {
            border-radius: 8px;
        }
    </style>
</head>
<body>
 <h2>Category Table</h2>
    <table>
        <tr>
            <th>ProductID</th>
            <th>CategoryId</th>
            <th>Price</th>
        </tr>
        <%
        	Float price = 0.0F;
            while (products.hasNext()) {
                CartProduct cat = (CartProduct)products.next();
        %>
        <tr>
            <td><%= cat.getProductId() %></td>
            <td><%= cat.getCategoryId() %></td>
            <td><%= cat.getPrice() %></td>  
        </tr>
        <%
           price += cat.getPrice();
            }
        %>
        <tr>
            <td>Total</td>
            <td><%=price %></td>  
        </tr>
    </table>
    
</body>
</html>