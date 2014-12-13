public class Greeter {

	//Instance Variables
	private String message;
	
	//Methods
	public void setMessage( String m ) {
		message = m;
	}
	
	public void greet() {
		System.out.println( message );
	}
	
	public void greet(String name) {
		System.out.println( message + " " + name );
	}
	
	public void sayBye(String name) {
		String response;
		response = "Bye";
		System.out.println(response + " " + name);
	}
	
	public void addFive(int number) {
		int sum;
		sum = 5 + number;
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		int x;
		x = 90;
		
		//System.out.println( x * 17);
		
		Greeter g;
		Greeter bob;
		Greeter bye;
		bob = new Greeter();
		g = new Greeter();
		bye = new Greeter();
	
		bob.setMessage("Hello");
		g.setMessage( "Good New Everyone!");
		g.greet();
		
		bob.greet();
		bob.greet("Fred");
		
		bye.sayBye("James");
		g.addFive(3);
	}
}