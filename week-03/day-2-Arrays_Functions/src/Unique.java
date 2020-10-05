import java.util.Arrays;

public class Unique {
  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as a parameter
    //  Returns a list of numbers where every number in the list occurs only once

    //  Example
    System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
    //  should print: `[1, 11, 34, 52, 61]`
  }

  public static String unique(int[] inputMatrix) {
    //1: order the numbers from lowest to highest using 2 for loops functions
    //2: compare 2 neighbouring values - if not matching (i.e. different numbers), add +1 to new finalMatrixLength variable (this way I get the length of finalMatrix)
    // note: last value from inputMatrix must be treated individually, cant be a subject of second for loop (due to overflow)
    //3: similar to step 2, however not adding +1 (we know the finalMatrix length at this point) - instead enter the real values into the finalMatrix

    //1:
    for (int numberOfLoops = 0; numberOfLoops < inputMatrix.length; numberOfLoops++) {
      for (int index = 0; index < inputMatrix.length - 1; index++) {
        if (inputMatrix[index] > inputMatrix[index + 1]) {
          int temp = inputMatrix[index];
          inputMatrix[index] = inputMatrix[index + 1];
          inputMatrix[index + 1] = temp;
        }
      }
    }

    //2:
    int finalMatrixLength = 0;

    for (int index = 0; index < inputMatrix.length - 1; index++) {
      if (inputMatrix[index] != inputMatrix[index + 1]) {
        finalMatrixLength++;
      }
    }

    //dealing separately with last value which is not included in forloop due to overflow issue
    if (inputMatrix[inputMatrix.length - 1] != inputMatrix[inputMatrix.length - 2]) {
      finalMatrixLength++;
    }

    //3:
    int[] finalMatrix = new int[finalMatrixLength];

    int indexFinalMatrix =
        0; //temporary variable used used in if condition for telling, where to put the resulting number.

    for (int index = 0; index < inputMatrix.length - 1; index++) {

      if (inputMatrix[index] != inputMatrix[index + 1]) {
        finalMatrix[indexFinalMatrix] = inputMatrix[index];
        indexFinalMatrix++;
      }
    }

    //again separately dealing with last value which is not included in forloop due to overflow issue
    if (inputMatrix[inputMatrix.length - 1] != inputMatrix[inputMatrix.length - 2]) {
      finalMatrix[finalMatrix.length - 1] = inputMatrix[inputMatrix.length - 1];
    }

    return Arrays.toString(finalMatrix);
  }
}
