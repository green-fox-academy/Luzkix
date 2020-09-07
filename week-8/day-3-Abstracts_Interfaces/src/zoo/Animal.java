package zoo;

public abstract class Animal {
  protected String name;
  protected int age;
  protected String gender;
  protected String color;

  public String getName() {
    return name;
  }

  abstract public String breed();
  abstract public String sleep();
}
