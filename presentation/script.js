var index = 1;

var bgImg = function bg(link){
   document.body.style
	.backgroundImage = "url('" + link + "')";
};

var loadSlide = function(index){
    bgImg("slides/s" + index + ".jpg");
};

document.getElementById("left")
    .addEventListener("click", function(e){
	if (index > 1){
	    index--;
	} else {
	    index = 7;
	}
	loadSlide(index);	
    });


document.getElementById("right")
    .addEventListener("click", function(e){
	if (index < 7){
	    index++;
	} else {
	    index = 1;
	}
	loadSlide(index);
    });



loadSlide(index);

