
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "checking", urlPatterns = {"/checking"})
public class checking extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            HttpSession session = request.getSession();
            int n = Integer.parseInt(String.valueOf(request.getParameter("num")));
            session.setAttribute("num", n);
            String u = String.valueOf(session.getAttribute("unam"));
            String k =String.valueOf(session.getAttribute("r1"));
            String r = String.valueOf(session.getAttribute("r2"));
            String p = String.valueOf(session.getAttribute("r3"));
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from movietable where movie='" + k + "' and Theatre='" + r + "' and time='" + p + "'");
            rs.next();
            if(n > rs.getInt(4))
            {
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal ( 'No. of tickets should be less than the original' , '', 'error' );");
                out.println("});");
                out.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.include(request, response);
            }
            else
            {
                response.sendRedirect("payment.jsp");
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(finals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
