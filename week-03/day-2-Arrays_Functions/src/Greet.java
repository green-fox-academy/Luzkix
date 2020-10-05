public class Greet {
  public static void main(String[] args) {
    String al = "Green Fox";

    System.out.println(greet(al));
  }

  public static String greet (String subjectToBeGreeted) {
    String greeting = "Greatings dear, " + subjectToBeGreeted;
    return greeting;
  }
}
