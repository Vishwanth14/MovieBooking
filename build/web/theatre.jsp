<%-- 
    Document   : theatre
    Created on : 10-Jun-2020, 5:27:33 am
    Author     : Varun Reddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Theatre </title>
        <link rel="stylesheet" href="mainstyle.css">
        <script src="se.js"></script>
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
                    <li><a href="logout">Logout</a></li>
                </ul>
            </nav>
            <a class="cta" href="welcome.jsp">MOVIE-LIB</a>
        </header>
        <div class="main">
            <form name="form2" method="post" action="timings" onsubmit="return check1()">
                <div id="ers"></div>
                <table>
                    <tr>
                        <td><p><input type="radio" name="r2" value="INOX">Inox</p></td>
                    </tr>
                    <tr>
                        <td><p><input type="radio" name="r2" value="CAPITAL MOVIES">Capital Movies</p></td>
                    </tr>
                    <tr>
                        <td><p><input type="radio" name="r2" value="ASIAN MOVIES">Asian Movies</p></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="BOOK" id="book"></td>
                    </tr>
                    <tr>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
