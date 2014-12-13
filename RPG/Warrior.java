public class Warrior extends Character {
  
  public Warrior() {
    super("Bob");
    xp = 100;
    health = 10;
    damage = 18;
  }

  public void attack() {
    System.out.println("BAM!");
  }
  
}