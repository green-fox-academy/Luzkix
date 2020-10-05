package Pirates;

public class WarApp {
  public static void main(String[] args) {
    Armada armada1 = new Armada();
    armada1.addRandomShips();
    System.out.println("My army:");
    System.out.println(armada1);

    Armada armada2 = new Armada();
    armada2.addRandomShips();
    System.out.println("Enemy army:");
    System.out.println(armada2);

    armada1.war(armada2);
  }
}
