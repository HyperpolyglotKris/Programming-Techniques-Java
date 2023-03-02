
// Name: Kristiyan Stoilov
import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        int number = input();
        if (number >= 0) {
            printRightTriangle(number);
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

    // Printing the right triangle.
    public static void printRightTriangle(int number) {
        // Amount of rows
        for (int i = 1; i <= number; i++) {
            // Amount of spaces
            for (int j = number - i; j >= 0; j--) {
                System.out.print(" ");
            }
            // Amount of stars
            for (int j = number - i; j < number; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}