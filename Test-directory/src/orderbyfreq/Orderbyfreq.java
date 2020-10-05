package orderbyfreq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orderbyfreq {
  public static void main(String[] args) {
    List<Integer> example1 = new ArrayList<>();
    example1.addAll(Arrays.asList(1, 1, 1, 2, 2, 3));
    List<Integer> example2 = new ArrayList<>();
    example2.addAll(Arrays.asList(8, 9, 3, 8, 9, 9, 9, 3, 1, 1));
    System.out.println(orderByFrequency(example2));;

  }

  public static List<Integer> orderByFrequency(List<Integer> example1) {
    HashMap<Integer, Integer> counts = new HashMap<>();
    for(Integer number : example1) {
      if (counts.containsKey(number)) {
        counts.put(number, counts.get(number)+1);
      } else counts.put(number, 1);
    }

    List<Integer> ordered = new ArrayList<>(counts.values());
    Collections.sort(ordered);

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < ordered.size(); i++) {
      for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        if (ordered.get(i) == entry.getValue()) {
          result.add(entry.getKey());
          counts.remove(entry.getKey());
          break;
        }
      }
    }
    return result;
  }
}
