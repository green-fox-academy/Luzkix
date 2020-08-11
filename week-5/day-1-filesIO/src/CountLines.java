import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
  public static void main(String[] args) {

// Write a function that takes a filename as string,
// then returns the number of lines the file contains.
// It should return zero if it can't open the file, and
// should not raise any error.

    String fileName = "my-file.txt";
    Path path = Paths.get(fileName);

    try {
      List<String> contentOfFile = Files.readAllLines(path);
      int numberOfLines = contentOfFile.size();
      System.out.println("Number of lines is: " + numberOfLines);
      System.out.println(contentOfFile);
    } catch (IOException e) {
      System.out.println("Number of lines is: 0 (input file is not reachable)");

    }



  }
}
