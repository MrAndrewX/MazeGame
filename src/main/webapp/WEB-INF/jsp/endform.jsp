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
      <style>
            body{
                background-image: url('https://media.tenor.com/AJBv6U1rfkQAAAAC/background-image-galaxy.gif');
            }
            .content {
      position: absolute;
      background-color: white;
        width: 19%;
      padding: 10% 20%;
      border-radius: 10px;
      left: 50%;
      top: 50%;
      -webkit-transform: translate(-50%, -50%);
      transform: translate(-50%, -50%);
      opacity: 100%;

    }
    .transparent{
        opacity: 80%;
    }
    </style>
</head>
<body>
<div class="content">

    <h1>Has terminado el laberinto!</h1>
    <p>Has acabado con un tiempo de ${time}</p>
    <p>Si quieres guardar tu tiempo, introduce tu nombre</p>
    <form action="/endform" method="post">
        <label for="username"> Nombre: <input type="text" name="username"></label>
        <input type="submit" value="Enviar">
    </form>

    </div>
</body>
</html>