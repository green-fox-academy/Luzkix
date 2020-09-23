import java.util.HashMap;

public class NumberConverter {

  public static void main(String[] args) {
    System.out.println(convertNumberToString(1980674));
  }

  public static String convertNumberToString(int input){
    String result = "";
    if (input < 1 || input > Integer.MAX_VALUE ){
      return "no conversion of zero or negative nr. or number bigger than int max value";
    }

    String inputStr = Integer.toString(input);
    HashMap<Integer,String> mapIntStr = new HashMap<>();
    populateMap(mapIntStr);
    HashMap<String,Integer> mapStrInt = new HashMap<>();
    populateMapStringInt(mapStrInt);
    result = intToStringTransfer(mapIntStr, inputStr);


    return result + "USD";
  }

  private static String intToStringTransfer(HashMap<Integer,String> mapIntStr, String inputStr ) {
    String result = "";
    for (int i = 0; i < inputStr.length(); i++){
      int each = Integer.parseInt(inputStr.substring(i,i+1));
      if (mapIntStr.containsKey(each)){
        result += mapIntStr.get(each);
      }
    }
    return result;
  }

  private static void populateMapStringInt(HashMap<String,Integer> mapStrInt) {
    mapStrInt.put("one ", 1);
    mapStrInt.put("two ", 2);
    mapStrInt.put("three ", 3);
    mapStrInt.put("four ", 4);
    mapStrInt.put("five ", 5);
    mapStrInt.put("six ", 6);
    mapStrInt.put("seven ", 7);
    mapStrInt.put("eight ", 8);
    mapStrInt.put("nine ", 9);
    mapStrInt.put("ten ", 0);
  }

  private static void populateMap(HashMap<Integer,String> mapIntStr) {
    mapIntStr.put(1,"one ");
    mapIntStr.put(2,"two ");
    mapIntStr.put(3,"three ");
    mapIntStr.put(4,"four ");
    mapIntStr.put(5,"five ");
    mapIntStr.put(6,"six ");
    mapIntStr.put(7,"seven ");
    mapIntStr.put(8,"eight ");
    mapIntStr.put(9,"nine ");
    mapIntStr.put(0,"ten ");
  }

  //It occurs now and then in real life that people want to write about money,
  // especially about a certain amount of money. If it comes to cheques or contracts for
  // example some nations have laws that state that you should write out the amount in words
  // additionally to the amount in numbers to avoid fraud and mistakes. So if you want to transfer
  // 745 $ to someone via cheque you have to fill out to fields:
  //
  //745.00 $ (amount in numbers)
  //
  //seven hundred and fourty five dollars (amount in words)
  //
  //The Kata is now to write a little converter class or function
  // (depends on your favourite language and flavour) to convert numbers into words.
  //Convert it back.
}