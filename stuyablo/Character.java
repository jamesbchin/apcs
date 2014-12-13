public class Character {
  String name;
  int hp;
  int strength;
  int defense;
  int attack;
  
  public Character(String n) {
    name = n;
  }
  
  public boolean isAlive() {
    return (hp > 0);
  }
  
  public int attack(Character c) {
    int damage = (strength * attack) - c.defense;
    if (damage < 0) {
    damage = 0;
    }
    else {
      c.hp -= damage;
    }
    return damage;
  }
  
  public String toString() {
    String s = "";
    s += "Name: " + name + "\n";
    s += "HP: " + hp + "\n";
    s += "Strength: " + strength + "\n";
    s += "Defense: " + defense + "\n";
    s += "Attack: " + attack;
    return s;
  }
  
}