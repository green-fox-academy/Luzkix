package Trees;

import java.util.ArrayList;
import java.util.List;

public class Trees {
  List<Tree> trees;

  public Trees () {
    this.trees = new ArrayList<>();
  }

  public void addTree (Tree tree) {
    this.trees.add(tree);
  }

  @Override
  public String toString() {
    String tempTreesDesc = "The Trees object contain following types of trees: \n";
    for (int i = 0; i < this.trees.size(); i++) {
      String typeOfTree = trees.get(i).type + ", age " + trees.get(i).age + "\n";
      tempTreesDesc += typeOfTree;
    }
    return tempTreesDesc;
  }
}
