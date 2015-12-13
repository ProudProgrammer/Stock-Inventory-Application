<%-- 
    Document   : index
    Created on : 2012.03.14., 17:18:13
    Author     : Balázs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="mycss.css"/>
        <script type="text/javascript" src="jquery-1.5.2.js"></script>
        <script type="text/javascript" src="myjavascript.js"></script>
        <title>Készletnyilvántartó</title>
    </head>
    <body>
        <!-- Az egész oldalt tartalmazó konténer -->
        <div id="container">
            <!-- Felső rész -->
            <div id="top">
                <!-- Logo -->
                <div id="logo">
                    <h1><span id="logo1">Készlet</span><span id="logo2">nyilvántartó</span></h1>
                </div>
                <!-- Menüsor -->
                <div id="menu">
                    <ul>
                        <li>Készlet listázás</li>
                        <li>Új termék</li>
                        <li>Törlés</li>
                        <li>Módosítás</li>
                        <li>Beszerzés</li>
                        <li>Eladás</li>
                        <li>Jelentés</li>
                    </ul>
                </div>
            </div>
            <!-- Középső rész -->
            <div id="middle">
                <!-- Középső rész bal oldali sávja -->
                <div id="leftside">
                    <h2>Használati útmutató</h2>
                    <p><span>Készlet listázás:</span> a teljes készlet kilistázása<br/>
                        <span>Új termék:</span> új termék rögzítése az adatbázisban<br/>
                        <span>Törlés:</span> termék törlése az adatbázisból<br/>
                        <span>Módosítás:</span> adott termék adatainak módosítása<br/>
                        <span>Beszerzés:</span> adott termék raktározott darabszámának növelése<br/>
                        <span>Eladás:</span> adott termék raktározott darabszámának csökkentése<br/>
                        <span>Jelentés:</span> beszerzések és eladások kilistázása<br/>
                    </p>
                </div>
                <!-- Középső rész jobb oldali sávja -->
                <div id="rightside"><h2>Készletlista betöltése...</h2></div>
            </div>
            <!-- Alsó rész -->
            <div id="bottom">
                <p>Gábor Balázs, Miskolci Egyetem, 2012</p>
            </div>
        </div>
    </body>
</html>
