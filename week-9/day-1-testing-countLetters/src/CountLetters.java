import java.util.HashMap;

public class CountLetters {

  public HashMap countLetters (String sentence) {
    char[] letterArray = sentence.toCharArray();
    HashMap lettersMap = new HashMap();
    for (char letter : letterArray){
      if(lettersMap.containsKey(letter)) {
        lettersMap.put(letter, ((int)lettersMap.get(letter) + 1));
      } else {
        lettersMap.put(letter, 1);
      }
    }
    return lettersMap;
  }
}
;