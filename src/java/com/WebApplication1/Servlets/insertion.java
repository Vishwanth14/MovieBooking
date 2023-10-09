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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Varun Reddy
 */
@WebServlet(name = "insertion", urlPatterns = {"/insertion"})
public class insertion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
            String k = "Inception";
            String p = "INOX";
            String t = "1:00pm";
            int n = 150;
            int c = 120;
            PreparedStatement sq = con.prepareStatement("insert into movietable(movie,Theatre,time,no_of_tickets,cost)values(?,?,?,?,?)");
            sq.setString(1, k);
            sq.setString(2, p);
            sq.setString(3, t);
            sq.setInt(4, n);
            sq.setInt(5, c);
            sq.executeUpdate();
            out.println("Success");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            out.println(e.getMessage());
        }
    }
}
