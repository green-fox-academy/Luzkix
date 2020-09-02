package aircraftcarrier;

public class Aircraft {
  private int ammo;
  private int baseDamage;
  private int maxAmmo;

  public Aircraft () {
    this.ammo = 0;
  }

  public int fight() {
    int damage = calculateDamage();
    this.ammo = 0;
    return damage;
  }

  public int calculateDamage() {
    int damage = this.ammo * this.baseDamage;
    return damage;
  }

  public int refill(int ammoSuply) {
   int ammoToRefill =  ammoToRefill();
   while (ammoSuply > 0 && ammoToRefill > 0) {
     ammoSuply --;
     ammoToRefill --;
     this.ammo ++;
   }
   return ammoSuply;
  }

  public int ammoToRefill() {
    int ammoToRefill = this.maxAmmo - getAmmo();
    return ammoToRefill;
  }

  public int getAmmo() {
    return ammo;
  }

 /* public int maxAmmo () {
    int maximumAmmo = this.maxAmmo;
    return maximumAmmo;
  } */

  public String getStatus () {
    return ("Type " + getClass().getSimpleName() + ", Ammo: " + ammo + specificDamage());
  }

  public String specificDamage() {
    return "";
  }

  public boolean isPriority () {
    if (this instanceof F35) {
      return true;
    } else {
      return false;
    }
  }



}
