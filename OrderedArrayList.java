import java.util.*;

public class OrderedArrayList {

  private ArrayList<Comparable> data;
  
  public OrderedArrayList() {
    data = new ArrayList<Comparable>();
    for (int i = 0; i < 10; i++) {
      data.add(i, i*3);
    }
  }
  
  public String toString() {
    String s = "";
    for (int i = 0; i < data.size(); i++) {
      s += data.get(i) + " ";
    }
    return s;
  }
  /*
    public void add(int number) {
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i) >= number) {
        data.add(i, number);
        //break; Used to exit loop
        return; //Used to exit a method
      }
    }
    data.add(number);
  }
  */  
  public void add(Comparable o) {
    for (int i = 0; i < data.size(); i++) {
      int compare = o.compareTo(data.get(i));
      if ((compare == 0) || (compare < 0)) {
        data.add(i, o);
        //break; Used to exit loop
        return; //Used to exit a method
      }
    }
    data.add(o);
  }
  /*
  public Comparable search(Comparable c) {
    for (int i = 0; i < data.size(); i++)
      if (data.get(i).compareTo(c) == 0)
        return i;
    return -1;
  }
  */
  public int search(Comparable c) {
    int low = 0;
    int high  = data.size() - 1;
    int middle = data.size() / 2;
    while (low < high) {
      int compare = data.get(middle).compareTo(c);
      if (compare == 0)
        return middle;
      else if (compare < 0) {
        low = middle + 1;
        middle = (low + high) / 2;
        //middle = high - ((high - middle) / 2); you failed this doesn't work
        //System.out.println("Less than \n Low: " + low + "\n High: " + high + "\n Middle: " + middle);
      }
      else {
        high = middle - 1;
        middle = (low + high) / 2;
        //middle = middle - ((middle - low) / 2); you failed this doesn't work
        //System.out.println("Greater than \n Low: " + low + "\n High: " + high + "\n Middle: " + middle);
      }
    }
    return -1;
  }
  
  public Comparable remove(int index) {
    return data.remove(index);
  }

  public Comparable get(int index) {
    return data.get(index);
  }
  
  public int size() {
    return data.size();
  }
  
  public static void main(String[] args) {
    OrderedArrayList oal = new OrderedArrayList();
   
    System.out.println(oal.toString());
    oal.add(8);
    System.out.println(oal.toString());
    System.out.println(oal.search(5));
    System.out.println(oal.search(8));
  }

}