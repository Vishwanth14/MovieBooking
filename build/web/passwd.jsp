<%-- 
    Document   : signup
    Created on : 13-Jun-2020, 2:47:10 pm
    Author     : Varun Reddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password check</title>
        <link rel="stylesheet" href="second.css">
        <script type="text/javascript" src="sec.js"></script>
    </head>
    <body>
        <form method="post" action="showpass" onsubmit="return pass()">
            <div class="login-box">
                <h1>Password check</h1>
                <div id="new_error">
                
            </div>
                <div class="textbox">
                    <i></i>
                    <input type="text" placeholder="Username" name="u" id="un" required>
                </div>
                <div class="textbox">
                    <i></i>
                    <input type="email" placeholder="Email" name="e" id="em" required>
                </div>
                <input type="submit" class="btn" value="Check the password">
            </div>
        </form>
    </body>
</html>
