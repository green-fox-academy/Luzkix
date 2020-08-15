package Animal;

public class App {

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
  }
}
