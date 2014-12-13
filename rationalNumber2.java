public class rationalNumber2 {

  private int numerator, denominator;
  
  public rationalNumber2() {
  defaultFraction();
  }
  
  public void defaultFraction() {
    numerator = 0;
    denominator = 1;
  }
  
  public void displayFraction() {
    System.out.println(numerator + "/" + denominator);
  }
  
  public double floatValue() {
    return numerator * 1.0 / denominator;
  }
  
  public void multiply(rationalNumber2 x) {
    numerator = numerator * x.numerator;
    denominator = denominator * x.denominator;
  }
  
  public void add(rationalNumber2 x) {
    numerator = (numerator * x.denominator) + (x.numerator * denominator);
    denominator = (denominator * x.denominator);
    }
    
  public void subtract(rationalNumber2 x) {
    numerator = (numerator * x.denominator) - (x.numerator * denominator);
    denominator = (denominator * x.denominator);
    }  
      
  /*
  public void gcd() {
    if (denominator % numerator == 0) {
      System.out.println(numerator);
    }
    else {
      int counter = numerator;
      int d = denominator;
      int n = numerator;
      while (counter <= numerator) {
        if ((d/counter)%(n/counter) == 0) {
          System.out.println(counter);
        }
        else {
          d = d/counter;
          n = n/counter;
          counter--;
        }
      }
    }
  }
  */
    
  public int gcd() {
    int divisor = denominator;  //left of bracket thingy
    int dividend = numerator; //inside bracket thingy
    boolean calculate = true;
    while (calculate == true) {
      int remainder = dividend % divisor;
      if (remainder == 0) {
        return divisor;
      }
      else {
        dividend = divisor;
        divisor = remainder;
      }
    }
    return divisor;
  }  

  public String toString() {
    return numerator + " " + denominator;
  }
  
  public void reduce() {
    int common = gcd();
    System.out.println(common);
    numerator = numerator / common;
    denominator = denominator / common;
  }
    
  public rationalNumber2(int num, int den) {
    if (den == 0) {
      System.out.println("That is an invalid Denominator. Did you not pass high school math?");
      defaultFraction();
    }
    else {
      numerator = num;
      denominator = den;
      displayFraction();
    }
  }
  
  public static void main(String[] args) {
    rationalNumber2 x;
    rationalNumber2 y;
    x = new rationalNumber2(20,15);
    y = new rationalNumber2(4,5);
    rationalNumber2 z = new rationalNumber2(10,2);
    System.out.println(x.floatValue());
    /*
    x.add(y);
    x.displayFraction();
    */
    x.gcd();
    x.reduce();
    x.displayFraction();
    System.out.println(z.toString());
  } 

}