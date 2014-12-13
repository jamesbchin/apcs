import java.util.*;
import java.io.*;

public class wordSearch {

/*
  Word Search
  Created by Julia Hou and James Chin
*/

  //Declare Board Array
  String [][] board;
  
  //Array filled with words
  ArrayList<String> words = new ArrayList<String>();
  
  //Size of board
  int size;  
  int col;
  int row;
  
  public ArrayList<String> loadDictionary() {
    String s = "zzz";
    ArrayList<String> dictionary = new ArrayList<String>();
     
    try {
      FileReader f = new FileReader("wordlist.txt");
      BufferedReader b = new BufferedReader(f);
   
      while( s != null ) {
        s = b.readLine();
        if ( s != null )
          dictionary.add(s);
      }
    }
    catch (IOException e) {}
   
    return dictionary;
  }
  
  //Constructors
  public wordSearch() {
    size = 10;
    board = new String[10][10];
  }
  
  public wordSearch(int s) {
    size = s;
    board = new String[size][size];
  }
  
  public wordSearch(int c, int r) {
    col = c;
    row = r;
    if (c >= r)
      size = row;
    else
      size = col;
    board = new String[col][row];
  }
  
  //Credits to Alvin Lin, pauses for a given number of milliseconds
  public static void pause(int ms) {
    try {
      Thread.sleep(ms);
    } catch (Exception e) {
    }
  }
  
  //Credits to Alvin Lin, just plain coolness
  public static void out(String str) {
    for (int i = 0; i < str.length(); ++i) {
      System.out.print(str.charAt(i));
      pause(5);
    }
    System.out.print("\n");
  }
  
  //toString Method
  public String toString() {
    String s = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        s += board[i][j] + " ";
      }
      s += "\n";
    }
    s += "\n";
    s += this.displayWords();
    return s;
  }
  
  //Display Words Method
  public String displayWords() {
    String s = "Words in Grid: \n";
    for (int i = 0; i < words.size(); i++) {
      s += words.get(i).toUpperCase() + "\n";
    }
    return s;
  }
  
  //Output String Array in String form
  public String displayStringArray(String[] array) {
    String string = "";
    for (int k = 0; k < array.length; k++) {
      string += array[k] + "\n";
    }
    return string;
  }  
  
  //Output Int Array in String form
  public String displayStringArray(int[] array) {
    String string = "";
    for (int k = 0; k < array.length; k++) {
      string += array[k] + "\n";
    }
    return string;
  }
  
  //Random Letter Generator Method
  public String randomLetter() {
    Random r = new Random();
    int randomNumber = r.nextInt(26) + 65;
    return String.valueOf((char) randomNumber);
  }
  
  //Add Word Vertically
  public boolean addWordV(int row, int col, String s) {
    s = s.toUpperCase();
    String[] chars = s.split("");
    boolean fit = true;
    //cat
    if ((row < 0) || (row >= size) || (col < 0) || (col >= size))
      return false;
    if ((row-chars.length+2) >= 0) {
        for (int x = 1; x < chars.length; x++) {
      if ((board[row-x+1][col] != "-") && !board[row-x+1][col].equals(chars[x]))
          fit = false;
        }
        if (fit == true) {
      for (int i = 1; i < chars.length; i++) {
          board[row-i+1][col] = chars[i];
      }
        }
    }
    else {
        fit = false;
    }
    if (fit == false) {
        fit = true;
        if ((row+chars.length-1) <= size) {
      for (int y = 1; y < chars.length; y++) {
          if ((board[row+y-1][col] != "-") && !board[row+y-1][col].equals(chars[y]))
        fit = false;
      }
      if (fit == true) {
          for (int j = 1; j < chars.length; j++) {
        board[row+j-1][col] = chars[j];
          }
      }
        }
        else {
      fit = false;
        }
    }
    return fit;
  }

  //Add Word Horizontally 
  public boolean addWordH(int row, int col, String s) {
    s = s.toUpperCase();
    String[] chars = s.split("");
    boolean fit = true;
    if ((row < 0) || (row >= size) || (col < 0) || (col >= size))
      return false;
      if ((col+chars.length-1) <= size) {
      for (int y = 1; y < chars.length; y++) {
          if ((board[row][col+y-1] != "-") && !board[row][col+y-1].equals(chars[y]))
        fit = false;
      }
      if (fit == true) {
          for (int j = 1; j < chars.length; j++) {
        board[row][col+j-1] = chars[j];
          }
      }
        }
        else {
      fit = false;
        }
    if (fit == false) {
        fit = true;
        if ((col-chars.length+2) >= 0) {
        for (int x = 1; x < chars.length; x++) {
      if ((board[row][col-x+1] != "-") && !board[row][col-x+1].equals(chars[x]))
          fit = false;
        }
        if (fit == true) {
      for (int i = 1; i < chars.length; i++) {
          board[row][col-i+1] = chars[i];
      }
        }
    }
    else {
        fit = false;
    }
    }
    return fit;
  }
  
  //Add Word Horizontally
  public boolean addWordD(int row, int col, String s) {
    s = s.toUpperCase();
    String[] chars = s.split("");
    boolean fit = true;
    if ((row < 0) || (row >= size) || (col < 0) || (col >= size))
      return false;
    if ((row-chars.length+1) >= 0 && (col-chars.length+1) >= 0) {
        for (int x = 1; x < chars.length; x++) {
      if ((board[row-x+1][col-x+1] != "-") && !board[row-x+1][col-x+1].equals(chars[x]))
          fit = false;
        }
        if (fit == true) {
      for (int i = 1; i < chars.length; i++) {
          board[row-i+1][col-i+1] = chars[i];
      }
        }
    }
    else {
        fit = false;
    }
    if (fit == false) {
        fit = true;
        if ((row-chars.length+1) >= 0 && (col+chars.length) <= size) {
      for (int y = 1; y < chars.length; y++) {
          if ((board[row-y+1][col+y] != "-") && !board[row-y+1][col+y].equals(chars[y]))
        fit = false;
      }
      if (fit == true) {
          for (int j = 1; j < chars.length; j++) {
        board[row-j+1][col+j] = chars[j];
          }
      }
        }
        else {
      fit = false;
        }
    }
    if (fit == false) {
        fit = true;
        if ((row+chars.length) <= size && (col-chars.length+1) >= 0) {
      for (int w = 1; w < chars.length; w++) {
          if ((board[row+w][col-w+1] != "-") && !board[row+w][col-w+1].equals(chars[w]))
        fit = false;
      }
      if (fit == true) {
          for (int k = 1; k < chars.length; k++) {
        board[row+k][col-k+1] = chars[k];
          }
      }
        }
        else {
      fit = false;
        }
    }
    if (fit == false) {
        fit = true;
        if ((row+chars.length) <= size && (col+chars.length) <= size) {
      for (int z = 1; z < chars.length; z++) {
          if ((board[row+z][col+z] != "-") && !board[row+z][col+z].equals(chars[z]))
        fit = false;
      }
      if (fit == true) {
          for (int m = 1; m < chars.length; m++) {
        board[row+m][col+m] = chars[m];
          }
      }
        }
        else {
      fit = false;
        }
    }
    return fit;
  }
  
  //Add Words Method
  public void addWords(int n) {
    Random r = new Random();
    boolean fit = false;
    int x,y;
    for (int i = 0; i < n; i++) {
      int ran = r.nextInt(loadDictionary().size()); 
      String s = loadDictionary().get(ran);
      while (s.length() > size) {
        ran = r.nextInt(loadDictionary().size()); 
        s = loadDictionary().get(ran);        
      }
      words.add(s);
      loadDictionary().remove(ran);
    }
    for (int i = 0; i < words.size(); i++) {
      while (fit == false) {
        x = r.nextInt(size);
        y = r.nextInt(size);
        int random = r.nextInt(6);
        if (random == 0) {
          if (addWordH(x,y,words.get(i)) == true) 
            fit = true;
          else if (addWordV(x,y,words.get(i)) == true)
            fit = true;
          else if (addWordD(x,y,words.get(i)) == true)
            fit = true;
        }
        else if (random == 1) {
          if (addWordH(x,y,words.get(i)) == true) 
            fit = true;
          else if (addWordD(x,y,words.get(i)) == true)
            fit = true;
          else if (addWordV(x,y,words.get(i)) == true)
            fit = true;
        }
        else if (random == 2) {
          if (addWordD(x,y,words.get(i)) == true)
            fit = true;
          else if (addWordH(x,y,words.get(i)) == true) 
            fit = true;
          else if (addWordV(x,y,words.get(i)) == true)
            fit = true;
        }
        else if (random == 3) {
          if (addWordD(x,y,words.get(i)) == true)
            fit = true;
          else if (addWordV(x,y,words.get(i)) == true)
            fit = true;  
          else if (addWordH(x,y,words.get(i)) == true) 
            fit = true;      
        }
        else if (random == 4) {
          if (addWordV(x,y,words.get(i)) == true)
            fit = true;  
          else if (addWordD(x,y,words.get(i)) == true)
            fit = true;
          else if (addWordH(x,y,words.get(i)) == true) 
            fit = true;  
        }
        else if (random == 5) {
          if (addWordV(x,y,words.get(i)) == true)
            fit = true; 
          else if (addWordH(x,y,words.get(i)) == true) 
            fit = true;   
          else if (addWordD(x,y,words.get(i)) == true)
            fit = true;
        }
      }
      fit = false;
    }  
  }
  
  //Fill In Method
  public void fillGrid() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == "-")
          board[i][j] = this.randomLetter();
      }
    }
  }
  
  //Fill In Method But With Anything
  public void fillGrid(String s) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = s;
      }
    }
  }
  
  //Main Method
  public static void main(String[] args) {
    System.out.println("Welcome to the JJ Word Search!");
    System.out.println("------------------------------");
    System.out.println("");
    Scanner s = new Scanner(System.in);
    System.out.print("Enter a size: ");
    int size = s.nextInt();
    //Declare Board Class
    wordSearch w = new wordSearch(size);
    
    //Other Stuff
    /*System.out.println(w.displayWords());
    System.out.println(w.toString());
    w.addWordV(10,6,"CATS");
    w.addWordV(3,4,"HELLO");
    System.out.println(w.toString());
    w.fillGrid();
    w.out(w.toString());*/
    System.out.print("Enter a number of words: ");
    int num = s.nextInt();
    w.fillGrid("-");
    w.addWords(num);
    System.out.println("");
    System.out.println("Answer:");
    System.out.println("");
    System.out.println(w);
    System.out.println("");
    w.fillGrid();
    System.out.println("");
    out(w.toString());
  
  }
  
}