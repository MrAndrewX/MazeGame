<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir datos</title>
</head>
<body>
    <h1>Has terminado el laberinto!</h1>
    <p>Has acabado con un tiempo de ${time}</p>
    <p>Si quieres guardar tu tiempo, introduce tu nombre</p>
    <form action="/endform" method="post">
        <label for="username"> Nombre: <input type="text" name="username"></label>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>