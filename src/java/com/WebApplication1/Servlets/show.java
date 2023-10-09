package com.WebApplication1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "show", urlPatterns = {"/show"})
public class show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
            {
                HttpSession session = request.getSession();
                if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
                {
                    response.sendRedirect("first.jsp");
                }
                String s = String.valueOf(session.getAttribute("unam"));
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from history where name='" + s + "'");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"table.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class = \"filter\">");
                out.println("<div class=\"btn\">");
                out.println("<a href=\"welcome.jsp\">back</a>");
                out.println("</div>");
                out.println("</div>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>");
                out.println("Name");
                out.println("</th>");
                out.println("<th>");
                out.println("Movie");
                out.println("</th>");
                out.println("<th>");
                out.println("Theatre");
                out.println("</th>");
                out.println("<th>");
                out.println("Tickets");
                out.println("</th>");
                out.println("<th>");
                out.println("Cost");
                out.println("</th>");
                out.println("<th>");
                out.println("Time");
                out.println("</th>");
                out.println("<th>");
                out.println("Booked Time");
                out.println("</th>");
                out.println("<th>");
                out.println("Payment");
                out.println("</th>");
                out.println("</tr>");
                while(rs.next())
                {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(rs.getString(1));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getString(2));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getString(3));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getInt(4));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getInt(5));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getString(6));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getString(7));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getString(8));
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
            catch(ClassNotFoundException | SQLException e)
            {
                out.println(e.getMessage());
            }
    }
}
