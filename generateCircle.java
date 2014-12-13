public class generateCircle {

  String[][] array;
  
  int radius;
  int diameter;
  double threshold;
  int center;
  
  public generateCircle() {
    radius = 5;
    center = 4;
    threshold = 0.25;
    diameter = (radius * 2) - 1;
    array = new String[diameter][diameter];
  }
  
  public generateCircle(int r, double t) {
    radius = r;
    center = r - 1;
    threshold = t;
    diameter = (radius * 2) - 1;
    array = new String[diameter][diameter];
  }
  
  public void fillCoordinates() {
    for (int i = 0; i < diameter; i++) {
      for (int j = 0; j < diameter; j++) {
        array[i][j] = j + "," + i;
      }
    }
  }
  
  public String toString() {
    String s = "";
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        s += array[i][j] + " ";
      }
      s += "\n";
    }
    return s;
  }
  
  public void createCircle() {
    for (int i = 0; i < array.length; i++) { //x value
      for (int j = 0; j < array[i].length; j++) { //y value
        if (abs(radius  - (Math.sqrt(((i - center)*(i - center)) + ((j - center)*(j - center))))) < threshold) {
          array[i][j] = "1";
        }
        else {
          array[i][j] = " 0";
        }
      }
    }
  }
  
  public static void main(String[] args) {
    generateCircle c = new generateCircle();
    
    System.out.println(c.toString());
    c.fillCoordinates();
    System.out.println(c.toString());
    c.createCircle();
    System.out.println(c.toString());
    
  }

}