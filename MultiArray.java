public class MultiArray {
  
  int[][] array = new int[4][3];
  
  public void populate() {//start and finish is inclusive
    int position = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        array[i][j] = position;
        position++;
      }
    }
  }
  
  public String toString() {
    String s = "";
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        s += array[i][j] + " ";
      }
      s += "\n";
    }
    return s;
  }
  
  public static void main(String[] args) {
    MultiArray ma = new MultiArray();
    System.out.println(ma.toString());
    ma.populate();
    System.out.println(ma.toString());
  }
  
}