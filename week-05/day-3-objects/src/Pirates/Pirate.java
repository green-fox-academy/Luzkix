package Pirates;

public class Pirate {
  private String name;
  private int countOfDrinks;
  private boolean passedOut;
  private boolean isDead;
  private boolean pirateHasParrot;
  private boolean isCaptain;

  public Pirate(String name, int countOfDrinks, boolean isCaptain ) {
    this.name = name;
    this.countOfDrinks = countOfDrinks;
    this.isCaptain = isCaptain;
    passedOut = this.countOfDrinks > 4;
    isDead = false;
    pirateHasParrot = false;
  }
  public Pirate() {
    name = "pirate";
    countOfDrinks = 0;
    passedOut = false;
    isDead = false;
    pirateHasParrot = false;
    isCaptain = false;
  }

  public void drinkSomeRum(int numberOfDrinks) {
    if (isDead || passedOut) {
      System.out.println("The pirate " + name + " is dead or passedOut!");
    } else {
      this.countOfDrinks += numberOfDrinks;
      if (countOfDrinks > 4) {
        passedOut = true;
      }
    }
  }

  public void drinkSomeRum() {
    if (!(isDead || passedOut)) {
      countOfDrinks ++;
      if (countOfDrinks > 4) {
        passedOut = true;
      }
    }
  }

  public int getCountOfDrinks() {
    return countOfDrinks;
  }

  public void setCountOfDrinks(int countOfDrinks) {
    this.countOfDrinks = countOfDrinks;
  }

  public void howsItGoingMate() {
    if (isDead) {
      System.out.println("The pirate " + name + " is dead thus not able to communicate!");
    } else {
      if (countOfDrinks <= 4) {
        System.out.println("Pour me anudder!");
      } else if (countOfDrinks > 4) {
        System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        passedOut=true; //pirate starts sleeping
      }
    }
  }

  public void sleep () {
    if (isDead) {
      System.out.println("Dead pirates can not sleep");
      return;
    }
    countOfDrinks = 0;
    passedOut = false;
  }

  public void die() {
    isDead = true;
  }

  public boolean isDead() {
    return isDead;
  }

  public boolean getPassOutStatus() {
    return passedOut;
  }

  public void setPassedOut() {
    this.passedOut = true;
  }

  public void brawl(Pirate otherPirate) {
    if (isDead || otherPirate.isDead) {
      System.out.println("You cant fight with the dead pirates!");
      return; //else udělá to samé jako return. ale když bych měl else if, měl bych dát return
    } else {
      float randomNumber = (float) (Math.random());
      if (randomNumber < 0.33f) {
        System.out.println("The pirate, who initiated brawl (" + this.name +
            ") was killed by the other pirate! (" + otherPirate.name + ")");
        this.die();
      } else if ((randomNumber > 0.33f) && (randomNumber < 0.66f)) {
        System.out.println(
            "The defending pirate (" + otherPirate.name + ") was killed by attacking pirate! (" +
                this.name + ")");
        otherPirate.die();
      } else if (randomNumber >= 0.66f) {
        System.out.println("Both attacking (" + this.name + ") and defending (" + otherPirate.name +
            ") pirates have passed out during the brawl");
        this.passedOut = true;
        otherPirate.passedOut = true;
      }
    }
  }

  public void addParrot() {
    if (isDead) {
      System.out.println("The pirate " + name + " is dead!");
    } else {
      this.pirateHasParrot = true;
      System.out.println("The pirate " + this.name + " was gifted a parrot!");
    }
  }

  public void isCaptain() {
    isCaptain = true;
  }

  public boolean getIsCaptain() {
    return isCaptain;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Selected pirate properties are following: \nName: " + this.name + "\nisDead: " + this.isDead + "\nNumber of drinks: " + this.countOfDrinks + "\nhasParrot: " + this.pirateHasParrot +"\n";

  }
}
