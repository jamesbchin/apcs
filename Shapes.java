public class Shapes {
    
    /*======== public static String line() ==========
      Inputs:  String c (single character String)
               int n 
      Returns: A String that contains n copies of c
      ex: Shapes.line( "^", 4 ); ==> "^^^^"
      ====================*/
    public static String line(String c, int n) {
	String s = "";
  for (int x = 0; x < n; x++) {
    s = s + c;
  }
	return s;
    }
    
    /*======== public static String box() ==========
      Inputs:  String c (single character)
               int rs
               int cs 
      Returns: A String made up of a rs x cs grid of c
      ex: Shapes.box("*", 2, 3) ==> "***
                                     ***"
     ====================*/
    public static String box(String c, int rs, int cs) {
	String s = "";
  for (int x = 0; x < cs; x++) {
    for (int y = 0; y < rs; y++) {
      s = s + c;
    }
    s = s + "\n";
  }
	return s;
    }


    /*======== public String tri1() ==========
      Inputs:  String c 
               int h 
      Returns: A "triangle" of c, h lines high
      ex: Shapes.tri1("|", 3); ==> "|
                                    ||
				    |||"
      ====================*/
    public static String tri1(String c, int h) {
	String s = "";
  for (int x = 0; x <= h; x++) {
    for (int y = 0; y < x; y++) {
      s = s + c;
    }
    s = s + "\n";    
  }
	return s;
    }

    /*======== public String tri2() ==========
      Inputs:  String c 
               int h 
      Returns: A differnt "triangle" of c, h lines high
      ex: Shapes.tri2("|", 3); ==> "  |
                                     ||
                                    |||"
      ====================*/
    public static String tri2(String c, int height){
  String s="";
  for (int x = 0; x <= height; x++) {
    for (int z = 0; z < height - x; z++) {
      s = s + " ";
    }
    for (int y = 0; y < x; y++) {
      s = s + c;
    }
    s = s + "\n";    
  }        
	return s;
    }

    /*======== public String tri3() ==========
      Inputs:  String c 
               int h 
      Returns: A differnt "triangle" of c, h lines high
      ex: Shapes.tri2("|", 3); ==> " |
                                    |||
                                   |||||"
      ====================*/
    public static String tri3(String c, int h) {
	String s = "";
    for (int x = 0; x <= h; x++) {
      //use (h * 2 - 1) to find the number of c to return
      for (int z = 0; z < h - x; z++) {
        s = s + " ";
      }   
      for (int y = 0; y < (x * 2 - 1); y++) {
        s = s + c;
      }  
      s = s + "\n";
    }
	return s;
    }


    /*======== public diamond() ==========
      Inputs:  String c 
               int h 
      Returns: A "diamond" of c, h lines high
      ex: Shapes.tri2("|", 5); ==> " |
                                    |||
				   |||||"
				    |||
				     |"
      ====================*/
    public static String diamond(String c, int h){
	String s = "";
  if (h % 2 == 0) {
  //even
    //top section
    for (int x = 0; x <= (h / 2); x++) {
      //use (h * 2 - 1) to find the number of c to return
      for (int z = 0; z < h / 2 - x; z++) {
        s = s + " ";
      }   
      for (int y = 0; y < (x * 2 - 1); y++) {
        s = s + c;
      }  
      s = s + "\n";
    }
    //top section end
    for (int x = 1; x < h; x++) {
      s = s + c;
    }
    s = s + "\n";
    //bottom section
    for (int x = 1; x <= (h / 2); x++) {
      //use (x * 2 - 1) to find the number of c to return
      for (int z = 0; z < (h / 2) - ((h / 2) - x); z++) {
        s = s + " ";
      }
      for (int y = 0; y < (h - 1) - (x * 2); y++) {
        s = s + c;
      }
      s = s + "\n";
    }
    //bottom section end
  }
  else {
  //odd
    //top section
    for (int x = 0; x <= ((h + 1) / 2); x++) {
      for (int z = 0; z < (h + 1) / 2 - x; z++) {
        s = s + " ";
      }   
      for (int y = 0; y < (x * 2 - 1); y++) {
        s = s + c;
      }  
      s = s + "\n";
    }
    //top section end
    //bottom section
    for (int x = 1; x <= ((h + 1) / 2); x++) {
      for (int z = 0; z < ((h + 1) / 2) - (((h + 1)/ 2) - x); z++) {
        s = s + " ";
      }
      for (int y = 0; y < ((h + 1) - 1) - (x * 2); y++) {
        s = s + c;
      }
      s = s + "\n";
    }    
  }
	return s;
    }
    
    public static void main(String[] args) {
	System.out.println("Line Test:");
	System.out.println(Shapes.line("^",10));
	
	System.out.println("Box Test:");
	System.out.println(Shapes.box("*", 5,4));
	System.out.println(Shapes.box("*", 4,5));
	System.out.println();
	
	System.out.println("Tri1 Test:");
	System.out.println(Shapes.tri1("|", 5));
	System.out.println();

	System.out.println("Tri2 Test:");
	System.out.println(Shapes.tri2("|", 5));
	System.out.println();

	System.out.println("Tri3 Test:");
	System.out.println(Shapes.tri3("|", 4));
	System.out.println();

	System.out.println("Diamond Test:");
	System.out.println(Shapes.diamond("|", 13));
  
	System.out.println("Diamond Test:");
	System.out.println(Shapes.diamond("|", 8));
    }
}
