public class Game {
  public static void main(String[] args) {
    Soldier j = new Soldier("James");
    Soldier b = new Soldier("Bob");
    Doctor s = new Doctor("Steve");
    
    System.out.println(j.toString());
    System.out.println(b.toString());
    
    j.attack(b);
    
    System.out.println(j.toString());
    System.out.println(b.toString());   

    s.attack(b);
    
    System.out.println(b.toString());  
  }
}