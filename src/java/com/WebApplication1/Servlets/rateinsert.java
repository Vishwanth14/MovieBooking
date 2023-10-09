
package com.WebApplication1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@WebServlet(name = "rateinsert", urlPatterns = {"/rateinsert"})
public class rateinsert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
            {
                response.sendRedirect("first.jsp");
            }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int n = Integer.parseInt(request.getParameter("rat"));
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
            Statement sst = con.createStatement();
            String u = String.valueOf(session.getAttribute("unam"));
            String m = String.valueOf(session.getAttribute("r1"));
            PreparedStatement st = con.prepareStatement("INSERT INTO rating values(?,?,?)");
            st.setString(1, u);
            st.setString(2, m);
            st.setInt(3, n);
            st.executeUpdate();
            response.sendRedirect("last.jsp");
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(finals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
