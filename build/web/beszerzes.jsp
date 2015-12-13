<%-- 
    Document   : beszerzes
    Created on : 2012.03.16., 13:10:00
    Author     : Balázs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beszerzés</title>
    </head>
    <body>
        <h2>Beszerzés</h2><br>
        <form id="beszerzes" action="Beszerzes" method="post">
            <table>
                <tr><td>Termékkód:</td><td><input type="text" id="termekKod" name="termekKod" /></td></tr>
                <tr><td>Mennyiség:</td><td><input type="text" id="mennyiseg" name="mennyiseg" /></td></tr>
            </table>
            <input type="submit" id="termekBeszerzes" value="Beszerzés" />
        </form>
    </body>
</html>
