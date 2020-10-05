package Pirates;

import java.util.Random;

public class PiratesApp {
  public static void main(String[] args) {
    //Testing Pirate class
    System.out.println("Testing pirate class:\n");

    Pirate pirate1 = new Pirate("John", 0, false);
    Pirate pirate2 = new Pirate("Michael", 0, false);
    Pirate pirate3 = new Pirate("Casanova", 2, true);

    pirate2.drinkSomeRum(1);
    pirate2.drinkSomeRum(3);

    System.out.println(pirate2);
    pirate2.addParrot();
    pirate2.die();
    pirate2.addParrot();
    pirate2.howsItGoingMate();
    System.out.println(pirate2);

    pirate1.brawl(pirate3);
    System.out.println(pirate1);
    System.out.println(pirate3);

    Ship ship1 = new Ship();
    System.out.println(ship1);
    ship1.reportStatus();

    Ship ship2 = new Ship();
    System.out.println(ship2);
    ship2.reportStatus();

    ship1.battle(ship2);


  }
}
