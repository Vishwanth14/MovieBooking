
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
@WebServlet(name = "timings", urlPatterns = {"/timings"})
public class timings extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            HttpSession session = request.getSession();
            if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
            {
                response.sendRedirect("first.jsp");
            }
            String v = String.valueOf(session.getAttribute("r1"));
            String g = request.getParameter("r2");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from movietable where movie='" + v + "' and Theatre='" + g + "'");
            session.setAttribute("r2", g);
            out.println("   <!DOCTYPE HTML>");
                    out.println("   <html>");
                    out.println("       <head>");
                    out.println("           <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                    
                    out.println("           <title>");
                    out.println("               Timing");
                    out.println("           </title>");
                    out.println("<script src=\"third.js\"></script>");
                    out.println("<link rel=\"stylesheet\" href=\"mainstyle.css\">");
                    out.println("       </head>");
                    out.println("       <body>");
                    out.println("<header>");
                    out.println("<nav>");
                    out.println("<ul class=\"nav_links\">");
                    out.println("<li><a href=\"logout\">Logout</a></li>");
                    out.println("</ul>");
                    out.println("</nav>");
                    out.println("<a class=\"cta\" href=\"welcome.jsp\">MOVIE-LIB</a>");
                out.println("</header>");
                    out.println("           <form name=\"form3\" action=\"session1\" method=\"post\" onsubmit=\"return check3()\">");
                    out.println("               <h5>");
                    while(rs.next())
                    {
                        String f = rs.getString(3);
                        out.println("<div>");
                        out.println("<p>");
                        out.println("<input type=\"radio\" name=\"r3\" value=\'"+ rs.getString(3) +"\'>");
                        out.println(rs.getString(3));
                        out.println("</p>");
                        out.println("</div>");
                    }
                    out.println("               </h5>");
                    out.println("<input type=\"submit\" value=\"BOOK\" id=\"book\">");
                    out.println("           </form>");
                    out.println("       </body>");
                    out.println("   </html>");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            out.println(e.getMessage());
        }
    }
}
