import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex12_SW_Heroe {
  String name;
  String height;
  String mass;
  String hair_color;
  String skin_color;
  String eye_color;
  String birth_year;
  String gender;

  public Ex12_SW_Heroe(String name, String height, String mass, String hair_color, String skin_color,
                       String eye_color, String birth_year, String gender) {
    this.name = name;
    this.height = height;
    this.mass = mass;
    this.hair_color = hair_color;
    this.skin_color = skin_color;
    this.eye_color = eye_color;
    this.birth_year = birth_year;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public float getMass() {
    if (mass.equals("unknown")) {
      return -1;
    }
    return Float.parseFloat(mass.replaceAll("[^0-9.]", ""));
  }

  public String getGender() {
    return gender;
  }

  public int getHeight() {
    if (height.equals("unknown")) {
      return -1;
    }
    return Integer.parseInt(height.replaceAll("[^0-9.]", ""));
  }

  private static List<String> readFile(String filePath) {
    Path path = Paths.get(filePath);
    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      throw new RuntimeException("file not accessible");
    }
  }

  public static List<Ex12_SW_Heroe> createHeroesWithData(String filePath) {
    //The method creates a new Ex12_SW_Hero object for each line of the text and then splits the text
    //into individual hero properties, which are then assigned to the Hero using Heroe´s constructor.
    List<Ex12_SW_Heroe> heroes = readFile(filePath).stream()
        .skip(1)
        .map(a -> a.split(";"))
        .map(a -> new Ex12_SW_Heroe(
            a[0]
            ,a[1]
            ,a[2]
            ,a[3]
            ,a[4]
            ,a[5]
            ,a[6]
            ,a[7]))
        .collect(Collectors.toList());
    return heroes;
  }

  public static void main(String[] args) {

    //1: Print the name of the heaviest character (if the mass is unknown, ignore that character)
          //1.creation of HashMap<String,Int> with name and mass of each Hero
          //   - getter getMass is adjusted so it returns the number in correct format (float)
          //2.finding maximum value and assigning the key = name of Hero

    Map<String, Float> allHeroesWeight = createHeroesWithData("files/swcharacters.txt").stream()
        .filter(hero -> hero.getMass() != -1)
        .collect(Collectors.toMap(Ex12_SW_Heroe::getName, Ex12_SW_Heroe::getMass));

    String mostHeavyHero = allHeroesWeight.entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .get(); //změna z optional na obyč. String

    System.out.println(mostHeavyHero);

    //2: Print the average height of the male characters

    Double maleAverageHeight = createHeroesWithData("files/swcharacters.txt").stream()
        .filter(hero -> hero.getHeight() != -1)
        .collect(Collectors.groupingBy(hero -> hero.getGender(), Collectors.averagingDouble(hero -> hero.getHeight())))
        .get("male");

    System.out.println("male AVG height: " + maleAverageHeight);

    //3: Print the average height of the female characters
    Double femaleAverageHeight = createHeroesWithData("files/swcharacters.txt").stream()
        .filter(hero -> hero.getHeight() != -1)
        .collect(Collectors.groupingBy(hero -> hero.getGender(), Collectors.averagingDouble(hero -> hero.getHeight())))
        .get("female");


    System.out.println("female AVG height: " + femaleAverageHeight);

  }
}
