package PetrolStation;

public class Car {
  int gasAmount;
  int capacity;

  public Car (int gasAmount, int capacity) {
    this.gasAmount = gasAmount;
    if (gasAmount < 0) {
      this.gasAmount = 1;
      System.out.println("Gas amount must be positive number! Therefore it is set to +1.");
    }

    this.capacity = capacity;

    if ((capacity < 101) | (capacity < gasAmount)) {
      if (capacity < 101) {
        this.capacity = 101;
        System.out.println(
            "Car capacity must be higher then 100! Therefore it is set to + 101.");
      }
      if ((capacity < gasAmount) && (gasAmount > 100)) {
        this.capacity = gasAmount;
        System.out.println("Gas capacity cant be lower than gasAmount. Therefore gas capacity was increased to: " + gasAmount);
      }
      if ((capacity < gasAmount) && (gasAmount < 101)) {
        this.capacity = 101;
        System.out.println("Gas capacity cant be lower than gasAmount and also need to be higher then 100. Therefore gas capacity was increased to + 101.");
      }

    }

  }
}
