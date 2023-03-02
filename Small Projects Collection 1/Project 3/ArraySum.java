
// Name: Kristiyan Stoilov
import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        // Transforming the input number string to integers for calculation of sum
        int first = Integer.parseInt(inputFirst());
        int second = Integer.parseInt(inputSecond());
        // Transforming all the numbers into arrays
        int[] firstArray = transform(first);
        int[] secondArray = transform(second);
        // Calculating with algorithm and printing
        int[] result = sum(firstArray, secondArray);
        print(result);
    }

    // Transforming the given number into a string and then putting the characters
    // of the string into an array
    public static int[] transform(int num) {
        String numberString = Integer.toString(num);
        int[] numberArray = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            // ASCII for any number minus ASCII for '0' is the number itself
            numberArray[i] = numberString.charAt(i) - '0';
        }
        return (numberArray);
    }

    // Prompting the userfor the first number
    public static String inputFirst() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Input the first number: ");
        String firstInput = inputScanner.nextLine();
        return (firstInput);
    }

    // Prompting the user for the second number
    public static String inputSecond() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Input the second number: ");
        String secondInput = inputScanner.nextLine();
        return (secondInput);
    }

    public static int[] sum(int[] x, int[] y) {
        // Initializing the variable result
        int[] result = new int[x.length + 1];
        // Calculating with an extra array space just in case
        for (int i = x.length - 1; i >= 0; i--) {
            result[i + 1] = result[i + 1] + x[i] + y[i];
            if (result[i + 1] >= 10) {
                result[i + 1] = result[i + 1] - 10;
                result[i] = 1;
            }
        }
        // If the array starts with a zero, recalculate without the extra space
        if (result[0] == 0) {
            int[] otherResult = new int[x.length];
            for (int i = x.length - 1; i >= 0; i--) {
                otherResult[i] = otherResult[i] + x[i] + y[i];
                if (otherResult[i] >= 10) {
                    otherResult[i] = otherResult[i] - 10;
                    otherResult[i - 1] = 1;
                }
            }
            return otherResult;
        }
        return result;
    }

    // The print method already given to us to print the array
    public static void print(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "]");
            }
        }
    }
}
