/*========== Sort_Final.java ==========

  Class used to test various Sort_Finaling algorithms.
  The constructor will create an array of ints and then
  populate them with random values.
  
  The class also contains variables to keep track
  of the number of swaps and comparisons performed
  for a given Sort_Final.

  Complete bubble(), selection() and insertion()
jdyrlandweaver
=========================*/

import java.io.*;
import java.util.*;

public class Sort_Final {

    public static int DEFAULT_SIZE = 1000;

    private int[] list;
    private int swaps;
    private int comps;
  
    public Sort_Final() {
	list = new int[ DEFAULT_SIZE ];
	swaps = comps = 0;
	populate();
    }

    public Sort_Final(int size) {
	list = new int[size];
	swaps = comps = 0;
	populate();
    }


    /*======== public void populate()) ==========
      Inputs:   
      Returns: 
      
      populates the list with random ints in the 
      range [0, list.length)
      
      12/13/11 09:15:54
      jdyrlandweaver
      ====================*/
    public void populate() {

	Random r = new Random();
	for (int i=0; i<list.length; i++)
	    list[i] = r.nextInt() % list.length;
    }

    /*======== public void duplicate () ==========
      Inputs:  Sort_Final s
               int size 
      Returns: 

      Copies size elements from the list of Sort_Final s
      to the calling Sort_Final object
      
      12/13/11 09:16:50
      jdyrlandweaver
      ====================*/
    public void duplicate (Sort_Final s, int size) {

	for (int i=0; i<size; i++)
	    list[i] = s.list[i];
    }

    public int size() {
	return list.length;
    }

    public String toString() {
	String s = "";
	for (int i=0; i<list.length - 1; i++)
	    s = s + list[i] + ", ";
	return s + list[list.length-1];
    }

    public void printStats() {

	System.out.println("\tSwaps: " + swaps + 
			   "\n\tComps: " + comps);
    }

    /*======== public boolean isSort_Finaled()) ==========
      Inputs:   
      Returns: true if the list is Sort_Finaled
               false if the list is unSort_Finaled

      12/13/11 09:17:36
      jdyrlandweaver
      ====================*/
    public boolean isSort_Finaled() {
	for (int i=0; i<list.length - 1; i++)
	    if (list[i] > list[i+1])
		return false;
	return true;
    }
   
    /*======== public void swap() ==========
      Inputs:  int a
               int b  
      Returns: 
      
      Swaps the values at postitons a and b int list

      12/13/11 09:18:09
      jdyrlandweaver
      ====================*/
    public void swap(int a, int b) {
	int c = list[a];
	list[a] = list[b];
	list[b] = c;
	swaps++;
    }

    /*======== public long bubble()) ==========
      Inputs:   
      Returns: The amount of time, in miliseconds
               the Sort_Final took to complete

      Performs a bubble Sort_Final on list.
      Keeps track of swaps and comps
      
      Use System.currentTimeMillis() to get the 
      current time in milliseconds

      12/13/11 09:19:22
      jdyrlandweaver
      ====================*/
public long bubble() {
    long time = System.currentTimeMillis();
    int high = size();
    boolean lastSwap = false;
    while (high > 0) {
    	for (int i = 0; i < high-1; i++) {
   	 comps++;
   	 if (list[i] > list[i+1])
   	 	swap(i, i+1);
   	 	if (i == high - 2)
   		 lastSwap = true;
    	}
    	if (lastSwap == true) {
   	 lastSwap = false;
   	 high--;
    	}
    	else
   	 high = high - 2;
    }
    return System.currentTimeMillis() - time;
	}

    /*======== public long selection()) ==========
      Inputs:   
      Returns: The amount of time, in miliseconds
               the Sort_Final took to complete

      Performs a selection Sort_Final on list.
      Keeps track of swaps and comps
      
      Use System.currentTimeMillis() to get the 
      current time in milliseconds

      12/13/11 09:22:07
      jdyrlandweaver
      ====================*/
public long selection() {
    long b = System.currentTimeMillis();
    for (int i = 0; i < list.length - 1; i++){
        	int index = i;
        	for (int j = i + 1; j < list.length; j++){
            	if (list[j] < list[index]) {
                	int smaller = list[j];
   	 	list[j]=list[index];
   	 	list[index]=smaller;
   	 	swaps++;
   	 }
   	 comps++;
    	}
    	list[i]=list[index];
    	}
    long e = System.currentTimeMillis();
    return e-b;
	}

    /*======== public long insertion()) ==========
      Inputs:   
      Returns: The amount of time, in miliseconds
               the Sort_Final took to complete

      Performs an insertion Sort_Final on list.
      Keeps track of swaps and comps
      There are no true swaps only shifts, but 
      a swap is 3 assignments, and a shift is 1.
      Use math to figure out how they can be equated.

      Use System.currentTimeMillis() to get the 
      current time in milliseconds

      12/13/11 09:23:06
      jdyrlandweaver
      ====================*/
  public long insertion() {
    long startTime = System.currentTimeMillis();
      ArrayList newList = new ArrayList();
       
      for (int i = 0; i < list.length; i++) {
       newList.add(i, null);
      }

      for (int i = 0; i < list.length; i++) {
        newList.set(i, list[i]);
      }
      
      for (int i = 0; i < newList.size(); i++) {
        int beingSorted = (int)newList.get(i);
        int counter = 0;
        while (beingSorted > (int)newList.get(counter)) {
          counter++;
        }
        newList.remove(i);
        newList.add(counter, beingSorted);
      }
      
      for (int i = 0; i < list.length; i++) {
        list[i] = (int)newList.get(i);
      }
    
    return -1;
  }


    public static void main(String[] args) {

	//change this value to get more significant time results
	int x = 10;

	Sort_Final b = new Sort_Final(x);
	Sort_Final b2 = new Sort_Final(x);
	Sort_Final s = new Sort_Final(x);
	Sort_Final i = new Sort_Final(x);

	b2.duplicate(b, b2.size());
	s.duplicate(b, s.size());
	i.duplicate(b, i.size());

	System.out.println("Bubble Sort_Final:");
	System.out.println("\tTime:" + b.bubble());
	if ( b.isSort_Finaled() ) 
	    System.out.println("Bubble Sort_Final: SUCCESS");
	else
	    System.out.println("Bubble Sort_Final: FAIL");
	b.printStats();

	System.out.println("Selection Sort_Final:");
	System.out.println("\tTime:" + s.selection());
	if ( s.isSort_Finaled() ) 
	    System.out.println("Selection Sort_Final: SUCCESS");
	else
	    System.out.println("Selction Sort_Final: FAIL");

	s.printStats();

	System.out.println("Insertion Sort_Final:");
	System.out.println("\tTime:" + i.insertion());
	if ( i.isSort_Finaled() ) 
	    System.out.println("Insertion Sort_Final: SUCCESS");
	else
	    System.out.println("Insertion Sort_Final: FAIL");
	i.printStats();

    }
}