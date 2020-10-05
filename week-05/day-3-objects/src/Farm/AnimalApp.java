package Farm;

public class AnimalApp {

  public static void main(String[] args) {

    Animal cat = new Animal();
    cat.typeOfAnimal = "cat";
    cat.play();
    cat.play();
    cat.play();

    Animal dog = new Animal();
    dog.typeOfAnimal = "dog";
    dog.play();
    dog.eat();
    dog.drink();
    dog.play();

    System.out.println(cat);
    System.out.println(dog);

    Animal mouse = new Animal();
    Animal bird = new Animal();
    Animal ant = new Animal();
    Animal bear = new Animal();

    Farm farm1 = new Farm();
    farm1.farmName = "farm1";

    farm1.breed(cat);
    System.out.println(farm1.freeFarmCapacity());
    farm1.breed(dog);
    System.out.println(farm1.freeFarmCapacity());
    farm1.breed(mouse);
    System.out.println(farm1.freeFarmCapacity());
    farm1.breed(bird);
    System.out.println(farm1.freeFarmCapacity());
    farm1.breed(ant);
    ant.hunger = 30;
    ant.typeOfAnimal = "ant";
    System.out.println(farm1.freeFarmCapacity());
    farm1.breed(bear);
    System.out.println(farm1.freeFarmCapacity());

    farm1.slaughter();
    System.out.println(farm1.freeFarmCapacity());

    farm1.changeMaximumCapacity(3);
    farm1.slaughter();
    System.out.println(farm1.freeFarmCapacity());

  }
}
