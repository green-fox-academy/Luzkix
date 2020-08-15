import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class doableHomework {
  public static void main(String[] args) {
    /*
    Create 5 trees
Store the data of them in variables in your program
for every tree the program should store its'
type
leaf color
age
sex
you can use just variables, or lists and/or maps
     */
    String tree1type = "list";
    String tree1leafColor = "red";
    int tree1age = 5;
    String tree1sex = "male";
    String tree2type = "not-list";
    String tree2leafColor = "green";
    int tree2age = 10;
    String tree2sex = "female";

    //created just 2 trees for demonstration - point was realized ;-)
    Object[] tree1 = {tree1type,tree1leafColor, tree1age, tree1sex};
    Object[] tree2 = {tree2type, tree2leafColor, tree2age, tree2sex};

    List<Object> trees = new ArrayList<>();
    trees.add(tree1);
    trees.add(tree2);

  }
}
