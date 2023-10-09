<%-- 
    Document   : add image
    Created on : 16-Jun-2020, 5:04:07 am
    Author     : Varun Reddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding images</title>
    </head>
    <body>
        <form method="post" action="Fileupload" enctype="multipart/form-data">
            <table width="400px" align="center" border="2">
                <tr>
                    <td align="center" colspan="2">form Details</td>
                </tr>
                <tr>
                    <td>Movie name</td>
                    <td><input type="text" name="movn"></td>
                </tr>
                <tr>
                    <td>Movie Image</td>
                    <td><input type="file" name="file"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="upload"></td>
                </tr>
            </table>
            <a href="logout">Exit</a>
        </form>
    </body>
</html>
