import java.util.ArrayList;
import java.util.Arrays;

public class ListIntroduction2 {
  public static void main(String[] args) {
    ArrayList<String> listA = new ArrayList<>();
    listA.add("Apple");
    listA.add("Avocado");
    listA.add("Blueberries");
    listA.add("Durian");
    listA.add("Lychee");

    ArrayList<String> listB = new ArrayList<>();
    listB.addAll(listA);

    if (listA.contains("Durian")) {
      System.out.println("List A contains Durian!");
    };

    listB.remove("Durian");

    listA.add(4, "Kiwifruit");
    System.out.println(listA);

    if (listA.size() > listB.size()) {
      System.out.println("List A is bigger!");
    } else if (listB.size() > listA.size()) {
      System.out.println("List B is bigger!");
    } else {
      System.out.println("Lists are equal size!");
    }

    System.out.println(listA.indexOf("Avocado"));
    System.out.println(listB.indexOf("Durian"));

    listB.addAll(Arrays.asList("Passion Fruit", "Pomelo"));
    System.out.println(listB);

    System.out.println(listA.get(2));


  }
}
