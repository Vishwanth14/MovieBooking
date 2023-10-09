package com.WebApplication1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
@WebServlet(name = "logincheck", urlPatterns = {"/logincheck"})
public class logincheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
                try
                {
                    String u = request.getParameter("unam");
                    String p = request.getParameter("pas");
                    session.setAttribute("unam",u);
                    session.setAttribute("pas",p);
                    if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
                    {
                        response.sendRedirect("first.jsp");
                    }   
                    int c = 0;
                    int d = 0;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from user");
                    while(rs.next())
                    {
                        if(u.equals(rs.getString(1)))
                        {
                            c = 1;
                            if(p.equals(rs.getString(2)))
                            {
                                d = 1;
                            }
                        }
                    }
                    if((c == 1) && (d == 1))
                    {
                        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime nw = LocalDateTime.now();
                        PreparedStatement t = con.prepareStatement("INSERT INTO loginsession(name,login_time)values(?,?)");
                        t.setString(1, u);
                        t.setString(2, dt.format(nw));
                        t.executeUpdate();
                        response.sendRedirect("welcome.jsp");
                    }
                    else if((c == 1) && (d == 0))
                    {
                        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                        out.println("<script>");
                        out.println("$(document).ready(function(){");
                        out.println("swal ( 'incorrect password' , '', 'error' );");
                        out.println("});");
                        out.println("</script>");
                        RequestDispatcher rd = request.getRequestDispatcher("first.jsp");
                        rd.include(request, response);
                    }
                    else if((c == 0) && (d == 0))
                    {
                        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                        out.println("<script>");
                        out.println("$(document).ready(function(){");
                        out.println("swal ( 'Please Register' , ' ', 'error' );");
                        out.println("});");
                        out.println("</script>");
                        RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                        rd.include(request, response);
                    }
                }
                catch(ClassNotFoundException | SQLException e)
                {
                    out.println(e.getMessage());
                }
        }
    }
}