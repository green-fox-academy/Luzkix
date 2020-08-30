package BeforeExcercise;

public class Sponsor extends Person{
  private String company;
  private int hiredStudents;

  public Sponsor() {
    setName("Jane Doe");
    setAge(30);
    setGender(Gender.female);
    company = "Google";
    hiredStudents = 0;
  }

  public Sponsor(String name, int age, Gender gender, String company) {
    this.setName(name);
    this.setAge(age);
    this.setGender(gender);
    this.company = company;
    hiredStudents = 0;
  }

  public void introduce() {
    System.out.println("Hi, I am " + getName() + ", a " + getAge() + " year old "+ getGender() + " who represents " + company + " and hired " + hiredStudents + " so far.");
  }

  public void hire() {
    hiredStudents ++;
  }

  public void getGoal() {
    System.out.println("Hire brilliant junior software developers.");
  }

}
