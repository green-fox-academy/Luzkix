package cloneable;

import java.util.ArrayList;

public class TestInput {
  public static void main(String[] args) {
    Student john = new Student("John", 20, "male", "BME");

    try {
      Student jonhTheClone = (Student)john.clone();

      jonhTheClone.setAge(35);
      System.out.println(john.getAge());
      System.out.println(jonhTheClone.getAge());
    } catch (CloneNotSupportedException e) {
      System.out.println("Chyba!");
    }






  }
}
