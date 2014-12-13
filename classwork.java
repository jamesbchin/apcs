public class classwork {
  
  public static void main(String[] args) {
  
	String a = new String("hello");
	String b = new String("hello");
  String c = b;
  
  int x = 2;
  int y = 3;
  
  System.out.println(x == y);
  System.out.println(x > y);
  System.out.println(x < y);
  
  System.out.println(a);
	System.out.println(b);
	System.out.println(a == b);
  System.out.println(b == c);
  
  String s = new String("hello");
	System.out.println(s.equals("hello"));
  
  }

}