package before.excercise;

public class Mentor extends Person {
  private Level level;

  public Mentor() {
    setName("Jane Doe");
    setAge(30);
    setGender(Gender.female);
    level = Level.intermediate;
  }

  public Mentor(String name, int age, Gender gender, Level level) {
    this.setName(name);
    this.setAge(age);
    this.setGender(gender);
    this.level = level;
  }

  public enum Level {
    junior,
    intermediate,
    senior
  }

  public void getGoal() {
    System.out.println("Educate brilliant junior software developers.");
  }

  public void introduce() {
    System.out.println("Hi, I am " + getName() + ", a " + getAge() + " year old "+ getGender() + " " + level + " mentor.");
  }



}
