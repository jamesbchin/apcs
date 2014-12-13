public class Casting {
  public static void main(String[] args) {
    char c = (char)'%';
    byte b = (byte)65;
    short s = (short)94;
    int i = (int)506;
    long l = (long)3084;
    float f = (float).2;
    double d = (double)1947.24;
    
    System.out.println(c);
    System.out.println( (char) b);
    System.out.println( (double) s);
    System.out.println(l);
    System.out.println(f);
    System.out.println( (int) d);
    System.out.println(d);
    System.out.println( (byte)1000); //LOLOLOLOLOLOLOLOL
    
    Object o = new String("hello");
    String t = (String)o;
    //Integer j = (Integer)o; //< doesn't work
    //System.out.println( (String)o.toUpperCase() ); //< doesn't work either
    // "Type Casting is weaker than the dot"
    System.out.println( ((String)o).toUpperCase() ); //< this does work
  }
}