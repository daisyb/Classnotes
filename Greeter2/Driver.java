public class Driver {
    public static void main(String[] args){
	Greeter g1 = new Greeter();
	Greeter g2 = new Greeter();
	g1.greet();
	//g1.ungreet();
	g2.greet();
	//g2.ungreet();
	g1.greeting = new String("Sup!");
	g1.greet();
    }

}
