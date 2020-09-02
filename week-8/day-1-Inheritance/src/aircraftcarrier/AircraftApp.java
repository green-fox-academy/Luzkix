package aircraftcarrier;

import greenfoxorganization.Carrier;

public class AircraftApp {
  public static void main(String[] args) {
    Aircraft f16_1 = new F16();
    Aircraft f16_2 = new F16();
    Aircraft f35_1 = new F35();
    Aircraft f35_2 = new F35();
    Aircraft f35_3 = new F35();

    Carrier carrier = new Carrier(2300, 5000);
    carrier.add(f16_1);
    carrier.add(f16_2);
    carrier.add(f35_1);
    carrier.add(f35_2);
    carrier.add(f35_3);
    carrier.fill();

    Carrier carrier2 = new Carrier(2300, 5000);
    carrier.fight(carrier2);

    System.out.println(carrier.getStatus());



  }
}
