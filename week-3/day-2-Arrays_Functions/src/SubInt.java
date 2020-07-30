import java.util.Arrays;

public class SubInt {
  public static void main(String[] args) {
    int[] initialArray = {1, 11, 34, 52, 61};
    int selectedNumber = 1;
    System.out.println(subint(selectedNumber, initialArray));
  }

  public static String subint(int numberToBeFound, int[] initialArray) {
    //1) in first step we are detecting the length of finalArray, which we will need for definition of finalArray.
    // We start with index = 0, (zero matches) which will be increasing after each match.
    int lengthOfFinalArray = 0;

    //for each value of originalArray we are doing checking if it matches with numberToBeFound
    for (int initialArrayValue : initialArray) {

      //note: this while condition effectively skips elements with "0" value, so it is not possible to apply this formula if we wanted to found elements with 0.
      while (initialArrayValue > 0) {

        //we need to check if modulo % 10 == numberToBeFound.
        // If so we have a match and we can increase the lengthOfFinalArray + 1 and then we need to break the loop (or it runs indefinitely)
        // If not, we divide the number by 10 and repeat the while function with modulo 10.
        if (initialArrayValue % 10 == numberToBeFound) {
          lengthOfFinalArray++;
          break;
        }
        initialArrayValue /= 10;
      }
    }

    //Now I know the length of final array so I can define finalArray
    int[] finalArray = new int[lengthOfFinalArray];

    //2) in second step we will be putting the element index from initialArray into the FinalArray
    //For that i will work with element indexes of final array so first i define it as variable starting with 0
    int indexOfFinalArray = 0;

    //for each index of initialArray we are doing checking if the value of initialArray == numberToBeFound.
    //If so, we change the value of particular finalArray element into the index of initialArray element, where the match was found.
    for (int indexOfInitialArray = 0; indexOfInitialArray < initialArray.length;
         indexOfInitialArray++) {

      //note: this while condition effectively skips elements with "0" value, so it is not possible to apply this formula if we wanted to found elements with 0.
      while (initialArray[indexOfInitialArray] > 0) {
        if (initialArray[indexOfInitialArray] % 10 == numberToBeFound) {
          finalArray[indexOfFinalArray] = indexOfInitialArray;
          indexOfFinalArray++;
          break;
        }
        initialArray[indexOfInitialArray] /= 10;
      }
    }

    return Arrays.toString(finalArray);

  }
}
