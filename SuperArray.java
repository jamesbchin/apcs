public class SuperArray {

  //Instance Variables
  private int length;
  private Object[] array;
  
  //Methods
  public SuperArray() {
    length = 10;
    array = new Object[10];
  }
  
  public SuperArray(int size) {
    length = size;
    array = new Object[size];
  }
  
  public String toString() {
    String s = "";
    for (int i = 0; i < length; i++) {
      s += array[i] + " ";
    }
    return s;
  }
  
  public void resize() {
    Object[] newArray = new Object[length + 35];
    for (int i = 0; i < length; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }
  
  public void add(Object o) {
    if (length == array.length)
      this.resize();
    array[length] = o;
    length += 1;
  }
  
  public static void main(String[] args) {
    SuperArray a = new SuperArray();
    SuperArray b = new SuperArray(5);
    
    System.out.println(a);
    System.out.println(b);
    
    System.out.println("");
    System.out.println("RAWR!");
    System.out.println("meow :3");
  }
}