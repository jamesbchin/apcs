public class Doctor extends Character {

  int heal;
  
  public Doctor(String n) {
    super(n);
    strength = 5;
    attack = 5;
    defense = 5;
    hp = 50;
    heal = 10;
  }
  
  public String toString() {
    String s = super.toString() + "\nHeal: " + heal;
    return s;
  }
  
  public int attack(Character c) {
    c.hp += heal;
    return heal;
  }

}