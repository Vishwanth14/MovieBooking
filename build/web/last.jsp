<%-- 
    Document   : last
    Created on : 02-Jun-2020, 7:49:56 am
    Author     : Varun Reddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Final Page</title>
        <style>
 
#wrapper {
  width: 600px;
  margin: 0 auto;
  margin-top: 15%;
}
h1 {
  color: #EEE;
  text-shadow: -1px -2px 3px rgba(17, 17, 17, 0.3);
  text-align: center;
  font-family: "Monsterrat", sans-serif;
  font-weight: 900;
  text-transform: uppercase;
  font-size: 80px;
  margin-bottom: -5px;
}
h1 underline {
  border-top: 5px solid rgba(26, 188, 156, 0.3);
  border-bottom: 5px solid rgba(26, 188, 156, 0.3);
}
h3 {
  width: 570px;
  margin-left: 16px;
  font-family: "Lato", sans-serif;
  font-weight: 600;
  color: #EEE;
}
.button {
  padding: 10px 15px;
  border: none;

  font-size: 14px;

  margin-top: 30px;

  font-weight: bold;

  background-color: white;
  opacity: 0.4;
  margin-left: 700px;
}
.button:hover {
  opacity: 1;
  cursor: pointer;
}
body
{
  background-image: url(tt.jpg);
}

        </style>
        <%
            if ((session.getAttribute("unam") == null) && (session.getAttribute("pas") == null))
            {
                response.sendRedirect("first.jsp");
            }
        %>
    </head>
    <body>
        <form action="logout">
            <div id="wrapper" class="animated zoomIn">
                <h1>
                    <underline>Thank you!</underline>
                </h1>
            </div>
            <button class="button"><a href="welcome.jsp">Home</a></button>
            <input type="submit" value="Logout" class="button">
            <br>
            <br>
        </form>
    </body>
</html>