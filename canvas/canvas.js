
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
var button = document.getElementById("clear");

ctx.fillStyle = "#0000ff";
ctx.fillRect(50,50,100,200);
			      
ctx.beginPath();
ctx.arc(200, 300, 50, 0, Math.PI*2);
ctx.fill();

var clear = function(e){
    e.preventDefault();
    ctx.clearRect(0,0,500,500);
    
};

var draw = function(e){
    e.preventDefault();
    ctx.beginPath();
    ctx.arc(e.offsetX,e.offsetY,2,0, Math.PI*2);
}

button.addEventListener("click", clear);
c.addEventListener("click", draw);

