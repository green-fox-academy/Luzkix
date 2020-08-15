package PostIt;

import java.awt.Color;

public class PostIt {

  private Color backgroundColor;
  private String text;
  private Color textColor;

  public PostIt () {
  }

  public PostIt (Color backgroundColor, String text, Color textColor) {
    this.backgroundColor = backgroundColor;
    this.text = text;
    this.textColor = textColor;
  }

  public void setBackgroundColor(Color backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setTextColor(Color textColor) {
    this.textColor = textColor;
  }
}
