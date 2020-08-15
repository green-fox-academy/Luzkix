package PostIt;

public class PostItApp {
  public static void main(String[] args) {

    PostIt post1 = new PostIt();
    post1.setBackgroundColor("orange");
    post1.setText("Idea 1");
    post1.setTextColor("blue");

    PostIt post2 = new PostIt("pink", "Awesome", "black");
    PostIt post3 = new PostIt("yellow","Superb", "green");

  }
}
