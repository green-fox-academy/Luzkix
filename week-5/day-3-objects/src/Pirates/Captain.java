package Pirates;

public class Captain extends Pirate{
  public Captain () {
    isCaptain();
    setName("Captain");
    setCountOfDrinks((int) (Math.random()*6));
    if (getCountOfDrinks() > 4) {
      setPassedOut();
    }
  }
  public void giveOrder () {
    System.out.println("I am the shit!");
  }
}
