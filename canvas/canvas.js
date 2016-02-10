
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
var button = document.getElementById("clear");
var button2 = document.getElementById("reset");

/*
ctx.beginPath();
ctx.moveTo(250,250);
ctx.quadraticCurveTo(250,250,400,250);
ctx.quadraticCurveTo(250,250,200,300);
//ctx.closePath();
ctx.stroke();
ctx.fill();
*/

var clear = function(e){
    e.preventDefault();
    ctx.clearRect(0,0,500,500);
    resetPath(e);
};

var x,y;
var dot = function(e){
    e.preventDefault();
    ctx.beginPath()
    ctx.arc(e.offsetX,e.offsetY,5,0, Math.PI*2);
    ctx.fill();
    ctx.moveTo(x,y);
    ctx.lineTo(e.offsetX,e.offsetY);
    ctx.stroke();
    x=e.offsetX;
    y=e.offsetY;
}

var resetPath = function(e){
    x = undefined;
    y = undefined;
}


button.addEventListener("click", clear);
button2.addEventListener("click",resetPath);
c.addEventListener("click", dot);
