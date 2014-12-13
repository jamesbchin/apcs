public class rationalNumber {

  public int numerator, denominator;
  
  public rationalNumber() {
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
  
  public void multiply(rationalNumber x) {
    numerator = numerator * x.numerator;
    denominator = denominator * x.denominator;
  }
  
  public rationalNumber(int num, int den) {
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
    rationalNumber x;
    rationalNumber y;
    x = new rationalNumber(2,3);
    y = new rationalNumber(4,3);
    System.out.println(x.floatValue());
    x.multiply(y);
    x.displayFraction();
  }

}