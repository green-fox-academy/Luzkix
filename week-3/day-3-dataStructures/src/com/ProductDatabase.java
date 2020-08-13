package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
  public static void main(String[] args) {
    HashMap<String, Integer> productList = new HashMap<>();
    productList.put("Eggs", 200);
    productList.put("Milk", 200);
    productList.put("Fish", 400);
    productList.put("Apples", 150);
    productList.put("Bread", 50);
    productList.put("Chicken", 550);

    System.out.println(priceIs(productList, "Fish"));
    System.out.println(mostExpensiveProduct(productList));
    System.out.println(averagePrice(productList));
    System.out.println(productsBelowPrice(productList, 300));
    System.out.println(exactPrice(productList, 125));
    System.out.println(cheapestProduct(productList));

  }

  private static String cheapestProduct(HashMap<String, Integer> productList) {
    //What is the cheapest product?

    ArrayList<Integer> productByPrice = new ArrayList<>(productList.values());
    Collections.sort(productByPrice);
    int smallestValue = productByPrice.get(0);
    String relatingKey = null;
    for (Map.Entry<String,Integer>entry : productList.entrySet()) {
      if (smallestValue == entry.getValue()) {
        relatingKey = entry.getKey();
        break;
      }
    }
    return "The cheapest product is: " + relatingKey;
  }

  private static String exactPrice(HashMap<String, Integer> productList, int exactPrice) {
    //Is there anything we can buy for exactly 125?

    ArrayList<Integer> productByPrice = new ArrayList<>(productList.values());
    int numOfProductsWithExactPrice = 0;
    for (int arrayIndex = 0; arrayIndex < productByPrice.size()-1; arrayIndex++) {
      if (productByPrice.get(arrayIndex) == exactPrice) {
        numOfProductsWithExactPrice += 1;
      }
    }
    if (numOfProductsWithExactPrice == 0) {
      return "There is no single product with price of " + exactPrice;
    } if (numOfProductsWithExactPrice != 0) {
      return "There are " + numOfProductsWithExactPrice + " products with price of " + exactPrice;
    }
    return null;
  }

  private static String productsBelowPrice(HashMap<String, Integer> productList, int priceThreshold) {
    //How many products' price is below 300?

    ArrayList<Integer> productByPrice = new ArrayList<>(productList.values());
    Collections.sort(productByPrice);
    int numberOfProductsBellowPrice = 0;
    for (int arrayIndex = 0; arrayIndex < productByPrice.size()-1; arrayIndex++) {
      if (productByPrice.get(arrayIndex) < priceThreshold) {
        numberOfProductsBellowPrice += 1;
      }
    }
    return "Number of products cheaper than " + priceThreshold + " is " + numberOfProductsBellowPrice;
  }

  private static String averagePrice(HashMap<String, Integer> productList) {
    //What is the average price?

    ArrayList<Integer> productByPrice = new ArrayList<>(productList.values());
    int sumOfAllPrices = 0;
    for (int arrayIndex = 0; arrayIndex < productByPrice.size()-1; arrayIndex++) {
      sumOfAllPrices += productByPrice.get(arrayIndex);
    }
    float averagePrice = (float)sumOfAllPrices/productByPrice.size();
    return "Average price of the product is: " + averagePrice;
  }

  private static String mostExpensiveProduct(HashMap<String, Integer> productList) {
    //What is the most expensive product?

    /*approach:
    importing hashmap values into array list, sorting the arraylist, iterating through all values and finding relating key
     */

    ArrayList<Integer> productByPrice = new ArrayList<>(productList.values());
    Collections.sort(productByPrice);
    int biggestValue = productByPrice.get(productByPrice.size()-1);
    String relatingKey = null;
    for (Map.Entry<String,Integer>entry : productList.entrySet()) {
      if (biggestValue == entry.getValue()) {
        relatingKey = entry.getKey();
        break;
      }
    }
    return "Most expensive product is: " + relatingKey;
  }

  public static String priceIs (HashMap<String, Integer> productlist, String keyName) {
    //How much is the fish?

    try {
      int price = productlist.get(keyName);
      return "The price of " + keyName + " is " + price;
    } catch (Exception e) {
      return "Something went wrong - probably keyName was not correctly defined or is not existent";
    }
  }

}
