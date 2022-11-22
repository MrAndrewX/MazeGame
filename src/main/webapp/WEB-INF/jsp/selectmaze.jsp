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
    <script src="https://kit.fontawesome.com/9c8fbde034.js" crossorigin="anonymous"></script>
    <style>
        body{
            background-image: url('https://media.tenor.com/AJBv6U1rfkQAAAAC/background-image-galaxy.gif');
        }
        .content {
  position: absolute;
  background-color: white;

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


.myButton {
	background-color:#44c767;
	border-radius:42px;
	border:2px solid #18ab29;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Verdana;
	font-size:17px;
	padding:16px 31px;
    margin-bottom:10%;

    margin-top:120%;
	text-decoration:none;
	text-shadow:0px 2px 2px #2f6627;
}
.myButton:hover {
	background-color:#5cbf2a;
}
.myButton:active {
	position:relative;
	top:1px;
}
.box {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.box select {
  background-color: #0563af;
  color: white;
  padding: 12px;
  width: 250px;
  border: none;
  font-size: 20px;
  box-shadow: 0 5px 25px rgba(0, 0, 0, 0.2);
  -webkit-appearance: button;
  appearance: button;
  outline: none;
}

.box::before {
  content: "\f13a";
  font-family: FontAwesome;
  position: absolute;
  top: 0;
  right: 0;
  width: 20%;
  height: 100%;
  text-align: center;
  font-size: 28px;
  line-height: 45px;
  color: rgba(255, 255, 255, 0.5);
  background-color: rgba(255, 255, 255, 0.1);
  pointer-events: none;
}

.box:hover::before {
  color: rgba(255, 255, 255, 0.6);
  background-color: rgba(255, 255, 255, 0.2);
}

.box select option {
  padding: 30px;
}

    </style>
</head>
<body>
    <div class="transparent">

    <div class="content">
        <h1>Maze</h1>

        <form action="/start" method="post">
            <div class="box">
            <select name="mapid" id="mapa">

                <option value="1">Mapa 1</option>
                <option value="2">Mapa 2</option>
                </select>
            </div>
                <input type="submit" value="Go!" class="myButton">
        </form>
        </div>
    </div>
    
</body>
</html>