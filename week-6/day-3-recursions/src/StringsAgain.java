public class StringsAgain {
  public static void main(String[] args) {
    //Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars
    // have been changed to 'y' chars.

    String testString = "xxAhxXxxb";
    System.out.println(replaceX(testString));

  }

  private static String replaceX(String testString) {
    if (testString.length() == 1) {
      if (testString.charAt(0) == 'x') {
        return "";
      }
      return Character.toString(testString.charAt(0));
    } else {
      if (testString.charAt(0) == 'x') {
        return replaceX(testString.substring(1));
      }
      return Character.toString(testString.charAt(0))
          .concat(replaceX(testString.substring(1)));
    }
  }
}