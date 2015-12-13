<%-- 
    Document   : torles
    Created on : 2012.03.16., 13:09:42
    Author     : Balázs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Törlés</title>
    </head>
    <body>
        <h2>Törlés</h2><br>
        <form id="torles" action="Torles" method="post">
            <table>
                <tr><td>Termékkód:</td><td><input type="text" id="termekKod" name="termekKod" /></td></tr>
            </table>
            <input type="submit" id="termekTorles" value="Törlés" />
        </form>
    </body>
</html>
