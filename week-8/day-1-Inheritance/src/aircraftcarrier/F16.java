package aircraftcarrier;

public class F16 extends Aircraft{
  private int maxAmmo = 8;
  private int baseDamage = 30;


  @Override
  public int calculateDamage() {
    int damage = this.getAmmo() * this.baseDamage;
    return damage;
  }

  public int ammoToRefill() {
    int ammoToRefill = this.maxAmmo - getAmmo();
    return ammoToRefill;
  }

  public String specificDamage() {
    return ", Base Damage: " + baseDamage + ", All Damage: " + getAmmo()*baseDamage;
  }
}
