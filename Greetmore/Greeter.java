import java.io.*;


public class Greeter {

    private String greeting;

    public Greeter(String g) {
	greeting = g;
    }
    
    public Greeter() {
	greeting = "Sup";
    }
	
    public String greetperson(String name) {
	return greeting + ' ' + name;
    }

    public String greetloud(String name) {
	return greetperson(name).toUpperCase();
    }
}
