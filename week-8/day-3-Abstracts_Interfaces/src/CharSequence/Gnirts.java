package CharSequence;

import java.util.ArrayList;
import java.util.List;

public class Gnirts implements CharSequence {
  protected String text;
  public Gnirts (String text) {
    this.text = text;
  }

  public static void main(String[]args){
    String testSentence = "Hello you!";
    Gnirts test = new Gnirts(testSentence);

    System.out.println(test.length());
    System.out.println(test.charAt(1));
    System.out.println(test.subSequence(0,4));
  }


  @Override
  public int length() {
    //creating list of charracters in opaque order
    List characters = new ArrayList();
    for (int i = 0; i < text.length(); i++ ) {
       characters.add(text.charAt(text.length()-1-i));
    }
    return characters.size();
  }

  @Override
  public char charAt(int index) {
    List<Character> characters = new ArrayList();
    for (int i = 0; i < text.length(); i++ ) {
      characters.add(text.charAt(text.length()-1-i));
    }
    return (char)characters.get(index);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    List characters = new ArrayList();
    for (int i = 0; i < text.length(); i++ ) {
      characters.add(text.charAt(text.length()-1-i));
    }

    //removing chars before start
    for (int i = 0; i <start; i++) {
      characters.remove(i);
      break;
    }

    //removing chars after end
    for (int i = characters.size()-1; i > end; i--) {
      characters.remove(i);
    }

    //converting "characters" ArrayList into simple String
    String result = "";
    for (Object character : characters) {
      result += character.toString();
    }

    return result;
  }


}
