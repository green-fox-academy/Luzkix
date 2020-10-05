public class TodoPrint {
  public static void main(String... args){
    String todoText = " - Buy milk\n";
    // Add "My todo:" to the beginning of the todoText
    // Add " - Download games" to the end of the todoText
    // Add " - Diablo" to the end of the todoText but with indention

    // Expected output:

    // My todo:
    //  - Buy milk
    //  - Download games
    //      - Diablo
    String partToAdd1 = "My todo:\n";
    String partToAdd2 = " - Download games\n";
    String partToAdd3 = " - Diablo".indent(4);

    todoText = partToAdd1.concat(todoText.concat(partToAdd2.concat(partToAdd3)));
    System.out.println(todoText);

  }
}