public class Reverse {
  public static void main(String[] args) {
    /*  String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

    // Create a method that can reverse a String, which is passed as the parameter
    // Use it on this reversed string to check it!
    // Try to solve this using charAt() first, and optionally anything else after.

    System.out.println(reverse(toBeReversed)); */

    String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

    String finalString = reverseStrings(toBeReversed);
    System.out.println(finalString);
  }

  private static String reverseStrings(String toBeReversed) {
    //introduce variable finalSentence - there the individual characters will be imported one by one
    //for loop - will be used as many times as is the length of sentence
    //every loop will take one char (from last to first) and adds it to the variable
    //note: this approach has a limitation - charAt skips numbers (not relevant in this case)

    String finalSentence = "";
    for (int charIndex = toBeReversed.length()-1; charIndex >=0; charIndex--) {
      finalSentence = finalSentence + toBeReversed.charAt(charIndex);
    }
    return finalSentence;

  }
}

