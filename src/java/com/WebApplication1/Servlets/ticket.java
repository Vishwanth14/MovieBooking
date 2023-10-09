
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
@WebServlet(name = "ticket", urlPatterns = {"/ticket"})
public class ticket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            try
            {
                String s = String.valueOf(session.getAttribute("r1"));
                String h = String.valueOf(session.getAttribute("r2"));
                String z = String.valueOf(session.getAttribute("r3"));
                session.setAttribute("r3", z);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from movietable where movie='" + s + "' and Theatre='" + h + "' and time='" + z + "'");
                rs.next();
                if(rs.getInt(4) <= 0)
                {
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                    out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal ( 'No tickets available please select another movie' , '', 'error' );");
                    out.println("});");
                    out.println("</script>");
                    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                    rd.include(request, response);
                }
                else{
                    out.println("<!DOCTYPE HTML>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                    out.println("<script type=\"text/javascript\" src=\"valid.js\"></script>");
                    out.println("<title>");
                    out.println("Tickets booking");
                    out.println("</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<form action=\"checking\" method=\"post\" onsubmit=\"return ne()\">");
                    out.println("<h5>");
                    out.println("No. of tickets remaining :");
                    out.println(rs.getInt(4));
                    out.println("</h5>");
                    out.println("Please enter no of tickets you want to purchase");
                    out.println("<input type=\"text\" name=\"num\" id=\"ide\">");
                    out.println("<input type=\"submit\" value=\"Book\">");
                    out.println("<a href=\"logout\">exit</a>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
            catch(ClassNotFoundException | SQLException e)
            {
                out.println(e.getMessage());
            }
        } 
    }
}
