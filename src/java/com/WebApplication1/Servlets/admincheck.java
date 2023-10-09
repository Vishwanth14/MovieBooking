package com.WebApplication1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "admincheck", urlPatterns = {"/admincheck"})
public class admincheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String v = request.getParameter("una");
        String pw = request.getParameter("passw");
        try
            {
                HttpSession session = request.getSession();
                session.setAttribute("una", v);
                session.setAttribute("passw", pw);
                if((session.getAttribute("una") == null) && (session.getAttribute("passw") == null))
                {
                    response.sendRedirect("ad.jsp");
                }
                else{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from admin");
                    int c = 0;
                    int d = 0;
                    while(rs.next())
                    {
                        if(v.equals(rs.getString(1)))
                        {
                            c = 1;
                            if(pw.equals(rs.getString(2)))
                            {
                                d = 1;
                            }
                        }
                    }
                    if((c == 1) && (d == 1))
                    {
                        response.sendRedirect("admin");
                    }
                    else if((c == 0) || (d ==0))
                    {
                        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                        out.println("<script>");
                        out.println("$(document).ready(function(){");
                        out.println("swal ( 'you aren't admin please login as user , '', 'error' );");
                        out.println("});");
                        out.println("</script>");
                        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                        rd.include(request, response);
                    }
                }
            }
            catch(ClassNotFoundException | SQLException e)
            {
                out.println(e.getMessage());
            }
    }
}
