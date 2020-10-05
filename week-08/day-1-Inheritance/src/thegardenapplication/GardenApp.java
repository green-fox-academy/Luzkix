package thegardenapplication;

import java.util.concurrent.Flow;

public class GardenApp {
  public static void main(String[] args) {
    Flower flower = new Flower("yellow");
    Flower flower2 = new Flower("blue");
    Tree tree = new Tree ("purple");
    Tree tree2 = new Tree ("orange");

    Garden garden = new Garden();
    garden.addFlower(flower);
    garden.addFlower(flower2);
    garden.addTree(tree);
    garden.addTree(tree2);
    System.out.println(garden);

    garden.waterGarden(40);
    System.out.println(garden);

    garden.waterGarden(70);
    System.out.println(garden);
  }
}
