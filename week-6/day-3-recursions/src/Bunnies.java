public class Bunnies {
  public static void main(String[] args) {
//We have a number of bunnies and each bunny has two big floppy ears.
// We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
    System.out.println(bunny(8));

  }

  private static int bunny(int bunnies) {
    if (bunnies == 1) {
      return 2;
    }
    return 2 + bunny(bunnies - 1);
  }


}
