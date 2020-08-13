import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReversedOrder {
  public static void main(String[] args) {
    // Create a method that decrypts reversed-order.txt

    reverseOrder("sourcefiles/reversed-order.txt");
  }

  public static void reverseOrder (String originFilePath) {
    Path originPath = Paths.get(originFilePath);
    Path destinationPath = Paths.get(originFilePath + ".decrypted.txt");
    try {
      List<String> originalText = Files.readAllLines(originPath);
      List<String> finalText = originalText;

      //not necessary to use for loop function - there is specific reverse function which reverse order of items in ArrayList
      Collections.reverse(finalText);
      Files.write(destinationPath,finalText);

    } catch (IOException e) {
      System.out.println("Something went wrong with accessing files!");
    }
  }
}
