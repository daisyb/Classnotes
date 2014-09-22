public class Driver {
    public static void main(String[] args){
	Greeter g1 = new Greeter("Hey");
	System.out.println(g1.greetperson("Timmy"));
	Greeter g2 = new Greeter();
	System.out.println(g2.greetperson("Sarah"));
	System.out.println(g2.greetloud("John"));
	
    }
}
