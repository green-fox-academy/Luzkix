package Counter;
public class CounterApp {
  public static void main(String[] args) {
    Counter counter1 = new Counter();
    counter1.add(2);
    counter1.add();
    System.out.println(counter1.get());
    counter1.reset();
    System.out.println(counter1.get());



  }
}
