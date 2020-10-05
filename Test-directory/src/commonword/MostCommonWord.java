package commonword;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord {
  public static void main(String[] args) throws Exception {
    System.out.println(commonWord("files/test.txt"));
  }

  public static String commonWord(String fileDest) throws Exception {
    try {
      Path path = Paths.get(fileDest);
      List<String> lines = Files.readAllLines(path);
      HashMap<String, Integer> countOfWords = new HashMap<>();

      for (int i = 0; i < lines.size(); i++) {
        String[] splitLine = lines.get(i).split(" ");
        for (String word : splitLine) {
          if (countOfWords.containsKey(word)) {
            countOfWords.put(word, countOfWords.get(word) + 1);
          } else {
            countOfWords.put(word, 1);
          }
        }
      }

      List<Integer> biggestValues = new ArrayList<>(countOfWords.values());
      Collections.sort(biggestValues);

      String mostCommonWord = "";
      for (Map.Entry<String, Integer> entry : countOfWords.entrySet()) {
        if (biggestValues.get(biggestValues.size() - 1) == entry.getValue()) {
          mostCommonWord = entry.getKey();
          break;
        }
      }

      /*for (Map.Entry<String, Integer> entry : countOfWords.entrySet()) {
        System.out.println( entry.getKey() + " : " + entry.getValue());
      }*/

      return mostCommonWord;

    } catch (Exception e) {
      throw new Exception("File does not exists on the given path");
    }


  }

}
