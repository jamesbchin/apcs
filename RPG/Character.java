public class Character {

  // Variables
  int health;
  int xp;
  String name;
  int damage;
  // End Variables
  
  // Constructor
  public Character() {
    name = "James";
  }
  // End Constructor
  
  public Character(String n) {
    name = n;
  }
    
  // Attack Method
  public void attack() {
    System.out.println("BOOM!");
  }
  // End Attack Method

  public String toString() {
    String s = "";
    s += "Name: " + name + "\n";
    s += "Experience: " + xp + "\n";
    s += "Health: " + health + "\n";
    s += "Damage: " + damage;
    return s;
  }
  
}