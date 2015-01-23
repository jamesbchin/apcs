import java.util.*;

public class quotes {

  String[] thingy = {
  "hello",
  "wassup"
  };

  public String randomQuote() {
    Random r = new Random();
    int x = r.nextInt(thingy.length);
    return thingy[x];
  }
  
  public String toString() {
    String s = "";
    for (int i = 0; i < thingy.length; i++){
      s += thingy[i] + "\n";
    }
    return s;
  }
  
  public static void main(String[] args) {
    quotes q = new quotes();
    
    System.out.println(q);
    System.out.println(q.randomQuote());
  }

}
