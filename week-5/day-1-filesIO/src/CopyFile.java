import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFile {
  public static void main(String[] args) {
// Write a function that copies the contents of a file into another
// It should take the filenames as parameters
// It should return a boolean that shows if the copy was successful

    copyFunction("my-file3.txt", "coppied-file.txt");

  }

  public static void  copyFunction (String source, String destination) {
    Path sourcePath = Paths.get(source);
    Path destinationPath = Paths.get(destination);

    try {
      Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
      if (Files.readAllLines(destinationPath).equals(Files.readAllLines(sourcePath))) {
        System.out.println("File content was copied successfully!");
      } else {
        System.out.println("File contents do not match!");
      }
    } catch (IOException e) {
      System.out.println("File content could not be copied!");
    }

  }
}