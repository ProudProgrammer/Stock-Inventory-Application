<%-- 
    Document   : modositas
    Created on : 2012.03.31., 12:19:56
    Author     : Balázs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Módosítás</title>
    </head>
    <body>
        <h2>Módosítás</h2><br>
        <form id="modositas" action="Modositas" method="post">
            <table>
                <tr><td>Termékkód:</td><td><input type="text" id="termekKod" name="termekKod" /></td></tr>
                <tr><td>Terméknév:</td><td><input type="text" id = "termekNev" name="termekNev" /></td></tr>
                <tr><td>Beszerzési ár:</td><td><input type="text" id = "beszerzesiAr" name="beszerzesiAr" /></td></tr>
                <tr><td>Eladási ár:</td><td><input type="text" id = "eladasiAr" name="eladasiAr" /></td></tr>
                <tr><td>Mennyiség egysége:</td><td><input type="text" id = "mennyisegEgysege" name="mennyisegEgysege" /></td></tr>
            </table>
            <input type="submit" id="Modositas" value="Módosítás" />
        </form>
    </body>
</html>
