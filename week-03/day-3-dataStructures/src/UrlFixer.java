public class UrlFixer {
  public static void main(String[] args) {
    /* String url = "https//www.reddit.com/r/nevertellmethebots";

    // Accidentally I got the wrong URL for a funny subreddit. It's probably "odds" and not "bots"
    // Also, the URL is missing a crucial component, find out what it is and insert it too!
    // Try to solve it more than once using different String functions!

    System.out.println(url); */

    String url = "https//www.reddit.com/r/nevertellmethebots";

    String simpleReplace = url.replace("https//www.reddit.com/r/nevertellmethebots", "https://www.reddit.com/r/nevertellmetheodds");
    System.out.println(simpleReplace);

    String replaceWithFunction = adjustHttp(url);
    System.out.println(replaceWithFunction);

  }

  private static String adjustHttp(String sentence) {
    if (sentence.startsWith("https/")) {
      sentence = sentence.replace("https/", "https:/");
    } if (sentence.endsWith("thebots")) {
      sentence = sentence.replace("thebots", "theodds");
    }
    return sentence;


  }
}
