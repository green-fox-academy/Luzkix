import java.util.HashMap;
public class MapIntroduction {
  public static void main(String[] args) {
    HashMap<Integer,Character> myMap = new HashMap<>();
    System.out.println(myMap);
    myMap.put(97, 'a');
    myMap.put(98, 'b');
    myMap.put(99, 'c');
    myMap.put(65, 'A');
    myMap.put(66, 'B');
    myMap.put(67, 'C');
    System.out.println(myMap);

    //vytisknout jen keys: použiju ForEach
    for (Integer key : myMap.keySet()) {
    System.out.println("Required KEY is: " + key);
    }
  //Vytisknout jen values: použiju ForEach
    for (Character value : myMap.values() ) {
      System.out.println("Required VALUE is: " + value);
    }
    myMap.put(68, 'D');
    System.out.println(myMap);

    System.out.println(myMap.size());

    System.out.println(myMap.get(99));

    myMap.remove(97);
    System.out.println(myMap);

    if (myMap.containsKey(100)) {
      System.out.println("There is a value associated with key 100, which is: " + myMap.get(100));
    } else {
      System.out.println("There is no such key there!");
    }

    myMap.clear();
    System.out.println(myMap);

  }
}
