public class Fibonacci {
  public int fibonacciSeq(int index) {
    int iInQuestion1 = 2;//first number to be summed
    int iInQuestion2 = 3;//second number to be summed
    int iInQuestion = 0;//fibonacci number for particular level (index)

    for (int j =1; j<= index; j ++) {
      if (index == 1 ) {
        iInQuestion = 2;
      } else if (index == 2) {
        iInQuestion = 3;
      } else if (j > 2) {
        iInQuestion = iInQuestion1 + iInQuestion2;
        iInQuestion1 = iInQuestion2;
        iInQuestion2 = iInQuestion;
      }
    }
    return iInQuestion;
  }
}
