import java.util.ArrayList;

public class ListIntroduction1 {
  public static void main(String[] args) {

    ArrayList<String> names = new ArrayList<>();

    System.out.println(names.size());
    names.add("Williem");
    System.out.println(names.size());
    names.add("John");
    names.add("Amanda");
    System.out.println(names.size());
    System.out.println(names.get(2));

    for (String index : names) { //forEach
      System.out.println(index);
    }
    for (int index = 0; index < names.size(); index++) { //forLoop
      System.out.println((index+1) + "." + names.get(index));
    }

    names.remove(1);
    System.out.println(names);

    for (int index = names.size() - 1 ; index >= 0; index--) {
      System.out.println(names.get(index));
    }

    names.clear();
    System.out.println(names);

  }


}
