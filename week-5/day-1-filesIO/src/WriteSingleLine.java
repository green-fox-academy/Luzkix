import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class WriteSingleLine {
  public static void main(String[] args) {
    // Write a function that is able to manipulate a file
    // By writing your name into it as a single line
    // The file should be named "my-file.txt"
    // In case the program is unable to write the file,
    // It should print the following error message: "Unable to write file: my-file.txt"

    String fileName = "my-file2.txt";
    Path path = Paths.get(fileName);
    ArrayList<String> myName = new ArrayList<>();
    myName.add("Zdeněk Luzar ");
    System.out.println(myName);

    try {
      Files.createFile(path);
    } catch (IOException e) {
      System.out.println("File " + fileName +
          " already exist - not creating new one, just adding content into it");
    }
    try {
      Files.write(path, myName, StandardOpenOption.APPEND);
    } catch (IOException e) {
      System.out.println("Unable to write file: " + fileName);
    }


  }

}