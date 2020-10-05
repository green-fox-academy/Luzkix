import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EncodedLines {
  public static void main(String[] args) {
    // Create a method that decrypts the duplicated-chars.txt

    decryptingLines("sourcefiles/encoded-lines.txt");

  }

  public static void decryptingLines(String sourceFilePath) {
    /* Used Approach:
    1. defined paths for input and output files
    2. all text from original file is transferred into new Arraylist "originalText"
    3. created empty ArrayList "finalText" which will be used later
    4. created outer loop - number of loops equals number of lines (==elements) in originalText
    5. created inner loop - number of loops equals the number of characters in each line  - originalText.get(line).length().
    6. getting individual characters, transforming them into int, shifting by -1, back to char and adding them to "temporaryFinalLine"
    7. After each inner loop ends, add the "temporaryFinalLine" into the "finalText" ArrayList
    8. After outer loop ends, write "finalText" into the newly created destinationFile path. (new file is created by this)


     */
    Path sourceFile = Paths.get(sourceFilePath);
    Path destinationFile = Paths.get(sourceFilePath.concat(".decoded.txt"));
    try {
      List<String> originalText = Files.readAllLines(sourceFile);
      List<String> finalText = new ArrayList<>();

      for (int line = 0; line < originalText.size(); line++) {
        String temporaryFinalLine = "";
        //.get(line) stands for particular line of text within the ArrayList originalText
        for (int characterIndex = 0; characterIndex <originalText.get(line).length(); characterIndex++ ) {
          char individualLetter = originalText.get(line).charAt(characterIndex);
          if (individualLetter == ' ') {
            temporaryFinalLine += ' ';
          } else {
            int originalASCIcode = (int) individualLetter;
            int adjustedASCIcode = originalASCIcode - 1; //the letters in originalText are shifted by 1
            char adjustedLetter = (char) adjustedASCIcode;
            temporaryFinalLine += adjustedLetter;
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