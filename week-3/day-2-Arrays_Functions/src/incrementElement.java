public class incrementElement {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int fixed = numbers[2];
//Var1: Výsledek je 4,5,6,10,11 z důvodu, že v kroku 3 se změní proměnná numbers[2] z 3 na 6, a dále se přičítá 6
//Var2: ?? Mohu napravit tím, že vložím novou proměnnou, která na počátku vyčte hodnotu numbers[2] - čili 3, a dále se již nezmění???

//Var1:
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]= numbers[i] + numbers[2];
            System.out.println(numbers[i]);
        }
        System.out.println();
        System.out.println("The output of numbers[2] in Var1 is: " + numbers[2]);
        System.out.println();

//Var2: !!NEFUNKČNÍ!! tato varianta chtěla zachovat fixní přírůstek o 3, čili používá proměnnou fixed definovanou zpočátku. Ale nefunguje to takto :-(
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]= numbers[i] + fixed;
            System.out.println(numbers[i]);
        }
        System.out.println();
        System.out.println("The output of numbers[2] in Var2 is: " + numbers[2]);
    }
}

