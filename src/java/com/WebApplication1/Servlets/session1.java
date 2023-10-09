/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebApplication1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "session1", urlPatterns = {"/session1"})
public class session1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
        {
                response.sendRedirect("first.jsp");
        }
        else
        {
            String p = request.getParameter("r3");
            session.setAttribute("r3", p);
            response.sendRedirect("ticket");
        }
    }
}
