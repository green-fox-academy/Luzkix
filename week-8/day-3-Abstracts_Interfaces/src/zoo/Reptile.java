package zoo;

public class Reptile extends Animal {
  protected int lenght;
  protected boolean isPoisoned;

  public Reptile () {
    this.lenght = 50;
    this.isPoisoned = false;
    this.name = "Reptile";
  }

  public Reptile (int lenght, boolean isPoisoned) {
    this.lenght = lenght;
    this.isPoisoned = isPoisoned;
    this.name = "Reptile";
  }

  public Reptile (String name) {
    this.lenght = 50;
    this.isPoisoned = false;
    this.name = name;
  }

  @Override
  public String breed() {
   return "laying eggs";

  }

  @Override
  public String sleep() {
    return "with eyes opened";

  }
}

