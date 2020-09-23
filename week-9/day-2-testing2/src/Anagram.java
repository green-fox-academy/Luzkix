import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Anagram {

  public boolean anagram(String word1, String word2) {
    List<Character> chars1 = new ArrayList<>();
    for (int i = 0; i < word1.length(); i++) {
      chars1.add(word1.charAt(i));
    }

    List<Character> chars2 = new ArrayList<>();
    for (int i = 0; i < word2.length(); i++) {
      chars2.add(word2.charAt(i));
    }

    Collections.sort(chars1);
    Collections.sort(chars2);

    if (chars1.equals(chars2)) {
      return true;
    } else return false;
  }

}
