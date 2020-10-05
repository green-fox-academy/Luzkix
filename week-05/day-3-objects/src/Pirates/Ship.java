package Pirates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
  List <Pirate> crew = new ArrayList<>();
  private Random random = new Random();

  public Ship () {
    this.fillShip();
  }

  public void addPirate() {
    crew.add(new Pirate());
  }
  public void addPirate(String name, int countOfDrinks, boolean isCaptain) {
    crew.add(new Pirate(name, countOfDrinks, isCaptain));
  }

  public void fillShip() {
    crew.add(new Captain());

    int piratesCount = (int) (Math.random() * 10) + 1;

    for (int i = 1; i <= piratesCount; i++) {
      int randomDrinks = (int) (Math.random() * 6);
      crew.add(new Pirate("pirate" + i, randomDrinks, false));
    }
  }
    public void reportStatus(){
      if (this.crew.size() == 0) {
        System.out.println("The ship has no crew yet!");
        return;
      }
      Pirate captain = crew.get(0);
      System.out.printf("Captain consumated " + captain.getCountOfDrinks() + " rums.");
      System.out.printf("The Captain is" + (captain.getPassOutStatus() ? "":" not" ) + " passed out. " );
      System.out.println("The Captain is" + (captain.isDead() ? "":" not") + " dead. ");
      System.out.println("The ship has " + calculateAlivePirates() + " alive pirates!\n");
    }

  private int calculateAlivePirates() {
    int counter = 0;
    for (int i = 0; i < crew.size(); i++) {
      if (!crew.get(i).isDead()) {
        counter ++;
      }
    }
    return counter;
  }

   public boolean battle (Ship enemyShip) {
    boolean thisShipWins = this.calculateScore() > enemyShip.calculateScore();
    System.out.println(thisShipWins ? "Our ship won the individual battle!" : "Enemy ship won the individual battle!");
    if (thisShipWins) {
      int piratesToBeKilled = (int) (Math.random()*(enemyShip.calculateAlivePirates()+1));
      System.out.println("Pirates to be killed from enemy ship: " + piratesToBeKilled + "\n");

      int killedPirates = 0;
      while (killedPirates < piratesToBeKilled) {
        int randomPirateToBeKilled = (int) (Math.random()*(enemyShip.crew.size())); //selection of random pirate to be killed
        if (!enemyShip.crew.get(randomPirateToBeKilled).isDead()) {
          enemyShip.crew.get(randomPirateToBeKilled).die();
          killedPirates++;
        }
      }
      this.party();
    } else {
      int piratesToBeKilled = (int) (Math.random()*(this.calculateAlivePirates()+1));
      System.out.println("Pirates to be killed from our ship: " + piratesToBeKilled + "\n");

      int killedPirates = 0;
      while (killedPirates < piratesToBeKilled) {
        int randomPirateToBeKilled = (int) (Math.random()*(this.crew.size())); //selection of random pirate to be killed
        if (!this.crew.get(randomPirateToBeKilled).isDead()) {
          this.crew.get(randomPirateToBeKilled).die();
          killedPirates++;
        }
      }
      enemyShip.party();
    }
    return thisShipWins;
  }

  private void party() {
    int amountOfRumToDrink = random.nextInt(60); //randomly selected limit of disposal rum (max XX)
    System.out.println("Winning ship has a party!!! \nNumber of ready drinks for the party: " + amountOfRumToDrink);
    while ((amountOfRumToDrink > 0) && (crew.size() > isDeadOrPassedOut())) { //party ends when drinks are run out or every crew member is passed out (or dead)
      for (Pirate pirate : crew) {
        if (amountOfRumToDrink > 0) {
          if (!pirate.isDead()) {
            if (!pirate.getPassOutStatus()) {
              pirate.drinkSomeRum();
              amountOfRumToDrink--;
            }
          }
        }
      }

    }
    System.out.println("The number of not consumed drinks after the party finished (e.g. all pirates passed out) is: " + amountOfRumToDrink);
    System.out.println("The details about winning crew after the party finished:\n");
    System.out.println(this);

    //resetting the passedOut pirates, otherwise they are passedOut forever
    for (Pirate pirate: crew) {
      if (pirate.getPassOutStatus() == true) {
        pirate.sleep();
      }
    }
  }

  private int isDeadOrPassedOut() {
    int deadOrPassedOut = 0;
    for (Pirate pirate: this.crew) {
      if (pirate.isDead() || pirate.getPassOutStatus()) {
        deadOrPassedOut++;
      }
    }
    return deadOrPassedOut;
  }

  private int calculateScore() {
    if (crew.size() == 0) {
      System.out.println("Sorry, the ship is empty! Thus cannot be in battle.");
      return 0;
    }
    int alivePirates = calculateAlivePirates();
    int captainDrinks = crew.get(0).getCountOfDrinks();
    return  alivePirates - captainDrinks;
  }

  @Override
  public String toString() {
    String pirateDetails = "";
    int numberOfAlivePirates = 0;
    int numberOfPassedOut = 0;
    for (int i = 0; i < crew.size(); i++) {
      pirateDetails += "Name: " + crew.get(i).getName() + ", No.of drinks: " + crew.get(i).getCountOfDrinks() + ", passedOut: " + crew
          .get(i).getPassOutStatus() + ", isDead: " + crew.get(i).isDead() + "\n";
      if (crew.get(i).isDead() == false) {
        numberOfAlivePirates++;
      }
      if (crew.get(i).getPassOutStatus() == true) {
        numberOfPassedOut++;
      }
    }

    return "The ship contains following number of pirates: " + crew.size() + ".\n"
        + "Number of alive pirates is: " + numberOfAlivePirates + ", out of which " + numberOfPassedOut + " has passed out. "
        + "Further details about a crew can be found bellow:\n" + pirateDetails;


  }
}
