public class SuperArray2 {

  //Instance Variables
  private int length;
  private Object[] array;
  
  //Methods
  public SuperArray2() {
    length = 10;
    array = new Object[10];
    for (int i = 0; i < length; i++) {
      array[i] = i + 1;
    }
  }
  
  public SuperArray2(int size) {
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
  
  public int size() {
    return length;
  }
  
  public Object get(int index) {
    if (index < length) {
      return array[index];
    }
    else {
      return null;
    }
  }
  
  public void add(Object o, int index) {
    if (index >= 0) {
      if (index >= length) {
        this.add(o);
      }
      else {
        this.resize();
        int left = length - index; //the amount of numbers that need to shift
        for (int i = 0; i < left; i++) {
          array[length - i] = array[length - i - 1];
        }
        array[index] = o;
        length += 1;
      }
    }
  }
  
  public Object remove(int index) {
    Object old = array[index];
    if ((index < 0) || (index >= length)) {
      return null;
    }
    else {
      int move = length - 1 - index;
      for (int i = 0; i < move; i++) {
        array[index + i] = array[index + 1 + i];
      }
      length -= 1;
      array[length] = null;
    }
    return old;
  }
  
  public Object set(Object o, int index) {
    if ((index > 0) && (index <= length)) {
      Object replacedValue = array[index];
      array[index] = o;
      return replacedValue;
    }
    else 
      return null;
  }
  
  public static void main(String[] args) {
    SuperArray2 a = new SuperArray2();
    SuperArray2 b = new SuperArray2(5);
    
    System.out.println(a);
    System.out.println(b);
    
    System.out.println("Size of A: " + a.size());
    System.out.println("Size of B: " + b.size());
    
    System.out.println(a.get(0));
    
    a.add("hi",3);
    System.out.println(a);
    
    a.set("hello",3);
    System.out.println(a);
    
    a.remove(3);
    System.out.println(a);
    
    System.out.println("");
    System.out.println("RAWR!");
    System.out.println("meow :3");
  }
}