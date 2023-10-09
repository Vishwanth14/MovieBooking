<%-- 
    Document   : first
    Created on : 13-Jun-2020, 1:28:26 pm
    Author     : Varun Reddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="first.css">
    </head>
    <body>
        <form method="post" action="logincheck">
            <div class="login-box">
                <h1>Login</h1>
                <div class="textbox">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <input type="text" placeholder="Username" name="unam" id="qne" required>
                </div>
                <div class="textbox">
                    <i class="fa fa-lock" aria-hidden="true"></i>
                    <input type="password" placeholder="Password" name="pas" id="one" required>
                </div>
                <br>
                <div>
                    <table>
                        <tr>
                            <td><a href="ad.jsp">Admin login</a></td>
                            <td></td>
                            <td><a href="#">Forgot Password</a></td>
                            <td></td>
                            <td><a href="signup.jsp">Sign up</a></td>
                        </tr>
                    </table>
                </div>
                <br>
                <input type="submit" class="btn" value="Login">
                <br>
                <input type="reset" class="btn" value="Clear">
            </div>
        </form>
    </body>
</html>
