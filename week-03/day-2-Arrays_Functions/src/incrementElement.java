public class incrementElement {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
/*The task was to "- Increment the third element", i.e. to take [3] = 3 and in my understanding to add it to all elements:

Var1: using for loop and adding value of [3] to all elements. Result, however, will be 4,5,6,10,11 from the reason, that
during loop the value of [3] changes from 3 into 6, meaning 6 is then added instead of 3 since 4th element.

Var2: The value of third element stays fixed (i.e. it stays unchanged during loops) by adding a new variable "fixed",
which reads out the value of 3rd element at beginning (=3) and stays unchanged */
        int fixed = numbers[2];

//Var1: simple adding of 3rd element (3) which however changes during third loop into 6 (3+3=6)
        for (int elementIndex = 0; elementIndex < numbers.length; elementIndex++) {
            numbers[elementIndex]= numbers[elementIndex] + numbers[2];
            System.out.println(numbers[elementIndex]);
        }
        System.out.println();
        System.out.println("The output of numbers[2] in Var1 is: " + numbers[2]);
        System.out.println();

//Var2: Created a new variable "fixed" prior using forloop, which fixes the original value of third element (i.e. value 3 stays unchanged)
        for (int elementIndex = 0; elementIndex < numbers.length; elementIndex++) {
            numbers[elementIndex]= numbers[elementIndex] + fixed;
            System.out.println(numbers[elementIndex]);
        }
        System.out.println();
        System.out.println("The output of numbers[2] in Var2 is: " + numbers[2]);
    }
}

