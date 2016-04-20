var x = "global";
var f = function(){
    console.log("f");
};

var d = {
    x : 67,
    var2 : 'hello',
    f2 : function(){
	this.x = this.x+ 45;
	console.log(this.x);
    },
    f1 : function() {
	console.log("from d");
    }
};


/*

  Lunch - eat then trainor
  Train - finish reading
  home - Math
       - Dwyer
       - Finish whatever you haven't
       - dw
       - Trainor
*/

var makeInc = function(){
    var i = 0;
    return  function(){
	i = i +1;
	return i
    };
};

