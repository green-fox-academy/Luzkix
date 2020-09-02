package greenfoxorganization;

import aircraftcarrier.Aircraft;
import java.util.ArrayList;
import java.util.List;

public class Carrier {
  private List<Aircraft> aircraftCarrier;
  private int carrierAmmo;
  private int healthPoints;

  public Carrier (int carrierAmmo, int healthPoints) {
    aircraftCarrier = new ArrayList<>();
    this.carrierAmmo = carrierAmmo;
    this.healthPoints = healthPoints;
  }

  public void add(Aircraft aircraft) {
    aircraftCarrier.add(aircraft);
  }

  public void fill () {
    if (carrierAmmo >= ammoNeeded()) {
      for (Aircraft aircraft : aircraftCarrier) {
        carrierAmmo = aircraft.refill(carrierAmmo);
      }
    } else if (carrierAmmo < ammoNeeded()) {
      if (carrierAmmo > 0) {
        for (Aircraft aircraft : aircraftCarrier) {
          if (aircraft.isPriority() && carrierAmmo >= aircraft.ammoToRefill()) {
            carrierAmmo = aircraft.refill(carrierAmmo);
          }
        }
        for (Aircraft aircraft : aircraftCarrier) {
          if (!aircraft.isPriority() && carrierAmmo >= aircraft.ammoToRefill()) {
            carrierAmmo = aircraft.refill(carrierAmmo);
          }
        }
      } else if (carrierAmmo <= 0) {
        System.out.println("The carrier have no more ammo for filling the aircrafts!!!");
      }
    }
    System.out.println("Carrier ammo after filling other aircrafts is " + carrierAmmo);
  }

  private int ammoNeeded() {
    int ammoNeeded = 0;
    for (Aircraft aircraft : aircraftCarrier) {
      ammoNeeded += aircraft.ammoToRefill();
    }
    return ammoNeeded;
  }

  public void fight (Carrier enemyCarrier) {
    enemyCarrier.healthPoints -= carrierDamage();
    if (enemyCarrier.healthPoints > 0) {
      System.out.println("Enemy carrier health status after fight is " + enemyCarrier.healthPoints);
    } else if (enemyCarrier.healthPoints <= 0) {
      System.out.println("Enemy carrier was destroyed!!!");
    }
  }

  public int carrierDamage () {
    int carrierDamage = 0;
    for (Aircraft aircraft : aircraftCarrier) {
      carrierDamage += aircraft.calculateDamage();
    }
    return carrierDamage;
  }

  public String getStatus() {
    String finalStatus = "HP: " + this.healthPoints + ", Aircraft count " + aircraftCarrier.size() + ", Ammo Storage: " + carrierAmmo + ", Total damage: " + carrierDamage() + "\n";
    if (this.healthPoints > 0) {
      finalStatus += "Aircrafts:\n";
      for (Aircraft aircraft : aircraftCarrier) {
        finalStatus += aircraft.getStatus() + "\n";
      }
    }
    if (this.healthPoints <= 0) {
      finalStatus += ("It's dead Jim :(");
    }
    return finalStatus;
  }
}
