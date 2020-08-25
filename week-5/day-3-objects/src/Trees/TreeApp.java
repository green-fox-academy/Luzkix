package Trees;

public class TreeApp {
  public static void main(String[] args) {
    Tree tree1 = new Tree("Arborvitae", "green", 24, "male");
    Tree tree2 = new Tree("Black Ash", "black", 2, "male");
    Tree tree3 = new Tree("Butternut", "yellow", 15, "female");
    Tree tree4 = new Tree("Pin Cherry", "red", 50, "female");
    Tree tree5 = new Tree("Cucumber Tree", "blue", 31, "male");

    Trees trees1 = new Trees();
    trees1.addTree(tree1);
    trees1.addTree(tree2);
    trees1.addTree(tree3);
    trees1.addTree(tree4);
    trees1.addTree(tree5);

    System.out.println(trees1);

  }

}
