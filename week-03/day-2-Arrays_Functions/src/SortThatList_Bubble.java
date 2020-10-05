import java.util.Arrays;

public class SortThatList_Bubble {
  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as parameter
    //  Returns a list where the elements are sorted in ascending numerical order
    //  Make a second boolean parameter, if it's `true` sort that list descending

    //  Example:
    System.out.println(bubble(new int[] {34, 12, 24, 9, 5}));
    //  should print [5, 9, 12, 24, 34]
    System.out.println(advancedBubble(new int[] {34, 12, 24, 9, 5}, true));
    //  should print [34, 24, 12, 9, 5]
  }

  public static String bubble(int[] inputMatrix) {
    /* solution will be 2 for loops:
      In second loop I will be comparing 2 neighbouring values and if first number is higher, it will be switched with lower number. This loop is performed X times (based on the lenght of inputMtrix).
      First loop defines how many times the second looping need to be done. Again it will be performed X times based on the inputMatrix length.
    */

    for (int numberOfLoops = 0; numberOfLoops < inputMatrix.length; numberOfLoops++) {

      //substracted -1 from length otherwise overflow
      for (int index = 0; index < inputMatrix.length - 1; index++) {
        if (inputMatrix[index] > inputMatrix[index + 1]) {
          int temp = inputMatrix[index];
          inputMatrix[index] = inputMatrix[index + 1];
          inputMatrix[index + 1] = temp;
        }
      }
    }

    return Arrays.toString(inputMatrix);
  }


  public static String advancedBubble(int[] inputMatrix, boolean booleanValue) {

    if (booleanValue == false) {
      return bubble(inputMatrix);
    } else {
      for (int numberOfLoops = 0; numberOfLoops < inputMatrix.length; numberOfLoops++) {

        //substracted -1 from length otherwise overflow
        for (int index = 0; index < inputMatrix.length - 1; index++) {
          if (inputMatrix[index] < inputMatrix[index + 1]) {
            int temp = inputMatrix[index +1];
            inputMatrix[index +1] = inputMatrix[index];
            inputMatrix[index] = temp;
          }
        }
      }

      return Arrays.toString(inputMatrix);
    }
  }
}
