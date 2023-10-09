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
@WebServlet(name = "table3", urlPatterns = {"/table3"})
public class table3 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet table3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet table3 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
            {
                HttpSession session = request.getSession();
                if((session.getAttribute("una") == null) && (session.getAttribute("passw") == null))
                {
                    response.sendRedirect("ad.jsp");
                }
                else{
                    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Expires", "0");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
                    Statement st = con.createStatement();
                    out.println("   <!DOCTYPE HTML>");
                    out.println("   <html>");
                    out.println("       <head>");
                    out.println("           <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                    out.println("           <title>");
                    out.println("               History");
                    out.println("           </title>");
                    out.println("<link rel=\"stylesheet\" href=\"admin.css\">");
                    out.println("       </head>");
                    out.println("       <body>");
                    out.println("           <form action=\"logout\">");
                    out.println("<br>");
                    out.println("<h2>Movies</h2>");
                    out.println("<table>");
                    ResultSet q = st.executeQuery("select * from movietable");
                    while(q.next())
                    {
                        out.println("<tr>");
                        out.println("<td>");
                        out.println(q.getString(1));
                        out.println("</td>");
                        out.println("<td>");
                        out.println(q.getString(2));
                        out.println("</td>");
                        out.println("<td>");
                        out.println(q.getString(3));
                        out.println("</td>");
                        out.println("<td>");
                        out.println(q.getInt(4));
                        out.println("</td>");
                        out.println("<td>");
                        out.println(q.getInt(5));
                        out.println("</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.println("<br>");
                    out.println("               <input type=\"submit\" value=\"logout\">");
                    out.println("           </form>");
                    out.println("       </body>");
                    out.println("   </html>");
                }  
            }
            catch(ClassNotFoundException | SQLException e)
            {
                out.println(e.getMessage());
            }
    }
}
