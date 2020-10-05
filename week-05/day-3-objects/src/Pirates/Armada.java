package Pirates;

import java.util.ArrayList;
import java.util.List;

public class Armada {
  private List<Ship> ships = new ArrayList<>();

  public void addShip () {
    ships.add(new Ship());
  }

  public void addRandomShips () {
    int randomNumber = (int) (Math.random()*11);
    for (int i = 0; i < randomNumber; i++) {
      addShip();
    }
  }

  public boolean war(Armada enemyArmada) {
    int indexOfThis = 0;
    int indexOfEnemy = 0;
    while (indexOfThis < ships.size() && indexOfEnemy < enemyArmada.ships.size()) {
      System.out.println("War round: " + (int) (indexOfThis + indexOfEnemy + 1));
      boolean thisWins = ships.get(indexOfThis).battle(enemyArmada.ships.get(indexOfEnemy));
      if (thisWins) {
        indexOfEnemy++;
      } else {
        indexOfThis++;
      }
    }
    if (indexOfThis == ships.size()) {
      System.out.println("Enemy army won the war!\n" + "Our army lost " + indexOfThis + " battleships.\n" + "Enemy army lost " + indexOfEnemy + " battleships.");
      return false;
    } else {
      System.out.println("Our army won the war!\n" + "Our army lost " + indexOfThis + " battleships.\n" + "Enemy army lost " + indexOfEnemy + " battleships.");
      return true;
    }


  }

  @Override
  public String toString() {

    return "The army contains " + this.ships.size() + " battle ships.\n";
  }
}
