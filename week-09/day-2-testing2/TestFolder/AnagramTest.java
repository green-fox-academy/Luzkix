import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class AnagramTest {
  Anagram anagram1;

  @Before
  public void before() throws Exception {
    anagram1 = new Anagram();
  }

  @org.junit.Test
  public void anagram_sameWords() {

    String word1 = "ahoj";
    String word2 = "ahoj";

    assertTrue(anagram1.anagram(word1, word2));
  }

  @Test
  public void anagram_diffWordsSameLenght() {
    String word1 = "joha";
    String word2 = "ahjo";

    assertTrue(anagram1.anagram(word1, word2));
  }

  @Test
  public void anagram_noWords() {
    String word1 = "";
    String word2 = "";

    assertTrue(anagram1.anagram(word1, word2));
  }

  @Test
  public void anagram_diffWordsSameLenght2() {
    String word1 = "ahoj";
    String word2 = "pako";

    assertFalse(anagram1.anagram(word1, word2));
  }

  @Test
  public void anagram_diffWordsDiffLenght() {
    String word1 = "ahoj";
    String word2 = "ahjo1";

    assertFalse(anagram1.anagram(word1, word2));
  }
}