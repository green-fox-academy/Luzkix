import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FibonacciTest {
    Fibonacci testing = new Fibonacci();

  @Test
  void fibonacciSeq0() {
    int index = 0;
    int expectedResult = 0;
    assertEquals(expectedResult, testing.fibonacciSeq(index));
  }

  @Test
  void fibonacciSeq1() {
    int index = 1;
    int expectedResult = 2;
    assertEquals(expectedResult, testing.fibonacciSeq(index));
  }

  @Test
  void fibonacciSeq2() {
    int index = 2;
    int expectedResult = 3;
    assertEquals(expectedResult, testing.fibonacciSeq(index));
  }

  @Test
  void fibonacciSeq3() {
    int index = 3;
    int expectedResult = 5;
    assertEquals(expectedResult, testing.fibonacciSeq(index));
  }

  @Test
  void fibonacciSeq10() {
    int index = 10;
    int expectedResult = 144;
    assertEquals(expectedResult, testing.fibonacciSeq(index));
  }

  @Test
  void fibonacciSeqNegativeNumber() {
    int index = -2;
    int expectedResult = 0;
    assertEquals(expectedResult, testing.fibonacciSeq(index));
  }

}