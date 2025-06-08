package com.one.oldMethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Myservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;  // This fixes the serialVersionUID warning
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>My Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello from MyServlet!</h1>");
        out.println("<p>This servlet is working perfectly!</p>");
        out.println("</body>");
        out.println("</html>");
    }
}