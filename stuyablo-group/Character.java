import java.util.ArrayList;

public class Character {

  //variables
  String name;
  int maxHealth;
  int health;
  int attack;
  int defense;
  int intelligence;
   
  ArrayList<String> inventory = new ArrayList<String>();
   
  //Constructors
  public Character(String n) {
    name = n;
    maxHealth = 75;
    health = 75;
    defense = 10;
    intelligence = 10;
    attack = 20;
    for (int i = 0; i < 5; i++) {
      inventory.add("food");
    }
    inventory.add("rock");
  }
  
  public Character() {
    name = "Default";
    maxHealth = 75;
    health = 75;
    defense = 10;
    intelligence = 10;
    attack = 20;
    for (int i = 0; i < 5; i++) {
      inventory.add("food");
    }
    inventory.add("rock");
  }
  
  //Methods
  public String toString() {
    String s = "";
    s += "Name: " + name + "\n";
    s += "Health: " + health + "\n";
    s += "Intelligence: " + intelligence + "\n";
    s += "Attack: " + attack + "\n";
    s += "Defense: " + defense + "\n";
    s += "Inventory: " + inventory + "\n";
    return s;
  }
  
  //Attack Method
 public void attack(Character c) {
    int damage = (attack - (defense / 2));
    if (damage <= 0) {
      damage = 1;
    }
    c.health -= damage;
    System.out.println(name + " did " + damage + " damage to " + c.name);
    System.out.println(c.name + " now has " + c.health + " health");
  }
}
