package greenfoxorganization;

public class Student extends Person {
  private String previousOrganization;
  private int skippedDays;

  public Student() {
    super(); //uses all info default in Person() constructor - not necessary to define (is set inherently)
    this.previousOrganization = "The School of Life";
    this.skippedDays = 0;
  }

  public Student (String name, int age, String gender, String previousOrganization) {
    super(name, age, gender); //uses all info default in Person constructor (String name, int age, String gender)
    this.previousOrganization = previousOrganization;
  }

  public void getGoal() {
    System.out.println("Be a junior software developer.");
  }

  public void skipDays (int numberOfDays) {
    this.skippedDays += numberOfDays;
  }

  @Override
  public String specificIntroduction () {
    return " from previous organization " + previousOrganization + " who skipped " + skippedDays
        + " days from the course already." ;
  }
}
