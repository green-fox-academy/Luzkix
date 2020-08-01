import java.lang.reflect.Array;
import java.util.ArrayList;

public class TakesLonger {
  public static void main(String[] args) {
    /* String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

    // When saving this quote a disk error has occurred. Please fix it.
    // Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
    // Using pieces of the quote variable (instead of just redefining the string)

    System.out.println(quote); */

    String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";
    int insertionIndex = quote.indexOf("you");
    String part1 = quote.substring(0, insertionIndex);
    String part2 = quote.substring(insertionIndex, quote.length());
    String insertion = "always takes longer than ";

    quote = part1.concat(insertion.concat(part2));
    System.out.println(quote);

  }

}
