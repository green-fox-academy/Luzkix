import java.util.Arrays;

public class Reverse {
  public static void main(String[] args) {
    //Zadání - převést do reverzního pořadí
    int[] numbers = {3, 4, 5, 6, 7};

    //připravím novou matici reverseNumbers
    int[] reverseNumbers = new int[numbers.length];

    //pomocí for loop naplním novou matici daty z původní matice tak, že do ní vkládám elementy od konce.
    for (int index = 0; index < numbers.length; index++) {
      reverseNumbers[index] = numbers[numbers.length - index - 1];
    }
    System.out.println(Arrays.toString(reverseNumbers));
  }
}
