public class CompareLength {
    public static void main(String[] args) {
        int[] firstArrayOfNumbers = {1, 2, 3};
        int[] secondArrayOfNumbers = {4, 5};

        if (secondArrayOfNumbers.length > firstArrayOfNumbers.length) {
            System.out.println("secondArrayOfNumbers is longer and its lenght is: " + secondArrayOfNumbers.length);
        } if (firstArrayOfNumbers.length > secondArrayOfNumbers.length) {
            System.out.println("firstArrayOfNumbers is longer and its lenght is: " + firstArrayOfNumbers.length);
        }

    }
}
