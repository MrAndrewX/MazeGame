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
    <style>
    body{
    background-image:url("https://cdn.mwallpapers.com/photos/celebrities/aesthetic/aesthetic-sun-android-iphone-desktop-hd-backgrounds-wallpapers-1080p-4khd-wallpapers-desktop-background-android-iphone-1080p-4k-xwx5v.jpg");
    background-repeat: no-repeat;
    background-size:cover;

    }
    .container {
      display: flex;
      justify-content: center;
    }

.bn632-hover {
  width: 160px;
  font-size: 16px;
  font-weight: 600;
  color: #fff;
  cursor: pointer;
  margin: 20px;
  height: 55px;
  text-align:center;
  border: none;
  background-size: 300% 100%;
  border-radius: 50px;
  moz-transition: all .4s ease-in-out;
  -o-transition: all .4s ease-in-out;
  -webkit-transition: all .4s ease-in-out;
  transition: all .4s ease-in-out;
}

.bn632-hover:hover {
  background-position: 100% 0;
  moz-transition: all .4s ease-in-out;
  -o-transition: all .4s ease-in-out;
  -webkit-transition: all .4s ease-in-out;
  transition: all .4s ease-in-out;
}

.bn632-hover:focus {
  outline: none;
}
.canvasstyle{
border: 1px black solid;
background-color:white;
}

.bn632-hover.bn21 {
  background-image: linear-gradient(
    to right,
    #fc6076,
    #ff9a44,
    #ef9d43,
    #e75516
  );
  box-shadow: 0 4px 15px 0 rgba(252, 104, 110, 0.75);
  .none{
  display:none;
  }
}
    </style>
</head>
<body>
    <div class="container">
    <canvas width="800px" height="800px" class="canvasstyle" id="myCanvas"></canvas>

      </div>
       <form action="/reset" method="GET">
              <input type="submit" value="Reset" class="bn632-hover bn21">
            </form>
            <form action="/start" method="GET">
              <input type="submit" value="Abandonar" class="bn632-hover bn21">
            </form>
      <script type="application/json"  id="json-info">
        ${json}
      </script>

<script src="/JS/app.js">
</script>
</body>
</html>