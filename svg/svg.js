
var pic = document.getElementById("vimg");

var drawC = function(x,y){
    var c = document.createElementNS("http://www.w3.org/2000/svg","circle");
    c.setAttribute("cx",x);
    c.setAttribute("cy",y);
    c.setAttribute("r","25");
    c.setAttribute("fill","red");
    c.setAttribute("stroke","black");

    pic.appendChild(c);
}


drawC(0,0);

var clicked = function(e){
    //e.preventDefault();
    if (e.toElement == pic){
	drawC(e.offsetX, e.offsetY);
    } else {
	console.log(this);
	this.setAttribute("fill","yellow");
    }
}

pic.addEventListener("click",clicked);

