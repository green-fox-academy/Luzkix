import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteMultipleLines {
  public static void main(String[] args) {
// Create a function that takes 3 parameters: a path, a word and a number
// and is able to write into a file.
// The path parameter should be a string that describes the location of the file you wish to modify
// The word parameter should also be a string that will be written to the file as individual lines
// The number parameter should describe how many lines the file should have.
// If the word is 'apple' and the number is 5, it should write 5 lines
// into the file and each line should read 'apple'
// The function should not raise any errors if it could not write the file.

    writeFunction("my-file3.txt", "apple", 5   );
  }

  //Var1: the file is re-written each time, thus it always would contain only 5 words "apple" if conditions are met
  public static void writeFunction (String pathDescription, String word, int numberOfLines) {
    Path path = Paths.get(pathDescription);
    ArrayList<String> lines = new ArrayList<>();

    try {
      if ((word == "apple") && (numberOfLines == 5) ) {
        for (int i = 0; i < numberOfLines; i++) {
          lines.add(word);
        }
      }
      Files.write(path, lines);
      System.out.println("The word `" + word + "` was successfully written into the file " + pathDescription + " " + numberOfLines + " times!");
    } catch (IOException e) {
      System.out.println("Unknown problem with target file detected - target file does not exist or is write protected");
    }

    //Var 2: words "apple" are added 5 times if conditions are met (file is not being re-written from scratch)
    /*
    public static void writeFunction (String pathDescription, String word, int numberOfLines) {
      Path path = Paths.get(pathDescription);
      try {
        if ((word == "apple") && (numberOfLines == 5) ) {
          for (int i = 0; i < numberOfLines; i++) {
            Files.write(path, (word + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
          }
        }
        System.out.println("The word `" + word + "` was successfully appended into the file " + pathDescription + " " + numberOfLines + " times!");
      } catch (IOException e) {
        System.out.println("Unknown problem with target file detected - target file does not exist or is write protected");
      }
     */



  }



}
