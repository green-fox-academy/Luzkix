package BeforeExcercise;

public class Person {
  private String name;
  private int age;
  private Gender gender;

  public Person() {
    name = "Jane Doe";
    age = 30;
    gender = Gender.female;
  }

  public Person(String name, int age, Gender gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public enum Gender {
    male,
    female
  }

  public void introduce () {
    System.out.println("Hi, I am " + name + ", a " + age + " year old "+ gender + ".");
  }

  public void getGoal() {
    System.out.println("My goal is: Live for the moment!");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }
}
