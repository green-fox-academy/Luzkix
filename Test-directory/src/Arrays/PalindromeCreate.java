package Arrays;

import java.util.List;

public class PalindromeCreate {

  public static void main(String[] args) {
    String testWord = "123";
    System.out.println(palidromeCreator(testWord));

  }

  private static String palidromeCreator(String testWord) {
    StringBuilder tempWord1 = new StringBuilder();
    StringBuilder tempWord2 = new StringBuilder();
    tempWord1.append(testWord);
    tempWord2.append(testWord).reverse();
    String finalWord = tempWord1.toString() + tempWord2.toString();
    return finalWord;
  }

}
