import java.util.Arrays;

public class Anagram {
  public boolean isAnagram (String sentence1, String sentence2) {
    if(sentence1.length() != sentence2.length()) {
      return false;
    }

    char[] str1 = new char[sentence1.length()];
    char[] str2 = new char[sentence2.length()];

    for (int i = 0; i < sentence1.length(); i++) {
      str1[i] = sentence1.charAt(i);
      str2[i] = sentence2.charAt(i);
    }

    Arrays.sort(str1);
    Arrays.sort(str2);

    for (int i = 0; i < str1.length; i++) {
      if (str1[i] != str2[i] ) {
        return false;
      }
    }
    return true;
  }
}
