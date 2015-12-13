<%-- 
    Document   : eladas
    Created on : 2012.03.16., 13:10:19
    Author     : Balázs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eladás</title>
    </head>
    <body>
        <h2>Eladás</h2><br>
        <form id="eladas" action="Eladas" method="post">
            <table>
                <tr><td>Termékkód:</td><td><input type="text" id="termekKod" name="termekKod" /></td></tr>
                <tr><td>Mennyiség:</td><td><input type="text" id="mennyiseg" name="mennyiseg" /></td></tr>
            </table>
            <input type="submit" id="termekEladas" value="Eladás" />
        </form>
    </body>
</html>
