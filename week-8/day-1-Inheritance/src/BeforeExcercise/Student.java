package BeforeExcercise;

public class Student extends Person{
  private String previousOrganization;
  private int skippedDays;

  public Student() {
    setName("Jane Doe");
    setAge(30);
    setGender(Gender.female);
    previousOrganization = "The School of Life";
    skippedDays = 0;
  }

  public Student(String name, int age, Gender gender, String previousOrganization) {
    this.setName(name);
    this.setAge(age);
    this.setGender(gender);
    this.previousOrganization = previousOrganization;
  }

  public void getGoal() {
    System.out.println("Be a junior software developer.");
  }

  public void introduce () {
    System.out.println("Hi, I am " + getName() + ", a " + getAge() + " year old "+ getGender() + " from " + previousOrganization + " who skipped " + skippedDays + " days from the course already.");
  }

  public void skipDays (int numberOfDays) {
    skippedDays += numberOfDays;
  }

  public String getPreviousOrganization() {
    return previousOrganization;
  }

  public void setPreviousOrganization(String previousOrganization) {
    this.previousOrganization = previousOrganization;
  }
}
