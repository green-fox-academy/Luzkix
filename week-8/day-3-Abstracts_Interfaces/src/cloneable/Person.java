package cloneable;

public class Person {
  protected String name;
  protected int age;
  protected String gender;

  public Person () {
    this.name = "Jane Doe";
    this.age = 30;
    this.gender = "female";
  }

  public Person (String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public void introduce() {
    System.out.println("Hi, I am " + name + ", a " + age + " year old " + gender + specificIntroduction());
  }

  public String specificIntroduction () {
    return " ";
  }

  public void getGoal() {
    System.out.println("My goal is: Live for the moment!");
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }
}
