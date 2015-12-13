<%-- 
    Document   : ujtermek
    Created on : 2012.03.16., 13:06:46
    Author     : Balázs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Új termék</title>
    </head>
    <body>
        <h2>Új termék</h2><br>
        <form id="ujTermekForm" action="UjTermek" method="post">
            <table>
                <tr><td>Terméknév:</td><td><input type="text" id = "termekNev" name="termekNev" /></td></tr>
                <tr><td>Beszerzési ár:</td><td><input type="text" id = "beszerzesiAr" name="beszerzesiAr" /></td></tr>
                <tr><td>Eladási ár:</td><td><input type="text" id = "eladasiAr" name="eladasiAr" /></td></tr>
                <tr><td>Mennyiség egysége:</td><td><input type="text" id = "mennyisegEgysege" name="mennyisegEgysege" /></td></tr>
            </table>
            <input type="submit" id="TermekRogzitese" value="Termék rögzítése" />
        </form>
    </body>
</html>
