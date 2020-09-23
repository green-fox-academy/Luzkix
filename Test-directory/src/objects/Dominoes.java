package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dominoes {
  public static void main(String[] args) {
    List<Domino> dominoes = initializeDominoes();
    // You have the list of Dominoes
    // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
    // eg: [2, 4], [4, 3], [3, 5] ...

    Collections.sort(dominoes); //sorting the list based on comparable method
    List<Domino> tempDominoes = new ArrayList<>();
    tempDominoes.add(dominoes.get(0)); //this will be the first domino in row

    for (int i = 1; i < dominoes.size(); i++) {
      for (int j = 1; j < dominoes.size(); j++) {
        if (dominoes.get(j).getLeftSide() == tempDominoes.get(i-1).getRightSide()) {
          tempDominoes.add(dominoes.get(j));
        }
      }
    }
    dominoes = tempDominoes;
    System.out.println(dominoes);
  }

  static List<Domino> initializeDominoes() {
    List<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(5, 2));
    dominoes.add(new Domino(4, 6));
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(6, 7));
    dominoes.add(new Domino(2, 4));
    dominoes.add(new Domino(7, 1));
    return dominoes;
  }


}