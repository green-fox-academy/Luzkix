public class StringsAgainAgain {
  public static void main(String[] args) {
    //Given a string, compute recursively a new string where all the adjacent chars are now separated by a *

    String testString = "xxAbccd0ddeeb";

    //TEST1 - adjacent chars are separated by a *
    System.out.println(separateX(testString));


    //TEST2 - adjacent chars are replaced by *
    System.out.println(replaceX(testString));

  }

  private static String separateX(String testString) {
    try {
      if (testString.length() == 2) {
        if (testString.charAt(0) == testString.charAt(1)) {
          return Character.toString(testString.charAt(0)).concat("*")
              .concat(Character.toString(testString.charAt(1)));
        }
        return Character.toString(testString.charAt(0))
            .concat(Character.toString(testString.charAt(1)));
      } else {
        if (testString.charAt(0) == testString.charAt(1)) {
          return Character.toString(testString.charAt(0)).concat("*")
              .concat(Character.toString(testString.charAt(1)))
              .concat(separateX(testString.substring(2)));
        }
        return Character.toString(testString.charAt(0))
            .concat(Character.toString(testString.charAt(1)))
            .concat(separateX(testString.substring(2)));
      }
    } catch (Exception e) {
      return "\n The returned word is not fully complete - in order to work properly, the test word must be of even number of characters!";
    }
  }

 private static String replaceX(String testString) {
    try {
      if (testString.length() == 2) {
        if (testString.charAt(0) == testString.charAt(1)) {
          return "**";
        }
        return Character.toString(testString.charAt(0))
            .concat(Character.toString(testString.charAt(1)));
      } else {
        if (testString.charAt(0) == testString.charAt(1)) {
          return Character.toString('*')
              .concat(Character.toString('*').concat(replaceX(testString.substring(2))));
        }
        return Character.toString(testString.charAt(0))
            .concat(Character.toString(testString.charAt(1)))
            .concat(replaceX(testString.substring(2)));
      }
    } catch (Exception e) {
      return "\n The returned word is not fully complete - in order to work properly, the test word must be of even number of characters!";
    }
  }
}