package thegardenapplication;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  private List<Tree> trees;
  private List<Flower> flowers;

  public Garden() {
    this.trees = new ArrayList<>();
    this.flowers = new ArrayList<>();
  }

  public void addTree(Tree tree) {
    this.trees.add(tree);
  }

  public void addFlower(Flower flower) {
    this.flowers.add(flower);
  }

  public void waterGarden (int totalAmountOfWater) {
    float individualAmountOfWater = (float)totalAmountOfWater/(float)NumberOfplantsToWater();
    for (Flower flower: flowers) {
      if(flower.needsWater()) {
        flower.addWaterAmount(individualAmountOfWater*flower.getWATERCOEFICIENT());
      }
    }
    for (Tree tree: trees) {
      if (tree.needsWater()) {
        tree.addWaterAmount(individualAmountOfWater*tree.getWATERCOEFICIENT());
      }
    }
    System.out.println("Watering with "+totalAmountOfWater);
  }

  public int NumberOfplantsToWater() {
    int plantsToWater = 0;
    for (Flower flower: flowers) {
      if(flower.needsWater()) {
        plantsToWater++;
      }
    }
    for (Tree tree: trees) {
      if(tree.needsWater()) {
        plantsToWater++;
      }
    }
    return plantsToWater;
  }

  @Override
  public String toString() {
    for (Flower flower : flowers){
      flower.info();
    }
    for (Tree tree: trees) {
      tree.info();
    }
    return "";
  }
}
