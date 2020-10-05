package Counter;

public class Counter {

  int counter = 0;

  public Counter () {
  }

  public Counter (int number) {
    this.counter = number;
  }

  public void add (int number) {
    counter += number;
  }

  public void add () {
    counter += 1;
  }

  public int get() {
    return counter;
  }

  public void reset() {
    this.counter = 0;
  }
}
