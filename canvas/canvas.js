
var c = document.getElementById("myCanvas");
console.log(c);
var ctx = c.getContext("2d");
var button = document.getElementById("clear");

// ctx.fillStyle = "#0000ff";
// ctx.fillRect(50,50,100,200);
			      
// ctx.beginPath();
// ctx.arc(200, 300, 50, 0, Math.PI*2);
// ctx.fill();

ctx.beginPath();
ctx.moveTo(250,250);
ctx.quadraticCurveTo(250,250,400,250);
ctx.quadraticCurveTo(250,250,200,300);
//ctx.closePath();
ctx.stroke();
ctx.fill();

var clear = function(e){
    e.preventDefault();
    ctx.clearRect(0,0,500,500);
    
};
/*
var draw = function(e){
    e.preventDefault();
    //ctx.fillRect(e.offsetX,e.offsetY,100,100);
    ctx.beginPath();
    ctx.arc(e.offsetX,e.offsetY,2,0, Math.PI*2);
    ctx.fill();
}
*/
    ctx.beginPath();
var dot = function(e){
    e.preventDefault();
    ctx.lineTo(e.offsetX,e.offsetY);
    ctx.arc(e.offsetX,e.offsetY,10,0, Math.PI*2);
    ctx.fill();
    ctx.moveTo(e.offsetX,e.offsetY);
}
button.addEventListener("click", clear);
c.addEventListener("click", dot);

