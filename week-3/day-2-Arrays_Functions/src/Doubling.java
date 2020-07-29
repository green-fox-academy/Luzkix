public class Doubling {
  public static void main(String[] args) {
    int baseNum = 123;
    System.out.println(doubling(baseNum));

    //test - funkci mohu aplikovat nejen na prměnnou ale i konkrétní hodnotu
    System.out.println(doubling(40));

  }

  //int-formát výstupu funkce  //(int numberToBeDoubled) - formát a název vstupu
  // - ten vstup nesouvisí s proměnnou v main, je univerzální
  // a naplní se až v main konkrétní proměnnou
  public static int doubling(int numberToBeDoubled) {
    int doubledNumber = numberToBeDoubled * 2;
    return doubledNumber;

  }
}
