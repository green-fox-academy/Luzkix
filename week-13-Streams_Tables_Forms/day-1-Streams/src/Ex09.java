import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex09 {
  public static void main(String[] args) {
    //Write a Stream Expression to find the frequency of characters in a given string!
    String testString = "eeeAAaaaCggggg122333";
    Map<Character, Long> charStats = testString.chars()
        .mapToObj(a -> (char) a)
        .sorted()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(charStats);

  }
}
