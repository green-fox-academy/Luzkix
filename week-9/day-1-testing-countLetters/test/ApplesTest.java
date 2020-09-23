import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ApplesTest {

@Test
  void getName() throws Exception {
  Apple apple = new Apple();
  apple.name = "apple";
  assertEquals("apple", apple.getName());

  }
}