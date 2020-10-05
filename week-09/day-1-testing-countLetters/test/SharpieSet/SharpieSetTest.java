package SharpieSet;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class SharpieSetTest {

  SharpieSet testSet = new SharpieSet();
  Sharpie sharpie = new Sharpie("blue", 24f);

  @Test
  void addSharpie_1sharpie() {
    testSet.addSharpie(sharpie);
    assertEquals(1,testSet.numberOfSharpies());
  }

  @Test
  void addSharpie_2sharpies() {
    testSet.addSharpie(sharpie);
    testSet.addSharpie(sharpie);
    assertEquals(2,testSet.numberOfSharpies());
  }

  @Test
  void numberOfSharpies_0sharpies() {
    assertEquals(0,testSet.numberOfSharpies());
  }

  @Test
  void countUsable_2_AllNotEmpty() {
    Sharpie sharpie2 = new Sharpie("black", 30f);
    testSet.addSharpie(sharpie);
    testSet.addSharpie(sharpie2);
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    assertEquals(2, testSet.countUsable());
  }

  @Test
  void countUsable_1_OneEmpty() {
    Sharpie sharpie2 = new Sharpie("black", 30f);
    testSet.addSharpie(sharpie);
    testSet.addSharpie(sharpie2);
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    assertEquals(1, testSet.countUsable());
  }

  @Test
  void removeTrash_removed1Sharpie() {
    Sharpie sharpie2 = new Sharpie("black", 30f);
    testSet.addSharpie(sharpie);
    testSet.addSharpie(sharpie2);
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    testSet.removeTrash();
    assertEquals(1, testSet.numberOfSharpies());
  }

  @Test
  void removeTrash_removed2Sharpie() {
    Sharpie sharpie2 = new Sharpie("black", 30f);
    testSet.addSharpie(sharpie);
    testSet.addSharpie(sharpie2);
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    sharpie2.use();
    sharpie.use();
    sharpie.use();
    sharpie.use();
    sharpie.use();
    sharpie.use();
    testSet.removeTrash();
    assertEquals(0, testSet.numberOfSharpies());
  }
}