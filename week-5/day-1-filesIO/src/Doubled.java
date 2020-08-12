import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Doubled {
  public static void main(String[] args) {
    // Create a method that decrypts the duplicated-chars.txt

    decryptingFile("sourcefiles/duplicated-chars.txt");

  }

  public static void decryptingFile(String sourceFilePath) {
    /* Used Approach:
    1. defined paths for input and output files
    2. all text from original file is transferred into new Arraylist "originalText"
    3. created empty ArrayList "finalText" which will be used later
    4. created outer loop - number of loops equals number of lines (==elements) in originalText
    5. created inner loop - number of loops equals the number of characters in each line  - originalText.get(line).length().
    6. Using if function to decide whether the inner loop index is odd - if yes, write the character into the "temporaryFinalLine" String
    7. After each inner loop ends, add the "temporaryFinalLine" into the "finalText" ArrayList
    8. After outer loop ends, write "finalText" into the newly created destinationFile path. (new file is created by this)


     */
    Path sourceFile = Paths.get(sourceFilePath);
    Path destinationFile = Paths.get(sourceFilePath.concat(".decoded.txt"));
    try {
      List<String> originalText = Files.readAllLines(sourceFile);
      List<String> finalText = new ArrayList<String>();

      for (int line = 0; line < originalText.size(); line++) {
        String temporaryFinalLine = "";
                                          //.get(line) stands for particular line of text within the ArrayList originalText
        for (int character = 0; character <originalText.get(line).length(); character++ ) {
          if (character%2 == 0) {
            temporaryFinalLine += originalText.get(line).charAt(character);
          }
        }
        finalText.add(temporaryFinalLine);
      }
      Files.write(destinationFile, finalText);

    } catch (IOException e) {
      System.out.println("I/O Error happened - something went wrong!");
    }
  }
}


