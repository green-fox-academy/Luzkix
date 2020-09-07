import java.util.ArrayList;

public class Sum {

  public static void main(String[] args) {
    Sum sumObject = new Sum();
    ArrayList<Integer> numberList = new ArrayList<>();
    numberList.add(1);
    numberList.add(2);
    numberList.add(3);
    numberList.add(null);

    System.out.println(sumObject.sum(numberList));
  }

  public int sum(ArrayList<Integer> numberList) {
      int sum = 0;
      for (int i = 0; i < numberList.size(); i++) {
        if (numberList.get(i) != null) {
          sum += numberList.get(i);
        }
      }
      return sum;
  }
}
