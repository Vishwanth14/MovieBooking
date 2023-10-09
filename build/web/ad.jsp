<%-- 
    Document   : ad
    Created on : 04-Jun-2020, 10:49:45 am
    Author     : Varun Reddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link rel="stylesheet" href="ad.css">
    </head>
    <body>
        <form method="post" action="admincheck">
            <div class="login-box">
                <h1>Admin Login</h1>
                <div class="textbox">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <input type="text" placeholder="Username" name="una" id="qne" required>
                </div>
                <div class="textbox">
                    <i class="fa fa-lock" aria-hidden="true"></i>
                    <input type="password" placeholder="Password" name="passw" id="one" required>
                </div>
                <input type="submit" class="btn" value="Login">
                <br>
                <input type="reset" class="btn" value="Clear">
            </div>
        </form>
    </body>
</html>
