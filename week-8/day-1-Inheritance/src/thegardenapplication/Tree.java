package thegardenapplication;

public class Tree {
  private String color;
  private float waterAmount;
  private final float WATERCOEFICIENT = 0.4f;

  public Tree (String color) {
    this.color = color;
    this.waterAmount = 0f;
  }

  public boolean needsWater() {
    if (waterAmount <10) {
      return true;
    } else {
      return false;
    }
  }

  public void info() {
    System.out.println("The " + color + " Tree " +
        (this.needsWater() ? "needs water.":"doesnt need water."));
  }

  public float getWATERCOEFICIENT() {
    return WATERCOEFICIENT;
  }

  public void addWaterAmount(float waterAmount) {
    this.waterAmount += waterAmount;
  }

  public float getWaterAmount() {
    return waterAmount;
  }
}
