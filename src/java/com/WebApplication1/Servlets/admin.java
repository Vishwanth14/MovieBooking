package com.WebApplication1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if((session.getAttribute("una") == null) && (session.getAttribute("passw") == null))
        {
            response.sendRedirect("ad.jsp");
        }
        else{
            out.println("<button><a href=\"table1\">User Table</button>");
            out.println("<br>");
            out.println("<br>");
            out.println("<button><a href=\"table2\">User Session</button>");
            out.println("<br>");
            out.println("<br>");
            out.println("<button><a href=\"table3\">Movies</button>");
            out.println("<br>");
            out.println("<br>");
            out.println("<button><a href=\"table4\">History</button>");
            out.println("<br>");
            out.println("<br>");
            out.println("<button><a href=\"logout\">Logout</button>");
            out.println("<br>");
            out.println("<br>");
            out.println("<button><a href=\"add image.jsp\">Photo uploading</button>");
            out.println("<br>");
            out.println("<br>");
            out.println("<button><a href=\"insertion\">Insert</button>");
        }
    }
}
