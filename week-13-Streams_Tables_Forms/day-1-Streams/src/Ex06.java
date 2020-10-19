import java.util.List;
import java.util.stream.Collectors;


public class Ex06 {
  public static void main(String[] args) {
    //Write a Stream Expression to find the uppercase characters in a string!
    String testString = "Ahoj JakSe máš? mám SE celKeM dobŘe";

    //Var1: vrátím výsledek jako list of characters
    List<Character> uppercase1 = testString.chars()
        .mapToObj(letter -> (char) letter)
        .filter(a -> Character.isUpperCase(a))
        //lze i takto: .filter(Character::isUpperCase)
        .collect(Collectors.toList());

    System.out.println(uppercase1);

    //Var2: vrátím výsledek jako slovo String
    String uppercase2 = testString.chars()
        .filter(Character::isUpperCase)
        .peek(System.out::println)
        .collect(
            StringBuilder::new,
            StringBuilder::appendCodePoint, //převede z číslic na písmeno
            StringBuilder::append
        )
        .toString();

    System.out.println(uppercase2);


  }
}
