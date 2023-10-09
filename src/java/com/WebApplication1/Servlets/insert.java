/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebApplication1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Varun Reddy
 */
@WebServlet(name = "insert", urlPatterns = {"/insert"})
public class insert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            int c = 0;
                String n = request.getParameter("una");
                String p = request.getParameter("pass");
                String e = request.getParameter("emai");
                String m = request.getParameter("phon");
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
                Statement sst = con.createStatement();
                ResultSet rs = sst.executeQuery("select * from user");
                while(rs.next())
                {
                    if(n.equals(rs.getString(1)))
                    {
                        c = 1;
                    }
                }
                if(c == 1)
                {
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                    out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal ( 'Username alraedy exists' , '', 'error' );");
                    out.println("});");
                    out.println("</script>");
                    RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                    rd.include(request, response);
                }
                else{
                    PreparedStatement st = con.prepareStatement("INSERT INTO user(username,password,email,mobile)values(?,?,?,?)");
                    st.setString(1, n);
                    st.setString(2, p);
                    st.setString(3, e);
                    st.setString(4, m);
                    st.executeUpdate();
                    response.sendRedirect("first.jsp");
                }
            
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(finals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
