import java.util.HashMap;

public class ShoppingList2 {
  public static void main(String[] args) {
    HashMap<String, Float> priceList = new HashMap<>();
    HashMap<String, Integer> bobList = new HashMap<>();
    HashMap<String, Integer> aliceList = new HashMap<>();

    priceList.put("Milk", 1.07f);
    priceList.put("Rice", 1.59f);
    priceList.put("Eggs", 3.14f);
    priceList.put("Cheese", 12.60f);
    priceList.put("Chicken breasts", 9.40f);
    priceList.put("Apples", 2.31f);
    priceList.put("Tomato", 2.58f);
    priceList.put("Potato", 1.75f);
    priceList.put("Onion", 1.10f);

    bobList.put("Milk", 3);
    bobList.put("Rice", 2);
    bobList.put("Eggs", 2);
    bobList.put("Cheese", 1);
    bobList.put("Chicken breasts", 4);
    bobList.put("Apples", 1);
    bobList.put("Tomato", 2);
    bobList.put("Potato", 1);

    aliceList.put("Rice", 1);
    aliceList.put("Eggs", 5);
    aliceList.put("Chicken breasts", 2);
    aliceList.put("Apples", 1);
    aliceList.put("Tomato", 10);

    //How much does Bob pay?
    float bobsCosts = 0f;
    for (String item : bobList.keySet()) {
      bobsCosts += (priceList.get(item))*(bobList.get(item));
    }
    System.out.println("Bob pay this amount of money: " + bobsCosts);

    //How much does Alice pay?
    float aliceCosts = 0f;
    for (String item : aliceList.keySet()) {
      aliceCosts += (priceList.get(item))*(aliceList.get(item));
    }
    System.out.println("Alice pay this amount of money: " + aliceCosts);

    //Who buys more Rice?
    if (bobList.get("Rice") > aliceList.get("Rice")) {
      System.out.println("Bob bought more Rice than Alice");
    } else if (bobList.get("Rice") < aliceList.get("Rice")) {
      System.out.println("Alice bought more Rice than Bob");
    } else if (bobList.get("Rice") == aliceList.get("Rice")) {
      System.out.println("Bob bought same portion of Rice as Alice");
    } else {
      System.out.println("There is some error in play...");
    }

    //Who buys more Potato?
    if ((bobList.get("Potato") != null) && (aliceList.get("Potato") != null)) {
      if (bobList.get("Potato") > aliceList.get("Potato")) {
        System.out.println("Bob bought more Potato than Alice");
      } else if (bobList.get("Potato") < aliceList.get("Potato")) {
        System.out.println("Alice bought more Potato than Bob");
      } else if (bobList.get("Potato") == aliceList.get("Potato")) {
        System.out.println("Bob bought same portion of Potato as Alice");
      } else {
        System.out.println("There is some error in play...");
      }
    } else if ((bobList.get("Potato") == null) && (aliceList.get("Potato") == null)) {
      System.out.println("Nor Bob nor Alice bought Potato");
    } else if ((bobList.get("Potato") != null) && (aliceList.get("Potato") == null)) {
      if (bobList.get("Potato") > 0) {
        System.out.println("Bob bought more Potato than Alice");
      } if (bobList.get("Potato") == 0) {
        System.out.println("Nor Bob nor Alice bought Potato");
      }
    } else if ((bobList.get("Potato") == null) && (aliceList.get("Potato") != null)) {
      if (aliceList.get("Potato") > 0) {
        System.out.println("Alice bought more Potato than Bob");
      } if (aliceList.get("Potato") == 0) {
        System.out.println("Nor Bob nor Alice bought Potato");
      }
    }
    //Who buys more different products?
    if (bobList.size() > aliceList.size()) {
      System.out.println("Bob bought more different products than Alice");
    } else if (bobList.size() < aliceList.size()) {
      System.out.println("Alice bought more different products than Bob");
    } else if (bobList.size() == aliceList.size()) {
      System.out.println("Bob and Alice bought same number of different products");
    }

    //Who buys more products? (piece)
    int countBob = 0;
    for (String item : bobList.keySet()) {
      countBob += bobList.get(item);
    }
    int countAlice = 0;
    for (String item : aliceList.keySet()) {
      countAlice += aliceList.get(item);
    }
    if (countBob > countAlice) {
      System.out.println("Bob bought more products (pieces)");
    } else if (countBob < countAlice) {
      System.out.println("Alice bought more products (pieces)");
    } else if (countBob == countAlice) {
      System.out.println("Bob and Alice bought same amount of products (pieces)");
    }

  }
}
