
// Name: Kristiyan Stoilov
import java.util.Scanner;

public class LeftTriangle {
    public static void main(String[] args) {
        int number = input();
        if (number >= 0) {
            printLeftTriangle(number);
        } else {
            System.out.println("Error: input value must be >= 0");
        }
    }

    // Taking user input for amount of rows.
    public static int input() {
        System.out.println("Enter the amount of rows:");
        Scanner inputNumber = new Scanner(System.in);
        int number = inputNumber.nextInt();
        return number;
    }

    // Printing the left triangle.
    public static void printLeftTriangle(int number) {
        // Amount of rows
        for (int i = 1; i <= number; i++) {
            // Amount of stars
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}