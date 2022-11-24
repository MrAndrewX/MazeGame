let c = document.getElementById("myCanvas");
let ctx = c.getContext("2d");
ctx.fillRect(130, 130, 400, 400);
ctx.fillStyle = "#FFFFFF";
ctx.fillRect(160, 160, 340, 340);

const room = JSON.parse(document.getElementById("json-info").textContent)

ctx.fillStyle = "black";
ctx.font = '20px serif';
ctx.fillText(`${room.message}`, 141, 101);




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
    coinimg.src = '/img/coin.png'
}
function drawCoin(){
    ctx.drawImage(coinimg,425,425,60,60)

}

const keyimg = new Image(60,45);

if(room.keydisplay == true){

    keyimg.onload = drawKey;
    keyimg.src = '/img/key.png'
}
function drawKey(){
    ctx.drawImage(keyimg,175,410,78,78)
}
const arrowsimg = new Image(60,45);
arrowsimg.onload = drawArrows;
arrowsimg.src = '/img/arrows.png'
function drawArrows(){
ctx.drawImage(arrowsimg,575,610,220,220)
}
const pjimg = new Image(60,45);
pjimg.onload = drawpj;
pjimg.src = '/img/pj.png'
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
        window.location.assign("http://127.0.0.1:8080/nav?dir=N");
    }
    //down
    if(x >650 && y > 726 && x <718 && y < 790){
        //get request
        console.log("down")
  window.location.assign("http://127.0.0.1:8080/nav?dir=S");
    }
    //left
    if(x >577 && y > 727 && x <644 && y < 790){
        //get request
        console.log("left")
        window.location.assign("http://127.0.0.1:8080/nav?dir=W");
    }
    if(x >727 && y > 726 && x <796 && y < 790){
        //get request
        console.log("right")
        window.location.assign("http://127.0.0.1:8080/nav?dir=E");

    }
     if(x >577 && y > 727 && x <644 && y < 790){
            //get request
            console.log("left")
            window.location.assign("http://127.0.0.1:8080/nav?dir=W");
        }
        if(x >727 && y > 726 && x <796 && y < 790){
            //get request
            console.log("right")
            window.location.assign("http://127.0.0.1:8080/nav?dir=E");

        }
        if(x >291 && y > 132 && x <390 && y < 160 && room.n == "close"){
            //abrir norte
            console.log("abrir norte")
            openNorth()
        }
        if(x >291 && y > 503 && x <390 && y < 529 && room.s == "close"){
            //abrir sur
            console.log("abrir Sur")
            openSur()
        }
        if(x >503 && y > 286 && x <531 && y < 386 && room.e == "close"){
            //abrir este
            console.log("abrir Este")
            openEste()
        }
        if(x >133 && y > 286 && x <161 && y < 386 && room.w == "close"){
            //abrir west
            console.log("abrir west")
            openWest()
        }
        if(x >0 && y > 0 && x <800 && y < 800 && room.end == "true"){
                window.location.assign("http://127.0.0.1:8080/endform");


            }

}
function openWest(){

    room.w = "open"
    ctx.fillStyle = "white";
    ctx.fillRect(130 , 285, 30, 100);
    window.location.assign("http://127.0.0.1:8080/open?dir=W");
}
function openEste(){

    room.e = "open"
    ctx.fillStyle = "white";
    ctx.fillRect(500 , 285, 100, 100);
    window.location.assign("http://127.0.0.1:8080/open?dir=E");
}
function openSur(){
    room.s = "open"
    ctx.fillStyle = "white";
    ctx.fillRect(290 , 500, 100, 30);
    window.location.assign("http://127.0.0.1:8080/open?dir=S");
}
function openNorth(){
    room.n = "open"
    ctx.fillStyle = "white";
    ctx.fillRect(290 , 130, 100, 30);
    window.location.assign("http://127.0.0.1:8080/open?dir=N");
}
function keyClicked(){
    ctx.fillStyle="white";
    ctx.fillRect(174,421, 70,70)
    window.location.assign("http://127.0.0.1:8080/getkey");
    room.keydisplay = false;
}
function coinClicked(){
ctx.fillStyle="white";
window.location.assign("http://127.0.0.1:8080/getcoin");
ctx.fillRect(422,422, 70,70)
room.coindisplay=false;
}

const canvas = document.querySelector('canvas')
canvas.addEventListener('mousedown', function(e) {
    getCursorPosition(canvas, e)
})