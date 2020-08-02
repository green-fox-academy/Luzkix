import java.util.HashMap;
import java.util.Map;
import javax.swing.Spring;

public class MapIntroduction2 {
  public static void main(String[] args) {
    HashMap<String, String> myMap = new HashMap<>();
    myMap.put("978-1-60309-452-8", "A Letter to Jo");
    myMap.put("978-1-60309-459-7", "Lupus");
    myMap.put("978-1-60309-444-3", "Red Panda and Moon Bear");
    myMap.put("978-1-60309-461-0", "The Lab");

    for (Map.Entry<String , String> entry : myMap.entrySet()) {
      System.out.println(entry.getValue() + " (" + entry.getKey() + ")");
    }

    myMap.remove("978-1-60309-444-3");
    System.out.println(myMap);

    //Finding and deleting according to the value is difficult syntax - found this approach:
    String valueToBeRemoved = "The Lab";
    myMap.entrySet().removeIf(entry -> (valueToBeRemoved.equals(entry.getValue())));

    System.out.println(myMap);

    myMap.put("978-1-60309-450-4","They Called Us Enemy");
    myMap.put("978-1-60309-453-5","Why Did We Trust Him?");
    System.out.println(myMap);

    String keyToBeFound = "478-0-61159-424-8";

    if (myMap.containsKey(keyToBeFound)) {
      System.out.println("The key was found and associated value is: " + myMap.get(keyToBeFound));
    } else {
      System.out.println("The key is not associated with HashMap");
    }

    String keyToBeFound2 = "978-1-60309-453-5";
    System.out.println(myMap.get(keyToBeFound2));

  }
}
