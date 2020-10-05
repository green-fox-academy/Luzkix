import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SumTest {

  @Test
  void sumMultipleElements() {
    Sum testObject = new Sum();
    ArrayList<Integer> numberList = new ArrayList<>();
    numberList.add(1);
    numberList.add(2);
    numberList.add(3);
    numberList.add(-4);
    assertEquals(2, testObject.sum(numberList));
  }
  @Test
  void sumZeroArray() {
    Sum testObject = new Sum();
    ArrayList<Integer> numberList = new ArrayList<>();
    assertEquals(0, testObject.sum(numberList));
  }
  @Test
  void oneElementArray() {
    Sum testObject = new Sum();
    ArrayList<Integer> numberList = new ArrayList<>();
    numberList.add(5);
    assertEquals(5, testObject.sum(numberList));
  }

  @Test
  void nullIntegerInArray() throws NullPointerException{
    Sum testObject = new Sum();
    ArrayList<Integer> numberList = new ArrayList<>();
    numberList.add(null);
    numberList.add(2);
    assertEquals(2, testObject.sum(numberList));
  }

}