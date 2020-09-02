package aircraftcarrier;

public class F35 extends Aircraft{
  private int maxAmmo = 12;
  private int baseDamage = 50;

  @Override
  public int calculateDamage() {
    int damage = this.getAmmo() * this.baseDamage;
    return damage;
  }

  /* public int maxAmmo () {
    int maximumAmmo = this.maxAmmo;
    return maximumAmmo;
  } */

  public int ammoToRefill() {
    int ammoToRefill = this.maxAmmo - getAmmo();
    return ammoToRefill;
  }

  public String specificDamage() {
    return ", Base Damage: " + baseDamage + ", All Damage: " + getAmmo()*baseDamage;
  }
}
