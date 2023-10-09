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
@WebServlet(name = "movierating", urlPatterns = {"/movierating"})
public class movierating extends HttpServlet {
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
                    out.println("<h2><center>Transactions</center></h2>");
                    out.println("<table>");
                    ResultSet r = st.executeQuery("select * from rating");
                    while(r.next())
                    {
                        out.println("<tr>");
                        out.println("<td>");
                        out.println(r.getString(1));
                        out.println("</td>");
                        out.println("<td>");
                        out.println(r.getString(2));
                        out.println("</td>");
                        out.println("<td>");
                        out.println(r.getInt(3));
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
