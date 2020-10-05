import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingList {
  public static void main(String[] args) {
    ArrayList<String> shoppingList = new ArrayList<>();
    shoppingList.addAll(Arrays.asList("eggs", "milk", "fish", "apples", "bread", "chicken"));
    System.out.println(shoppingList);

    //1. Is the milk on the list?
    System.out.println(isOnTheList(shoppingList, "milk"));

    //2. Do we have bananas on the list? - same function as previously
    System.out.println(isOnTheList(shoppingList, "bananas"));


  }

  public static String isOnTheList (ArrayList<String> listOfItems, String item) {
    String finalSentence = null;
    for (String row : listOfItems) {
      if (item.equals(row)) {
        finalSentence = "The " + item + " is on the list! And its index in the list is: " + listOfItems.indexOf(item);
        break;
      } else {
        finalSentence = "The " + item + " is not on the list!";
      }
    }
    return finalSentence;
  }

}
