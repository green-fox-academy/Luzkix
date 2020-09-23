package string;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class justTest {
  public static void main(String[] args) {

    //Př.1 Kolik má věta slov? - převedu na slova dle mezer a spočtu
    String testString = "ahoj, jak se máš? Mám se dobře, a ty?";
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

    System.out.println(testString);
    System.out.println(testList);
    System.out.println("The sentence has " + numberOfWords + " words!");

  }




}
