
package com.WebApplication1.Servlets;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet(name = "Fileupload", urlPatterns = {"/Fileupload"})
@MultipartConfig(fileSizeThreshold = 1024*1024*2,maxFileSize = 1024*1024*10,maxRequestSize = 1024*1024*50)
public class Fileupload extends HttpServlet {
    private static final String SAVE_DIR = "images";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String savePath = "C:\\Users\\B.Vishwanth Reddy\\Documents\\NetBeansProjects\\WebApplication1\\web\\" + File.separator + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        String m = request.getParameter("movn");
        Part part = request.getPart("file");
        String fileName = extractFileName(part);
        part.write(savePath + File.separator + fileName);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
            PreparedStatement pst = con.prepareStatement("insert into images values(?,?,?)");
            pst.setString(1, m);
            String filePath = savePath + File.separator + fileName;
            pst.setString(2, filePath);
            pst.setString(3, fileName);
            pst.executeUpdate();
            out.println("Upload successfully");
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for(String s : items)
        {
            if(s.trim().startsWith("filename"))
            {
                return s.substring(s.indexOf("=") + 2, s.length() -1);
            }
        }
        return "";
    }
}
