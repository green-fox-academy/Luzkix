package Animal;

public class Animal {

  String typeOfAnimal = null;
  int hunger = 50;
  int thirst = 50;

  public void eat () {
    this.hunger -= 1;
  }
  public void drink () {
    this.thirst -= 1;
  }

  public void play () {
    this.hunger += 1;
    this.thirst += 1;
  }

  @Override
  public String toString() {
    return this.typeOfAnimal + " is this hungry: " + hunger + " and this thirsty: " + thirst;
  }
}
