import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex10_Foxes {
  String name;
  String color;
  int age;

  public Ex10_Foxes() {
    this.name = "FoxName";
    this.color = "orange";
    this.age = 7;
  }

  public Ex10_Foxes(String name, String color, int age) {
    this.name = name;
    this.color = color;
    this.age = age;
  }

  @Override
  public String toString() {
    return this.name;
  }

  public static void main(String[] args) {
    List<Ex10_Foxes> foxList = Arrays.asList(new Ex10_Foxes(), new Ex10_Foxes("jenda","green", 6 ), new Ex10_Foxes("pepa","green",3),
        new Ex10_Foxes("zdenda", "red",6), new Ex10_Foxes("kuba","red",2), new Ex10_Foxes("simona","green",1));

    //1: Write a Stream Expression to find the foxes with green color!
    List<Ex10_Foxes> greenFoxes1 = foxList.stream()
        .filter(fox -> fox.color.equals("green"))
        .collect(Collectors.toList());
    System.out.println(greenFoxes1);

    //2: Write a Stream Expression to find the foxes with green color, and age less then 5 years!!
    List<Ex10_Foxes> greenFoxes2 = foxList.stream()
        .filter(fox -> fox.color.equals("green") && fox.age<5)
        .collect(Collectors.toList());
    System.out.println(greenFoxes2);

    //3: Write a Stream Expression to find the frequency of foxes by color!!
    Map<String, Long> greenFoxes3 = foxList.stream()
        .collect(Collectors.groupingBy(a -> a.color, Collectors.counting()));
    System.out.println(greenFoxes3);

  }
}


