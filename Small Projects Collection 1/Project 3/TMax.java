
// Name: Kristiyan Stoilov
import java.util.Random;
import java.util.Scanner;

public class TMax {

    public static void main(String[] args) {
        // Asking for input and storing the long value for the seed
        long seed = input();
        // Showing the seed to the user
        System.out.println("The seed is: " + seed);
        double[] array = getRandomArray(seed);
        // Showing the array to the user
        System.out.println("The array is: ");
        print(array);
        thirdBiggest(array);
    }

    public static long input() {
        // Prompting user for input which is the random seed
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Input the seed number: ");
        String seedInput = inputScanner.nextLine();
        // Converting the input into a long value
        long seed = Long.parseLong(seedInput);
        inputScanner.close();
        return (seed);
    }

    public static double[] getRandomArray(long seed) {
        // The limits for the length of the array
        int lowerBound = 2;
        int upperBound = 10;
        // Setting the random seed
        Random random = new Random(seed);
        // Creating a random array length
        int length = (int) (random.nextInt(10));
        System.out.println("Array Length: " + length);
        // Making sure that it is between 2 and 10 inclusively,
        while (lowerBound > length || length > upperBound) {
            length = (int) (random.nextInt(10));
            System.out.println("Updated Length: " + length);
        }
        double[] array = new double[length];
        // Populating the array with random numbers
        for (int i = 0; i < array.length; i++) {
            array[i] = (random.nextDouble());
        }
        return array;
    }

    public static double thirdBiggest(double[] array) {
        // Sorting a duplicate array from biggest number to smallest
        double[] sortedArray = array;
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] < sortedArray[j]) {
                    double swap = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = swap;
                }
            }
        }
        // If array length is 2, then show 2nd biggest instead
        if (sortedArray.length == 2) {
            System.out.println("The second biggest number is: " + sortedArray[1]);
            return sortedArray[1];
        }
        // Show the 3rd biggest number from the array
        System.out.println("The third biggest number is: " + sortedArray[2]);
        return sortedArray[2];
    }

    // The print statement given to us in ArraySum
    public static void print(double[] array) {
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
