package greenfoxorganization;

public class Sponsor extends Person {
  private String company;
  private int hiredStudents;

  public Sponsor () {
    this.company = "Google";
    this.hiredStudents = 0;
  }

  public Sponsor (String name, int age, String gender, String company) {
    super(name, age, gender);
    this.company = company;
    this.hiredStudents = 0;
  }

  public void hire() {
    this.hiredStudents ++;
  }

  public void getGoal() {
    System.out.println("Hire brilliant junior software developers.");
  }


  @Override
  public String specificIntroduction () {
    return " who represents " + company + " and hired " + hiredStudents + " students so far.";
  }



}
