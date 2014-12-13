import java.util.*;

public class Stat {

    private int[] data;
    
    public Stat()  {
      data = new int[6];
    }
    
    /**
     * Initialize the data array to the specified size.
     */
    public Stat(int s)  {
      data = new int[s];
    }

    /**
     * Returns a string that contains all the elements of the array.
     */
    public String toString() {
      String s = "";
      for(int x = 0; x < data.length; x++) {
        s += data[x];
      }
      return s;
    }
    
    /*
     * Go through the array and have the user enter 
     * values for each available space.
     */
    public void setValues() {
      Scanner scan = new Scanner( System.in );    
      for(int x = 0; x < data.length; x++) {  
        System.out.println("Enter a number for position " + x);
        int n = scan.nextInt();
        data[x] = n;
      }
    }

    /**
     * Return the sum of all the data in the array.
     */
    public int calcSum() {
      int a = 0;
      for(int x = 0; x < data.length; x++) {  
        a += data[x];
      }
      return a;
    }

    /**
     * Return the average of the data in the array.
     */
    public double calcAvg() {
      int a = 0;
      for(int x = 0; x < data.length; x++) {  
        a += data[x];
      }
      a = a / data.length; 
      return a;
    }

    /**
     * Return the smallest value in the array.
     */
    public int findMin() {
      int a = data[0];
      int b = 0;
      for(int x = 0; x < data.length - 1; x++) { 
        if (data[x] > data[x + 1]) {
          b = data[x + 1];
        }
        else {
          b = data[x];
        }
        if (a > b) {
          a = b;
        }
      }
      return a;
    }

    /**
     * Return the largest value in the array.
     */
    public int findMax() {
      int a = data[0];
      int b = 0;
      for(int x = 0; x < data.length - 1; x++) { 
        if (data[x] < data[x + 1]) {
          b = data[x + 1];
        }
        else {
          b = data[x];
        }
        if (a < b) {
          a = b;
        }
      }
      return a;
    }
    
    public int freq(int n) {
      int frequency = 0;
      for(int i=0; i < data.length; i++) {
        if (data[i] == n) {
          frequency++;
        }  
      }
      return frequency;
    }
    
    public boolean evenBalance() {
      int left = 0;
      int right = 0;
      if (data.length % 2 == 0) { //even
        for(int i=0; i < data.length/2; i++) {
          left += data[i];
        }
        for(int i=data.length - data.length/2; i < data.length; i++) {
          right += data[i];
        }
      }
      else { //odd
        for(int i=0; i < (data.length+1)/2; i++) {
          left += data[i];
        }
        for(int i=data.length - (data.length+1)/2; i < data.length; i++) {
          right += data[i];
        }        
      }
      if (left == right) 
        return true;
      else
        return false;
    }
    
    public int mode() {
      int guess = data[0];
      for(int i=0; i < data.length; i++) {
        if (freq(data[i]) > freq(guess)) {
          guess = data[i];
        }
      }
      return guess;
    }

    public static void main( String[] args ) {
/*
	int n;
	Stat s;
	Scanner scan = new Scanner( System.in );
	
	System.out.print("Number of entries: ");
	n = scan.nextInt();

	s = new Stat(n);

	s.setValues();
	System.out.println( "Data: " + s );
	System.out.println("Sum: " +  s.calcSum() );
	System.out.println("Average: " + s.calcAvg() );
	System.out.println("Min: " + s.findMin() );
	System.out.println("Max: " + s.findMax() );
*/
  Stat s = new Stat();
  System.out.println(s.toString());
  s.setValues();
  System.out.println(s.toString());
  System.out.println(s.calcSum());
  System.out.println(s.toString());
  System.out.println(s.calcAvg());
  System.out.println(s.toString());
  System.out.println(s.findMin());
  System.out.println(s.toString());
  System.out.println(s.findMax());
  System.out.println(s.toString());
  System.out.println(s.freq(3));
  System.out.println(s.evenBalance());
  System.out.println(s.mode());
  
    }
}
