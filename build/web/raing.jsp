<%-- 
    Document   : raing
    Created on : 17-Jun-2020, 3:39:17 am
    Author     : Varun Reddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rating</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="rate.css">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <%
            if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
            {
                response.sendRedirect("first.jsp");
            }
        %>
    </head>
    <body>
        <div class="rating">
            <form action="rateinsert">
                <h2>Rating</h2>
                <div class="rating">
                    <span class="fa fa-star-o"></span>
                    <span class="fa fa-star-o"></span>
                    <span class="fa fa-star-o"></span>
                    <span class="fa fa-star-o"></span>
                    <span class="fa fa-star-o"></span>
                </div>
                <input type="text" id="rating-value" name="rat">
                <input type="submit" value="Rate" class="btn">
                <br>
                <br>
                <div class="btn">
                    <a href="last.jsp">No thanks</a>
                </div>
            </form>
        </div>
        <script src="rate.js"></script>
    </body>
</html>