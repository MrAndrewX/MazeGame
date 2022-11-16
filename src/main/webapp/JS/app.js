let c = document.getElementById("myCanvas");
let ctx = c.getContext("2d");
ctx.fillRect(130, 130, 400, 400);
ctx.fillStyle = "#FFFFFF";
ctx.fillRect(160, 160, 340, 340);

const room = JSON.parse(document.getElementById("json-info").textContent)

ctx.fillStyle = "black";
ctx.font = '20px serif';
  ctx.fillText(`Room: ${room.roomnumber}`, 5, 40);
  ctx.fillText(`Coins: ${room.items[0].coins}`, 5, 60);
  ctx.fillText(`Keys: ${room.items[1].keys}`, 5, 80);

/* -- Norte -- */
if(room.n == "close"){
    ctx.fillStyle = "#FF0000";
    ctx.fillRect(290 , 130, 100, 30);

}else if(room.n == "open"){
    ctx.fillStyle = "#FFFFFF";
    ctx.fillRect(290 , 130, 100, 30);

}
else if(room.n == "wall"){
    ctx.fillStyle = "black";
    ctx.fillRect(290 , 130, 100, 30);

}

/* -- Sur -- */
if(room.s == "close"){
    ctx.fillStyle = "#FF0000";
    ctx.fillRect(290 , 500, 100, 30);

}else if(room.s == "open"){
    ctx.fillStyle = "#FFFFFF";
    ctx.fillRect(290 , 500, 100, 30);

}else if(room.s == "wall"){
    ctx.fillStyle = "black";
    ctx.fillRect(290 , 500, 100, 30);

}
/* -- Oeste -- */
if(room.w == "close"){
    ctx.fillStyle = "#FF0000";
    ctx.fillRect(130 , 285, 30, 100);

}else if(room.w == "open"){
    ctx.fillStyle = "#FFFFFF";
    ctx.fillRect(130 , 285, 30, 100);

}else if(room.w == "wall"){
    ctx.fillStyle = "black";
    ctx.fillRect(130 , 285, 30, 100);

}

/* -- Este -- */
if(room.e == "close"){
    ctx.fillStyle = "#FF0000";
    ctx.fillRect(500 , 285, 30, 100);

}else if(room.e == "open"){
    ctx.fillStyle = "#FFFFFF";
    ctx.fillRect(500 , 285, 100, 100);
}
else if(room.e == "wall"){
    ctx.fillStyle = "black";
    ctx.fillRect(500 , 285, 100, 100);
}
// const coinimg = document.getElementById("source");




const coinimg= new Image(60,45);
if(room.coindisplay == true){

    coinimg.onload = drawCoin;
    coinimg.src = './img/coin.png'
}
function drawCoin(){
    ctx.drawImage(coinimg,425,425,60,60)
}

const keyimg = new Image(60,45);

if(room.keydisplay == true){

    keyimg.onload = drawKey;
    keyimg.src = './img/key.png'
}
function drawKey(){
    ctx.drawImage(keyimg,175,410,78,78)
}
const arrowsimg = new Image(60,45);
arrowsimg.onload = drawArrows;
arrowsimg.src = './img/arrows.png'
function drawArrows(){
ctx.drawImage(arrowsimg,575,610,220,220)
}
const pjimg = new Image(60,45);
pjimg.onload = drawpj;
pjimg.src = './img/pj.png'
function drawpj(){
    ctx.drawImage(pjimg,290,280,100,100)
}

function getCursorPosition(canvas, event) {
    const rect = canvas.getBoundingClientRect()
    const x = event.clientX - rect.left
    const y = event.clientY - rect.top
    console.log("x: " + x + " y: " + y)
    //Coin click
    if(x >422 && y>422 && x<484 && y<484 && room.coindisplay == true){
        console.log("coin click")
        coinClicked();
    }
    //key Click
    if(x >174 && y > 421 && x <239 && y < 476 && room.keydisplay == true){
        console.log("Key clicked")
        keyClicked();
    }
    //Arrows
    //up
    if(x >649 && y > 651 && x <719 && y < 716){
        //get request
        console.log("up")
        var url = 'http://172.0.0.1:8080/nav?dir=N';
        window.location = url;
    }
    //down
    if(x >650 && y > 726 && x <718 && y < 790){
        //get request
        console.log("down")
        var url = 'http://172.0.0.1:8080/nav?dir=S';
        window.location = url;
    }
    //left
    if(x >577 && y > 727 && x <644 && y < 790){
        //get request
        console.log("left")
        var url = 'http://172.0.0.1:8080/nav?dir=W';
        window.location = url;
    }
    if(x >727 && y > 726 && x <796 && y < 790){
        //get request
        console.log("right")
        var url = 'http://172.0.0.1:8080/nav?dir=E';
        window.location = url;
    }

}
function keyClicked(){
    ctx.fillRect(174,421, 70,70)
    room.keydisplay = false;
}
function coinClicked(){
    console.log("dibujando")
ctx.fillRect(422,422, 70,70)
room.coindisplay=false;
}

const canvas = document.querySelector('canvas')
canvas.addEventListener('mousedown', function(e) {
    getCursorPosition(canvas, e)
})