package string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class justTest {
  public static void main(String[] args) {


    String testString2 = "ahoj, jak se máš? Mám se dobře, a ty? ";
    String[] splitSentence = testString2.split(", ");
    System.out.println(splitSentence[1]);

    //Př.1 Kolik má soubor slov? - převedu na slova dle mezer a spočtu
    readFile();
    String testString = "";

    for (String line : readFile()) {
      testString += line;
    }

    String[] splitWords = testString.split(" ");
    System.out.println("The book has " + splitWords.length + " split words!");

    List<String> testList = new ArrayList<>();

      while (testString.length() != 0){
        if (testString.contains(" ")) {
          testList.add(testString.substring(0, testString.indexOf(' ')).trim());
          testString = testString.substring(testString.indexOf(' ')).trim();
        } else {
          testList.add(testString);
          testString = testString.substring(0,0);
          break;
        }
      }
    int numberOfWords = testList.size();

    //System.out.println(testString);
    //tem.out.println(testList);
    System.out.println("The sentence has " + numberOfWords + " words!");

  }

  private static List<String> readFile() {
    try {
      Path path = Paths.get("src/string/files/The_Hunger_Games.txt");
      List<String> lines = Files.readAllLines(path);
      return lines;
    } catch (IOException e) {
      throw new RuntimeException("Source file is not accessible!");
    }
  }


}
