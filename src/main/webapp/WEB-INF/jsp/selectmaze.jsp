<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seleccion Laberinto</title>
</head>
<body>
    <h1>Selecciona el laberinto para jugar</h1>
    <form action="/start" method="post">
        <select name="mapa" id="mapa">
            <option value="mapa1">Mapa 1</option>
            <option value="mapa2">Mapa 2</option>
            <input type="submit" value="Start!">

    </form>
    
</body>
</html>