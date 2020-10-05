public class Strings {
  public static void main(String[] args) {
    //Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars
    // have been changed to 'y' chars.

    String testString = "xxAhxxxxb";
    System.out.println(replaceX(testString));

  }
  private static String replaceX(String testString) {
    if (testString.length() == 1) {
      if (testString.charAt(0) == 'x') {
        return "X";
      }
      return Character.toString(testString.charAt(0));
    } else {
      if (testString.charAt(0) == 'x') {
        return Character.toString('X').concat(replaceX(testString.substring(1)));
      }
      return Character.toString(testString.charAt(0))
          .concat(replaceX(testString.substring(1)));
    }
  }

//PREVIOUS VERSION GOING BACKWARDS - FUNCTIONAL, BUT INCORRECT
  /*private static String replaceX(String testString) {
    if (testString.length() == 1) {
      if (testString.charAt(testString.length() - 1) == 'x') {
        return "X";
      }
      return Character.toString(testString.charAt(testString.length() - 1));
    } else {
      if (testString.charAt(testString.length() - 1) == 'x') {
        return Character.toString('X').concat(replaceX(testString.substring(0, testString.length() - 1)));
      }
      return Character.toString(testString.charAt(testString.length() - 1))
          .concat(replaceX(testString.substring(0, testString.length() - 1)));
    }
  }*/
}
