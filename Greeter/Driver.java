
public class Driver {

    public static void main(String[] args){
	/*
	  we are declaring g to be a local
	  variable of type Greeter (which is the
	  class we defined). In java
	  we jave to say what type of stuff variables
	  hold 
	*/
	Greeter g;
	/* 1. allocate the memory for a new Greeter instance
	   2. set up the Greeter (java does this)
	   3. Return the memory address (location) for it
	   4. Store that address in g

	   g now stores a reference to the greeter
	   that is, the address of the greeter.
	   The greater isn't actually stuffed into g.
	*/
	g = new Greeter();
	System.out.println(g);

	// call the greet method on instance g
	g.greet();
	g.greet();
	//g.ungreet();
	

    }

}
