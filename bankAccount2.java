public class bankAccount2 {

  //Instance Variables
  public String name;
  public String password;
  public int pin;
  public int account;
  public double balance;
  
  //Constructor
  /*
  public bankAccount2(String n, String p, int pn, int a, double b) {
    name = n;
    password = p;
    pin = pn;
    account = a;
    balance = b;
  }
  */
  
  //Methods
  public void setName(String n) {
    name = n;
  }
  
  public void setPassword(String p) {
    password = p;
  }
  
  public void setPin(int pn) {
    pin = pn;
  }
  
  public void setAccount(int a) {
    account = a;
  }
  
  public void setBalance(double b) {
    balance = b;
  }
  
  public void printInformation() {
    check();
    System.out.println("Name: " + name);
    System.out.println("Password: " + password);
    System.out.println("Pin: " + pin);
    System.out.println("Account: " + account);
    System.out.println("Balance: " + balance);
  }
  
  public void deposit(double amount) {
    balance = balance + amount;
  }
  
  public void withdraw(double amount) {
    if (balance - amount < 0) {
      System.out.println("You don't have enough money.");
    }
    else {
      System.out.println("You have enough money.");
      balance = balance - amount;
    }
  }
  
  public void check() {
    if ((account < 100000000) || (account > 999999998)) {
      System.out.println("This number is invalid");
      account = 999999999;
    }
    
    if ((pin < 1000) || (pin > 9998)) {
      System.out.println("This number is invalid");
      pin = 9999;
    }
  }
  
  public void authentication(int A, String P) {
  String s = new String(P);
    System.out.println((A == account) && (s.equals(password)));
  }
    
  
  //Main Class
  public static void main(String[] args) {
    
    bankAccount2 run;
    run = new bankAccount2();
  
    /*
    run.setName("James Chin");
    System.out.println(run.name);
    */
    
    run.setName("James");
    run.setPassword("password");
    run.setPin(2453);
    run.setAccount(123456789);
    run.setBalance(100.00);
   
    run.printInformation();
    
    run.deposit(50.00);
    
    run.printInformation();
    
    run.withdraw(50.00);
    
    run.printInformation();
    
    run.authentication(123456789,"password");
  }
  
 }