import java.util.Arrays;
import java.util.List;

public class Ex08 {
  public static void main(String[] args) {
    //Write a Stream Expression to concatenate a Character list to a string!
    List<Character> individualLetters = Arrays.asList('a', 'b','C',' ','a','h','o','j');
    String sentence = individualLetters.stream()
        .map(a -> a.toString())
        .reduce((a , b) -> a.concat(b))
        //nebo .reduce(String::concat);
        .get();//list typu Optional přemění na String

    System.out.println(sentence);

  }
}
