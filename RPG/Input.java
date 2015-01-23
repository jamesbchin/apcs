import java.util.*;

public class Input {
  public static void main(String[] args) {
  
    Scanner s = new Scanner(System.in);
    int x;
    String t;
    
    System.out.print("Enter a string: ");
    t = s.nextLine();
    System.out.print("Enter an int: ");
    x = s.nextInt();
    System.out.println(t);
    System.out.println(x);
  }
}
