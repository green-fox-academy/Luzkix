import static org.junit.jupiter.api.Assertions.*;


import java.util.HashMap;
import org.junit.jupiter.api.Test;

class CountLettersTest {

  @Test
  void countLettersNoRepeatingChars() {
    CountLetters testString = new CountLetters();
    String test = "ahoj";
    HashMap testMap = new HashMap();
    testMap.put('a', 1);
    testMap.put('h', 1);
    testMap.put('o', 1);
    testMap.put('j', 1);

    assertEquals(testMap, testString.countLetters(test));

  }

  @Test
  void countLettersRepeatingChars() {
    CountLetters testString = new CountLetters();
    String test = "aahh";
    HashMap testMap = new HashMap();
    testMap.put('a', 2);
    testMap.put('h', 2);

    assertEquals(testMap, testString.countLetters(test));

  }
}