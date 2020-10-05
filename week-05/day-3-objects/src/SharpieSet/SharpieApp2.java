package SharpieSet;

import java.util.ArrayList;
import java.util.List;

public class SharpieApp2 {
  public static void main(String[] args) {
    Sharpie pen1 = new Sharpie("green", 145.23f);
    pen1.use();
    Sharpie pen2 = new Sharpie("yellow", 145.23f);
    Sharpie pen3 = new Sharpie("blue", 145.23f);
    pen3.inkAmount = 0f;

    SharpieSet sharpieList1 = new SharpieSet();
    sharpieList1.addSharpie(pen1);
    sharpieList1.addSharpie(pen2);
    sharpieList1.addSharpie(pen3);

    System.out.println("Number of all sharpies in the set is: " + sharpieList1.numberOfSharpies());
    System.out.println("Number of usable pens is: " + sharpieList1.countUsable());

    sharpieList1.removeTrash();
    System.out.println("Number of all sharpies after removing thrash is: " + sharpieList1.numberOfSharpies());
    System.out.println("Number of usable pens is: " + sharpieList1.countUsable());

  }
}
