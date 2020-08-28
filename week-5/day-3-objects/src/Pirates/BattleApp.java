package Pirates;

public class BattleApp {
  public static void main(String[] args) {
    Ship ship1 = new Ship();
    Ship ship2 = new Ship();

    ship1.fillShip();
    System.out.println("Our ship crew:\n" + ship1);
    ship2.fillShip();
    System.out.println("Enemy ship crew:\n" + ship2);

    ship1.battle(ship2);
  }
}
