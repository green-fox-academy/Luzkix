package orderbyfreq;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class OrderbyfreqTest {

  @Test
  public void orderByFrequency_finalSize3() {
    List<Integer> example1 = new ArrayList<>();
    example1.addAll(Arrays.asList(1, 1, 1, 2, 2, 3));
    int expectedSizeOfFinalArray = 3;
    assertEquals(expectedSizeOfFinalArray, Orderbyfreq.orderByFrequency(example1).size());
  }

  @Test
  public void orderByFrequency_example1() {
    List<Integer> example1 = new ArrayList<>();
    example1.addAll(Arrays.asList(1, 1, 1, 2, 2, 3));
    List<Integer> result = new ArrayList<>();
    result.addAll(Arrays.asList(3, 2, 1));
    assertEquals(result, Orderbyfreq.orderByFrequency(example1));;
  }
}