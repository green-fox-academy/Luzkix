import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PersonalFinance {
  public static void main(String[] args) {
    ArrayList<Integer> expenses = new ArrayList<>();
    expenses.addAll(Arrays.asList(500, 1000, 1250, 175, 800, 121));
    System.out.println("These are the expenses: " + expenses);
    int sumOfexpenses = sum(expenses);
    int greatestExpense = biggestValue(expenses);
    int lowestExpense = lowestValue(expenses);
    double averageExpense = averageValue(expenses);

    System.out.println("Sum of expensis is: " + sumOfexpenses);
    System.out.println("Biggest expense is: " + greatestExpense);
    System.out.println("Lowest expense is: " + lowestExpense);
    System.out.println("Average expense is: " + averageExpense);
  }

  private static double averageValue(ArrayList<Integer> expenses) {
    int sum = 0;
    for (int row : expenses) {
      sum = sum + row;
    }
    double average = sum/(expenses.size());
    return average;
  }

  private static int lowestValue(ArrayList<Integer> expenses) {
    Collections.sort(expenses);
    return expenses.get(0);
  }

  private static int biggestValue(ArrayList<Integer> expenses) {
    Collections.sort(expenses);
    return expenses.get(expenses.size()-1);
  }

  private static int sum(ArrayList<Integer> expenses) {
    int sumOfNumbers = 0;
    for (int row : expenses) {
      sumOfNumbers = sumOfNumbers + row;
    }
    return sumOfNumbers;

  }


}
