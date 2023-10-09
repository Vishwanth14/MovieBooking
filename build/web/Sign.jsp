<%-- 
    Document   : Sign
    Created on : 13-Jun-2020, 2:25:34 am
    Author     : Varun Reddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login/Sign-up</title>
        <link rel="stylesheet" href="sign.css">
        <script type="text/javascript">
            function validation()
            {
                var u = document.getElementById('un').value;
                var p = document.getElementById('pa').value;
                var c = document.getElementById('co').value;
                var e = document.getElementById('em').value;
                var pho = document.getElementById('ph').value;
                var emg = document.getElementById('new_error');
                var pattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
                var text;
                if(isNaN(u) === false)
                {
                    text = "Enter a name";
                    alert(text);
                }
                if(p.length < 6)
                {
                    text = "Password length must be greater than 6 ";
                    alert(text);
                }
                if(p !== c)
                {
                    text = "Both the passwords should match";
                    alert(text);
                }
                if(pattern.test(e) === false)
                {
                    text = "Enter a valid email";
                    alert(text);
                }
                if(isNaN(pho) && (pho.length !== 10))
                {
                    text = "Enter a valid mobile no";
                    alert(text);
                }
            }
            window.onload = function()
            {
                document.getElementById('un').value = '';
                document.getElementById('pa').value = '';
                document.getElementById('co').value = '';
                document.getElementById('em').value = '';
                document.getElementById('ph').value = '';
            }
        </script>
    </head>
    <body>
        <div class="hero">
            <div class="form-box">
                <div class="button-box">
                    <div id="btn"></div>
                    <button type="button" class="toggle-btn" onclick="login()">Login</button>
                    <button type="button" class="toggle-btn" onclick="register()">Sign-up</button>
                </div>
                <form id="login" class="input-group" method="post" action="logincheck">
                    <input type="text" class="input-field" placeholder="Username" name="unam" required>
                    <input type="password" class="input-field" placeholder="Password" name="pas" required>
                    <input type="submit" class="submit-btn" value="Login">
                    <br>
                    <input type="reset" class="reset-btn" value="Clear">
                </form>
                <form id="register" class="input-group" method="post" action="insert">
                    <div id="new_error">
                        
                    </div>
                    <input type="text" class="input-field" placeholder="Username" name="una" id="un" required>
                    <input type="password" class="input-field" placeholder="Password" name="pass" id="pa" >
                    <input type="password" class="input-field" placeholder="Confirm Password" name="conf" id="co" >
                    <input type="email" class="input-field" placeholder="Email" name="emai" id="em" >
                    <input type="text" class="input-field" placeholder="Mobile no" name="phon" id="ph" >
                    <input type="checkbox" class="check-box" id="chb"><span>I agree to the terms and conditions</span>
                    <input type="submit" class="submit-btn" value="Register" onclick="validation()">
                    <br>
                    <input type="reset" class="reset-btn" value="Clear">
                </form>
            </div>
        </div>
        <script src="new.js">
        </script>
    </body>
</html>
