import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex11 {
  //Find a random Wikipedia article and copy the contents to a txt file.
  //Create a Stream expression which reads all text from this file, and prints the 100 most common words in descending order.
  //Keep in mind that the text contains punctuation characters which should be ignored.


  public static List<String> readFile(String link) {
    Path path = Paths.get(link);
    try {
      List<String> lines = Files.readAllLines(path);
      return lines;
    } catch (IOException e) {
      throw new RuntimeException("file not accessible");
    }
  }


  public static void main(String[] args) {

    //Var1 - s využitím Stream() + FlatMap
    Map<String, Long> test = readFile("files/WikiArticle.txt").stream()
        .flatMap(a -> Arrays.stream(a.split(" "))) //lines with text are split to words and streamed as String
        .map(a -> a.replaceAll("[^a-zA-Z/]", ""))
        .map(a -> a.strip()) //deleting all empty spaces
        .filter(a -> !a.isEmpty()) //deletes empty items (null words)
        .collect(Collectors.groupingBy(a -> a, Collectors.counting()));

    System.out.println(test);

    System.out.println();

    //Var2 - s využitím Stream.of + FlatMap
    Map<String, Long> test2 =
        Stream.of(readFile("files/WikiArticle.txt")) //The List of Strings is being streamed as Stream<List<String>>
            .flatMap(Collection::stream) //each line with text is streamed individually as Stream<String>
            .filter(a -> !a.isEmpty()) //empty lines are omitted
            .flatMap(str -> Arrays.stream(str.split(" "))) //split of the line into individual words
            .map(a -> a.replaceAll("[^a-zA-Z/]", "")) //keeping just letters, numbers and '/'
            .map(a -> a.strip()) //deleting all empty spaces
            .filter(a -> !a.isEmpty()) //deletes empty items (null words)
            .collect(Collectors.groupingBy(a -> a, Collectors.counting()));

    System.out.println(test2);

    System.out.println();

    String str1= "This#string%contains^special*characters&.1239";
    str1 = str1.replaceAll("[^a-zA-Z0-9]","");
    System.out.println(str1);

    String str2= "This#string%con(tain[s]^spec/ial*characters&.1239";
    str2 = str2.replaceAll("[^0-9/(]","");
    System.out.println(str2);
  }
}


