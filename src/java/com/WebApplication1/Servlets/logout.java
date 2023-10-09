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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
            HttpSession session = request.getSession();
            if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
            {
                response.sendRedirect("first.jsp");
            }
            else{
                String o = String.valueOf(session.getAttribute("unam"));
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime nw = LocalDateTime.now();
                PreparedStatement t = con.prepareStatement("update loginsession set logout_time=? where name=?");
                t.setString(2, o);
                t.setString(1, dt.format(nw));
                t.executeUpdate();
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Expires", "0");
                session.removeAttribute("unam");
                session.removeAttribute("pas");
                session.removeAttribute("r1");
                session.removeAttribute("r2");
                session.removeAttribute("r3");
                session.removeAttribute("num");
                session.removeAttribute("una");
                session.removeAttribute("passw");
                session.invalidate();
                response.sendRedirect("guest.jsp");
            }
        }
        catch(ClassNotFoundException | SQLException e)
            {
                out.println(e.getMessage());
            }
    }
}
