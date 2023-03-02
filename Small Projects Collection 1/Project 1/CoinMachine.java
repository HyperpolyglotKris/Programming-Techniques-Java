
// Name: Kristiyan Stoilov
import java.util.Scanner;

public class CoinMachine {
    public static void main(String args[]) {
        // Calling the following method for execution
        transaction();
    }

    // Method that will take care of the whole transaction (Inputs and Outputs)
    public static void transaction() {
        Scanner reader = new Scanner(System.in);

        // Asking for user input for cash and price
        System.out.println("Enter the amount of money dropped into the machine (in cents):");
        int cash = reader.nextInt();
        System.out.println("Enter the cost of the item wanted by the customer (in cents):");
        int price = reader.nextInt();
        // Calculating the change
        int change = cash - price;

        // Displaying inputs and calculated change to user
        System.out.println(); // Empty line for aesthetic, marking start of results
        System.out.println("Amount received: " + cash);
        System.out.println("Cost of the item: " + price);
        System.out.println("Required change: " + change);
        System.out.println(); // Empty line for matching assignment examples
        System.out.println("Change:");

        // Calculating most convenient exact change
        // Toonies
        if (change / 200 >= 1) {
            int toonie = (int) change / 200;
            System.out.println("    Toonies x " + toonie);
            change = change - toonie * 200;
        } else {
            System.out.println("    Toonies x 0");
        }
        // Loonies
        if (change / 100 >= 1) {
            int loonie = (int) change / 100;
            System.out.println("    Loonies x " + loonie);
            change = change - loonie * 100;
        } else {
            System.out.println("    Loonies x 0");
        }
        // Quarters
        if (change / 25 >= 1) {
            int quarter = (int) change / 25;
            System.out.println("    Quarters x " + quarter);
            change = change - quarter * 25;
        } else {
            System.out.println("    Quarters x 0");
        }
        // Dimes
        if (change / 10 >= 1) {
            int dime = (int) change / 10;
            System.out.println("    Dimes x " + dime);
            change = change - dime * 10;
        } else {
            System.out.println("    Dimes x 0");
        }
        // Nickels
        if (change / 5 >= 1) {
            int nickel = (int) change / 5;
            System.out.println("    Nickels x " + nickel);
            change = change - nickel * 5;
        } else {
            System.out.println("    Nickel x 0");
        }
    }
}