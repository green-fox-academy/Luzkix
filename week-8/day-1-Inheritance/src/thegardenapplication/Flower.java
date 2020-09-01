package thegardenapplication;

public class Flower {
  private String color;
  private float waterAmount;
  private final float WATERCOEFICIENT = 0.75f;

  public Flower (String color) {
    this.color = color;
    this.waterAmount = 0f;
  }

  public boolean needsWater() {
    if (waterAmount <5) {
      return true;
    } else {
      return false;
    }
  }

  public void info() {
    System.out.println("The " + color + " Flower " +
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
