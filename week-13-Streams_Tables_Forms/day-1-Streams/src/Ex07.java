import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex07 {
  public static void main(String[] args) {
    //Write a Stream Expression to find the strings which starts with a given letter(as parameter), in the following list:
    List<String> cities = Arrays
        .asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
    System.out.println(startsWithLetter("a", cities));

  }

  static List<String> startsWithLetter (String s, List<String> cities) {
    List<String> filtredCities = cities.stream()
        .filter(city -> city.startsWith(s.toUpperCase()))
        .collect(Collectors.toList());
    return filtredCities;
  }

}
