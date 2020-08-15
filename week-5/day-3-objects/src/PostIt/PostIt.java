package PostIt;

public class PostIt {

  private String backgroundColor;
  private String text;
  private String textColor;

  public PostIt () {
  }

  public PostIt (String backgroundColor, String text, String textColor) {
    this.backgroundColor = backgroundColor;
    this.text = text;
    this.textColor = textColor;
  }

  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setTextColor(String textColor) {
    this.textColor = textColor;
  }
}
