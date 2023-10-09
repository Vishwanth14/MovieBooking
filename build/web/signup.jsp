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
        <title>Registration</title>
        <link rel="stylesheet" href="second.css">
        <script type="text/javascript" src="va.js"></script>
    </head>
    <body>
        <form action="insert" method="post" onsubmit="return dare()">
            <div class="login-box">
                <h1>Register</h1>
                <div id="new_error">
                
            </div>
                <div class="textbox">
                    <i></i>
                    <input type="text" placeholder="Username" name="una" id="un">
                </div>
                <div class="textbox">
                    <i></i>
                    <input type="password" placeholder="Password" name="pass" id="pa">
                </div>
                <div class="textbox">
                    <i></i>
                    <input type="password" placeholder="Confirm Password" name="conf" id="co">
                </div>
                <div class="textbox">
                    <i></i>
                    <input type="email" placeholder="Email" name="emai" id="em">
                </div>
                <div class="textbox">
                    <i></i>
                    <input type="text" placeholder="Mobile" name="phon" id="ph">
                </div>
                <input type="submit" class="btn" value="Signup">
            </div>
        </form>
    </body>
</html>
