package zoo;

public class Bird extends Animal {
  protected boolean canSing;

  public Bird () {
    this.canSing = true;
    this.name = "Bird";
  }

  public Bird (boolean canSing) {
    this.canSing = true;
    this.name = "Bird";
  }

  public Bird (String name) {
    this.canSing = true;
    this.name = name;
  }

  public void canFly (boolean canFly) {
    if (canFly) {
      System.out.println("This bird can enjoy the world from the sky!");
    } if (!canFly) {
      System.out.println("This bird can only walk.");
    }
  }

  @Override
  public String breed() {
    return "laying eggs";

  }

  @Override
  public String sleep() {
    return "in the nest in trees";

  }
}

