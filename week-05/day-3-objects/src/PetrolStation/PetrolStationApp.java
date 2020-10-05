package PetrolStation;

public class PetrolStationApp {
  public static void main(String[] args) {
    Car car1 = new Car(50, 120);
    Station petrolStation = new Station();

    System.out.println(car1.gasAmount);
    System.out.println(car1.capacity);
    System.out.println(petrolStation.gasAmount);

    petrolStation.refill(car1);

    System.out.println(car1.gasAmount);
    System.out.println(car1.capacity);
    System.out.println(petrolStation.gasAmount);

  }
}
