public class Game {
  
  public static void main(String[] args) {
  /*
    Character c = new Character();
    c.attack();
  */
  
    Mage m = new Mage();
    Character c = new Character();
    Warrior w = new Warrior();
    
    m.attack();
    c.attack();
    w.attack();
    System.out.println(w.toString());
    System.out.println(c.toString());
    System.out.println(m.toString());
  }
  
}