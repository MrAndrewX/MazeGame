<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Game</title>
    <link rel="stylesheet" href="./style.css">
</head>
<body>

    <canvas width="800px" height="800px" style="border: 1px black solid;" id="myCanvas"></canvas>
    <div style="display:none;">
        <img id="source" src="./img/coin.png" width="300" height="227" />
      </div>
      <script type="application/json"  id="json-info">
        ${json}
      </script>

<script src="/JS/app.js">
</script>
</body>
</html>