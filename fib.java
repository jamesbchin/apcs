public class fib {

  public int foo(int k) {
    if (k <= 1) return 1;
    return foo(k - 1) + foo(k - 2);
  }
        
  public static void main(String[] args) {
    fib f = new fib();
    for (int i = 0; i < 10; i++)
      System.out.println(f.foo(i));
  }

}