import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class AnagramTest {

  @Test
  void isAnagramTrue() {
    Anagram anagram = new Anagram();
    String word1 = "hallo";
    String word2 = "hallo";
    assertTrue(anagram.isAnagram(word1, word2));
  }

  @Test
  void isAnagramFalseDiffWords() {
    Anagram anagram = new Anagram();
    String word1 = "halio";
    String word2 = "hallo";
    assertFalse(anagram.isAnagram(word1, word2));
  }

  @Test
  void isAnagramFalseDiffLenght() {
    Anagram anagram = new Anagram();
    String word1 = "hall";
    String word2 = "hallo";
    assertFalse(anagram.isAnagram(word1, word2));
  }
}