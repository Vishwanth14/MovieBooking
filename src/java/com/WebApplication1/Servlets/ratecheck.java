
package com.WebApplication1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "ratecheck", urlPatterns = {"/ratecheck"})
public class ratecheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
            {
                response.sendRedirect("first.jsp");
            }
            else{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","v@RUN5065");
                Statement sst = con.createStatement();
                ResultSet rs = sst.executeQuery("select * from rating");
                int c = 0;
                int d = 0;
                String u = String.valueOf(session.getAttribute("unam"));
                String m = String.valueOf(session.getAttribute("r1"));
                while(rs.next())
                {
                    if(u.equals(rs.getString(1)))
                    {
                        c = 1;
                        if(m.equals(rs.getString(2)))
                        {
                            d = 1;
                        }
                    }
                }
                if((c == 1) && (d == 1))
                {
                    response.sendRedirect("last.jsp");
                }
                else{
                    response.sendRedirect("raing.jsp");
                }
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(finals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
