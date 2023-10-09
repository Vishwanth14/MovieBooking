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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
@WebServlet(name = "finals", urlPatterns = {"/finals"})
public class finals extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
            {
                response.sendRedirect("first.jsp");
            }
            int n = Integer.parseInt(String.valueOf(session.getAttribute("num")));
            String u = String.valueOf(session.getAttribute("unam"));
            String k =String.valueOf(session.getAttribute("r1"));
            String r = String.valueOf(session.getAttribute("r2"));
            String p = String.valueOf(session.getAttribute("r3"));
            //String o = String.valueOf(session.getAttribute("cardnum"));
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from movietable where movie='" + k + "' and Theatre='" + r + "' and time='" + p + "'");
            rs.next();
            int y = rs.getInt(4);
                y = y-n;
                int q = n*rs.getInt(5);
                out.println("   <!DOCTYPE HTML>");
                out.println("   <html>");
                out.println("       <head>");
                out.println("           <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                out.println("           <title>");
                out.println("               Tickets booking");
                out.println("           </title>");
                out.println("       </head>");
                out.println("       <body>");
                out.println("           <form action=\"raing.jsp\">");
                out.println("               Name:");
                out.println(                u);
                out.println("               <br>");
                out.println("               Movie:");
                out.println(                k);
                out.println("               <br>");
                out.println("               Theatre:");
                out.println(                r);
                out.println("               <br>");
                out.println("               Time:");
                out.println(                p);
                out.println("               <br>");
                out.println("               No of tickets:");
                out.println(                n);
                out.println("               <br>");
                out.println("               Cost:");
                out.println(                q);
                out.println("               <br>");
                //out.println("               Card-number:");
                //out.println(                o);
                out.println("               <br>");
                out.println("               <input type=\"submit\" value=\"Confirm\">");
                out.println("               <a href=\"logout\">exit</a>");
                out.println("           </form>");
                out.println("       </body>");
                out.println("   </html>");
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime nw = LocalDateTime.now();
                String sql = "update movietable set no_of_tickets=? where movie=? and Theatre=? and time=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(2,k);
                pst.setString(3, r);
                pst.setString(4, p);
                pst.setInt(1,y);
                pst.executeUpdate();
                PreparedStatement t = con.prepareStatement("INSERT INTO history(name,movie,Theatre,tickets,cost,time,bookedtime)values(?,?,?,?,?,?,?)");
                t.setString(1, u);
                t.setString(2, k);
                t.setString(3, r);
                t.setInt(4, n);
                t.setInt(5, q);
                t.setString(6, p);
                t.setString(7, dt.format(nw));
                t.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(finals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
