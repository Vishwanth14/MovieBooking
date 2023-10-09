<%-- 
    Document   : welcome
    Created on : 28-May-2020, 3:56:08 pm
    Author     : Varun Reddy
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
        <link rel="stylesheet" href="mainstyle.css">
        <script src="second.js"></script>
        <script>
            function load(){
                var x = new XMLHttpRequest();
                x.onreadystatechange = function(){
                    if(this.readyState == 4 && this.status == 200)
                    {
                        document.getElementById("dem1").style.padding = "10px";
                        document.getElementById("dem1").style.height = "100px";
                        document.getElementById("dem1").innerHTML = this.responseText;
                    }
                };
                x.open("GET","t1.txt",true);
                x.send();
            }
            function load1(){
                var x = new XMLHttpRequest();
                x.onreadystatechange = function(){
                    if(this.readyState == 4 && this.status == 200)
                    {
                        document.getElementById("dem2").style.padding = "10px";
                        document.getElementById("dem2").style.height = "100px";
                        document.getElementById("dem2").innerHTML = this.responseText;
                    }
                };
                x.open("GET","t2.txt",true);
                x.send();
            }
            function load2(){
                var x = new XMLHttpRequest();
                x.onreadystatechange = function(){
                    if(this.readyState == 4 && this.status == 200)
                    {
                        document.getElementById("dem3").style.padding = "10px";
                        document.getElementById("dem3").style.height = "100px";
                        document.getElementById("dem3").innerHTML = this.responseText;
                    }
                };
                x.open("GET","t3.txt",true);
                x.send();
            }
        </script>
       <%
            if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
            {
                response.sendRedirect("first.jsp");
            }
        %>
    </head>
    <body>
        <header>
            <nav>
                <ul class="nav_links">
                    <li><a href="#">Feedback</a></li>
                    <li><a href="show">History</a></li>
                    <li><a href="logout">Logout</a></li>
                </ul>
            </nav>
            <a class="cta" href="welcome.jsp">MOVIE-LIB</a>
        </header>
        <div class="main">
            <form name="form1" method="post" action="session" onsubmit="return check()">
                <h1>MOVIE LIB</h1>
                <div id="ers"></div>
                <table>
                    <tr>
                        <td>
                            <%
                                try{
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","QwErTy1357&%#!");
                                    Statement st = con.createStatement();
                                    String a = "Avengers";
                                    String b = "Justice League";
                                    String c = "Inception";
                                    String o ="select filename from images where name= '" + a + "' ";
                                    String p = "select filename from images where name= '" + b + "' ";
                                    String n = "select filename from images where name= '" + c + "' ";
                                    ResultSet rs = st.executeQuery(o);
                                    while(rs.next()){
                                        String filename = rs.getString("filename");
                            %>
                            <p><input type="radio" name="r1" value="Avengers">Avengers</p>
                            <image src="images/<%=filename%>" width="100" height="100"/>
                        </td>
                        <td>
                            
                        </td>
                        <td>
                            
                        </td>
                        <td>
                            <div id="demo">
                                <button type="button" onclick="load()">About</button>
                                <p id="dem1"></p>
                            </div>
                        </td>
                    </tr>
                    <br>
                    <br>
                            <%
                                    }
                            %>
                    <tr>
                        <td>
                            <%
                                ResultSet rs1 = st.executeQuery(p);
                                while(rs1.next()){
                                    String filename = rs1.getString("filename");
                            %>
                            
                            <p><input type="radio" name="r1" value="Justice League">Justice League</p>
                            <image src="images/<%=filename%>" width="100" height="100"/>
                        </td>
                        <td>
                            
                        </td>
                        <td>
                            
                        </td>
                        <td>
                            <div id="demo">
                                <button type="button" onclick="load1()">About</button>
                                <p id="dem2"></p>
                            </div>
                        </td>
                    </tr>
                    <br>
                    <br>
                            <%
                                    }
                            %>
                    <tr>
                        <td>
                            <%
                                ResultSet rs2 = st.executeQuery(n);
                                while(rs2.next()){
                                    String filename = rs2.getString("filename");
                            %>
                            
                            <p><input type="radio" name="r1" value="Inception">Inception</p>
                            <image src="images/<%=filename%>" width="100" height="100"/>
                        </td>
                        <td>
                            
                        </td>
                        <td>
                            
                        </td>
                        <td>
                            <div id="demo">
                                <button type="button" onclick="load2()">About</button>
                                <p id="dem3"></p>
                            </div>
                        </td>
                    </tr>
                            <%
                                    }
                            %>
                    <tr>
                            <%
                                }catch (Exception e){
                                    out.println(e);
                                }
                            %>
                        <td><input type="submit" value="BOOK" id="book"></td>
                    </tr>
                    <tr>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
