package Farm;

import java.util.ArrayList;
import java.util.List;

public class Farm {
  List <Animal> animals;
  private static int maximumAnimalsCapacity = 5;
  private int freeSlots;
  String farmName;

  public Farm () {
    this.animals = new ArrayList<>();
  }

  public void changeMaximumCapacity (int newMaxCapacity) {
    maximumAnimalsCapacity = newMaxCapacity;
    System.out.println("the maximum capacity of the Farm was changed to " + newMaxCapacity);
  }

  public String freeFarmCapacity() {
      freeSlots = maximumAnimalsCapacity - this.animals.size();
      return "The capacity of the farm is " + freeSlots;
    }

  public void breed(Animal animal) {
    freeFarmCapacity();
    if (freeSlots > 0) {
      animals.add(animal);
    } else {
      System.out.println("You reached the capacity of the " + farmName + "!");
    }
  }

  public void slaughter () {
    int animalsIndex = 0;
    for (Animal animal : animals) {
      if (animal.hunger < animals.get(animalsIndex).hunger) {
        animalsIndex = animals.indexOf(animal);
      }
    }
    System.out.println(animals.get(animalsIndex).typeOfAnimal + " was removed!");
    animals.remove(animalsIndex);

  }

}
