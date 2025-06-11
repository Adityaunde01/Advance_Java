<%@page import="com.batchone.web.onlineshopping.dao.Product"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.batchone.web.onlineshopping.dao.ProductDAOImpl"%>
<%@page import="com.batchone.web.onlineshopping.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ServletContext appli = config.getServletContext();
	 ProductDAO  productDao = new ProductDAOImpl(appli);	
    
    HttpSession sess = request.getSession(false); //coming from client
	//if present then forword and if not  return null and redirect to login
	if( session == null ) {
		response.sendRedirect("login.html");
		return;
	}
	
	String custID = request.getParameter("catId");
	Iterator<Product> products = productDao.getProducts(custID);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
            <th>Cart</th>
        </tr>
        <%
            while (products.hasNext()) {
                Product cat = products.next();
        %>
        <tr>
            <td><%= cat.getPid() %></td>
            <td><%= cat.getName() %></td>
            <td><%= cat.getDesc() %></td>
            <td><img src="<%= cat.getImgUrl() %>" alt="Image" width="100" /></td>
            
            <td><a href="cart?">add To cart</a></td>
        </tr>
        <%
            }
            productDao.close();
        %>
    </table>

	
	
</body>
</html>