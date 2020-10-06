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

    //Var1 - nefunkční!!!
    List<String> test = readFile("files/WikiArticle.txt").stream()
        .filter(a -> !a.isEmpty()) //empty lines are omitted
        //.reduce((a, b) -> a.concat(b)) //everything into one sentence
        //.map(a -> a.split(" "))
        //.map(a -> a.replaceAll("[^a-zA-Z0-9_-]", "")
        .map(a -> a.replace("(", ""))
        .map(a -> a.replace(")", ""))
        .map(a -> a.replace(":", ""))
        .map(a -> a.replace(";", ""))
        .map(a -> a.replace(".", ""))
        .map(a -> a.replace(",", ""))
        .map(a -> a.replace("×", ""))
        .map(a -> a.replace("[", ""))
        .map(a -> a.replace("]", ""))
        .map(a -> a.replace("/", " ")) //separating words
        .map(a -> a.replaceAll("[0-9]", "")) //deletion of all numbers*/
        .collect(Collectors.toList());
        //.toString();

    //System.out.println(test);

    System.out.println();

    //Var2 - s využitím flatMap
    Map<String, Long> test2 =
        Stream.of(readFile("files/WikiArticle.txt"))
            //The List of Strings is being streamed as Stream<List<String>>
            .flatMap(Collection::stream)
            //each line with text is streamed individually as Stream<String>
            .filter(a -> !a.isEmpty()) //empty lines are omitted
            .flatMap(str -> Arrays.stream(str.split(" ")))
            //split of the line into individual words
            .map(a -> a.replace("(", ""))
            .map(a -> a.replace(")", ""))
            .map(a -> a.replace(":", ""))
            .map(a -> a.replace(";", ""))
            .map(a -> a.replace(".", ""))
            .map(a -> a.replace(",", ""))
            .map(a -> a.replace("×", ""))
            .map(a -> a.replace("[", ""))
            .map(a -> a.replace("]", ""))
            .map(a -> a.replace("/", " ")) //separating words
            .map(a -> a.replaceAll("[0-9]", "")) //deletion of all numbers
            .map(a -> a.strip()) //deleting all empty spaces
            .filter(a -> !a.isEmpty()) //deletes empty items (null words)
            .collect(Collectors.groupingBy(a -> a, Collectors.counting()));

    System.out.println(test2);


    /*    String str= "This#string%contains^special*characters&.";
    str = str.replaceAll("[^a-zA-Z0-9]","");
    System.out.println(str);*/
  }
}


