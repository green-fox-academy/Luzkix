import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.ls.LSOutput;

public class TelephoneBook {
  public static void main(String[] args) {
    HashMap<String, String> phoneBook = new HashMap<>();
    phoneBook.put("William A. Lathan", "405-709-1865");
    phoneBook.put("John K. Miller", "402-247-8568");
    phoneBook.put("Hortensia E. Foster", "606-481-6467");
    phoneBook.put("Amanda D. Newland", "319-243-5613");
    phoneBook.put("Brooke P. Askew", "307-687-2982");
    System.out.println(phoneBook);

    //1. vrať telefonní číslo od John K. Miller - určím proměnnou co hledám,
    // určím proměnnou, co se má vrátit, nechám automaticky vytvořit methodu a vytisknu výsledek:
    String friendsName = "John K. Miller";
    String tellPhonenumber = extractPhoneNumber(phoneBook, friendsName);
    System.out.println(extractPhoneNumber(phoneBook, "John K. Miller"));

    //2. Zjisti komu patří telefon: 307-687-2982? - zde jsem vše (kromě println, což nešlo) dal již do funkce,
    // takže jen uvedu sout + název funkce a její parametry
    System.out.println(extractOwnersName(phoneBook, "307-687-2982"));


    //3. Zjisti zda je Chris E. Myer v seznamu. Pokud ano, uveď jeho číslo
    // String doWeKnowHim = detectKey(phoneBook);
    System.out.println(doWeKnowHim(phoneBook, "Brooke P. Askew"));


  }

  private static String extractPhoneNumber(HashMap<String, String> phoneBook, String friendsName) {
    String phonenumber = "Number of " + friendsName + " is " + phoneBook.get(friendsName);
    return phonenumber;
  }

  private static String extractOwnersName(HashMap<String, String> phoneBook, String phoneNumber) {
    String indexOfPhoneNumber = null;
    for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
      if (phoneNumber.equals(entry.getValue())) {
        indexOfPhoneNumber = entry.getKey();
        break;//to z důvodu, kdyby se ta hodnota vyskytla znova jinde, tak ať mi nepřepíše tu první detekovanou
      }
    }
    return "The name of phone number holder is: " + indexOfPhoneNumber;
  }

  private static String doWeKnowHim(HashMap<String, String> phonebook, String friendsName) {
    String finalSentence = null;
    for (String key : phonebook.keySet()) {
      if (friendsName.equals(key)) {
        finalSentence = (friendsName + " is in your phonebook and his/her number is: " + phonebook.get(friendsName));
        break;
      } else {
        finalSentence = (friendsName + " was not found in your phonebook!!!");
      }
    }
    return finalSentence;
  }


}