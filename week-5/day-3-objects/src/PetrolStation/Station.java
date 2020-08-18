package PetrolStation;

public class Station {
  int gasAmount = 200;

  public void refill (Car car) {
    this.gasAmount -= (car.capacity - car.gasAmount);
    car.gasAmount += (car.capacity - car.gasAmount);
  }
}
