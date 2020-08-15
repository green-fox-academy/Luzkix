package PostIt;

import java.awt.Color;

public class Main {
  public static void main(String[] args) {

    PostIt post1 = new PostIt();
    post1.setBackgroundColor(Color.orange);
    post1.setText("Idea 1");
    post1.setTextColor(Color.blue);

    PostIt post2 = new PostIt(Color.pink, "Awesome", Color.black);
    PostIt post3 = new PostIt(Color.yellow,"Superb", Color.green );

  }
}
