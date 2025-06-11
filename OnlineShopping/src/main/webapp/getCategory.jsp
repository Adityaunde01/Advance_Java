<%@page import="com.batchone.web.onlineshopping.dao.Category"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.batchone.web.onlineshopping.dao.CategoryDAOImpl"%>
<%@page import="com.batchone.web.onlineshopping.dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    HttpSession sess = request.getSession(false);
    if(sess == null || session.getAttribute("userObj") == null){
        response.sendRedirect("login.html");
        return;
    }

    ServletContext context = getServletContext();
    CategoryDAO catDao = new CategoryDAOImpl(context);
    Iterator<Category> allCategories = catDao.getAllCategory();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category List</title>
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
            
        </tr>
        <%
            while (allCategories.hasNext()) {
                Category cat = allCategories.next();
        %>
        <tr>
            <td><%= cat.getCategoryId() %></td>
            <td><a href="getProduct.jsp?catId=<%= cat.getCategoryId() %>"><%= cat.getCatagoryName() %></a></td>
            <td><%= cat.getCategoryDesc() %></td>
            <td><img src="<%= cat.getCategoryImage() %>" alt="Image" width="100" /></td>
        </tr>
        <%
            }
            catDao.close();
        %>
    </table>

</body>
</html>
