import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.ls.LSOutput;

public class ProductDatabase2 {
  public static void main(String[] args) {
    HashMap<String, Integer> productDatabase = new HashMap<>();
    productDatabase.put("Eggs" , 200);
    productDatabase.put("Milk" , 200);
    productDatabase.put("Fish" , 400);
    productDatabase.put("Apples" , 150);
    productDatabase.put("Bread" , 50);
    productDatabase.put("Chicken" , 550);

    System.out.println(lessThanThreshold(productDatabase, 201));
    System.out.println(moreThanThreshold(productDatabase, 150));
  }

  private static String moreThanThreshold(HashMap<String, Integer> productDatabase, int threshold) {
    HashMap<String, Integer> moreExpensiveProducts = new HashMap<>();
    for (Map.Entry<String, Integer> entry : productDatabase.entrySet()) {
      if (entry.getValue() > threshold) {
        moreExpensiveProducts.put(entry.getKey(),entry.getValue());
      }
    }
    return "These products cost more than " + threshold + ": " + moreExpensiveProducts;
  }

  public static String lessThanThreshold (HashMap<String, Integer> productDatabase, Integer threshold) {
    //Which products cost less than 201? (just the name)

    List<String> mapKey = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : productDatabase.entrySet()) {
      if (threshold > entry.getValue()) {
        mapKey.add(entry.getKey());
      }
    }

    return "These products cost less than " + threshold + ": " + mapKey;
  }
}
