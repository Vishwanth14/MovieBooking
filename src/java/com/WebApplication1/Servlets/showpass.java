
package com.WebApplication1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "showpass", urlPatterns = {"/showpass"})
public class showpass extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet showpass</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet showpass at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try
                {
                    String u = request.getParameter("u");
                    String p = request.getParameter("e");
                    String k = null;
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
                            if(p.equals(rs.getString(3)))
                            {
                                k = rs.getString(2);
                            }
                        }
                    }
                    out.println("Your password is:");
                    out.println("<h2>");
                    out.println(k);
                    out.println("</h2>");
                    out.println("<br>");
                    out.println("<br>");
                    out.println("<button>");
                    out.println("<a href=\"first.jsp\">");
                    out.println("Ok");
                    out.println("</a>");
                    out.println("</button>");
                }
                catch(ClassNotFoundException | SQLException e)
                {
                    out.println(e.getMessage());
                }
    }
}
