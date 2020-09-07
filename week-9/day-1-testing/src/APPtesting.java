import java.util.ArrayList;

public class APPtesting {

  public static void main(String[] args) {
    Sum sumObject = new Sum();
    ArrayList<Integer> numberList = new ArrayList<>();
    numberList.add(1);
    numberList.add(2);
    numberList.add(3);
    numberList.add(4);

    System.out.println(sumObject.sum(numberList));
  }
}