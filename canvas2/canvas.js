
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
var clear = document.getElementById("clear");
var start = document.getElementById("start");
var stop = document.getElementById("stop");
var aniID;

ctx.fillStyle = "blue";

var outside = function(){
    window.cancelAnimationFrame(aniID);
    var radius = 0;
    var dr;
    var drawC = function(){
	if (radius*2 >= c.width || radius*2 >= c.height){
	    dr = -1;
	}

	if (radius <= 0){
	    dr = 1;
	}    

	ctx.clearRect(0,0,c.width,c.height);

	ctx.beginPath();
	ctx.arc(250,250,radius,0,2*Math.PI);
	ctx.fill();
	radius += dr;
	aniID = window.requestAnimationFrame(drawC);

	console.log(aniID);
    }
    drawC();

}
clear.addEventListener("click",function(){
    ctx.clearRect(0,0,c.width,c.height);
});
start.addEventListener("click", outside);
stop.addEventListener("click", function(){
    window.cancelAnimationFrame(aniID);
});
