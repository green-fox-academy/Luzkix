package CharSequence;

public class Shifter implements CharSequence{
private int shift;
private String keyword;

public Shifter (String keyword, int shift) {
  this.keyword = keyword;
  this.shift = shift;
}

  public static void main(String[] args) {
  Shifter s = new Shifter("example", 2);
  System.out.println(s.charAt(5));
  }


  @Override
  public int length() {
    return 0;
  }

  @Override
  public char charAt(int index) {
    index += shift;
    try {
      return keyword.charAt(index);
    } catch (Exception e) {
      System.out.printf("Index must by lower than keyword lenght minus shift index!");
      return ' ';
    }
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return null;
  }
}
