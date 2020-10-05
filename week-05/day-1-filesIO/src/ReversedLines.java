import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedLines {
  public static void main(String[] args) {
    // Create a method that decrypts reversed-lines.txt

    reversingLines("sourcefiles/reversed-lines.txt");

  }

  public static void reversingLines (String sourceFilePath) {
    /* Used approach is similar to the exercise Doubled - so check Double for details */

    Path sourceFile = Paths.get(sourceFilePath);
    Path destinationFile = Paths.get(sourceFilePath.concat(".decoded.txt"));
    try {
      List<String> originalText = Files.readAllLines(sourceFile);
      List<String> decodedText = new ArrayList<>();

      for (int line = 0; line < originalText.size(); line++ ) {

        String temporaryFinalLine = "";

        for (int characterIndex = originalText.get(line).length()-1; characterIndex >= 0; characterIndex-- ) {
          temporaryFinalLine += originalText.get(line).charAt(characterIndex);
        }
        decodedText.add(temporaryFinalLine);

      }

      Files.write(destinationFile, decodedText);

    } catch (IOException e) {
      System.out.println("I/O Error happened - something went wrong!");
    }

  }

}
