package zoo;

public class Mammal extends Animal {
  protected int numOfLegs;
  protected int numOfTooths;

  public Mammal () {
    this.numOfLegs = 4;
    this.numOfTooths = 20;
    this.name = "Mammal";
  }

  public Mammal (int numOfLegs, int numOfTooths) {
    this.numOfLegs = numOfLegs;
    this.numOfTooths = numOfTooths;
    this.name = "Mammal";
  }

  public Mammal (String name) {
    this.numOfLegs = 4;
    this.numOfTooths = 20;
    this.name = name;
  }

  @Override
  public String breed() {
    return "pushing miniature versions out";

  }

  @Override
  public String sleep() {
    return "in shelter or home";

  }
}
