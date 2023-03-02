
// Name: Kristiyan Stoilov
import java.util.Scanner;

public class AndhraBankAccountDriver {

    // Main method, executing everything needed
    public static void main(String[] args) {
        welcomeMessage();
        AndhraBankAccount.setInterestRate(4.5);
        displayTodayInterest();
        double initialBalance = 100;
        AndhraBankAccount user1 = new AndhraBankAccount(firstName(), lastName(), initialBalance);
        displayInformation(user1);
        userInterraction(user1);
        newBalance(user1);
        byeMessage();
    }

    // Printing the welcome message
    private static void welcomeMessage() {
        System.out.println("Welcome to ANDHRA Bank");
        // Empty line to follow example
        System.out.println();
    }

    // Printing the goodbye message
    private static void byeMessage() {
        System.out.println("Good-Bye!");
    }

    // User input for first name
    private static String firstName() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = inputScanner.nextLine();
        return firstName;
    }

    // User input for last name
    private static String lastName() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter last name: ");
        String lastName = inputScanner.nextLine();
        // Empty line to follow example
        System.out.println();
        return lastName;
    }

    // Displaying today's interest rate
    private static void displayTodayInterest() {
        // Variable refers to class's static public method
        System.out.println("Today's Interest Rate is = " + AndhraBankAccount.getAnnualInterestRate() + "%");
        System.out.println();
    }

    // Regroupment of all the information that needs to be displayed to user
    // All variables refer to the object's public methods
    private static void displayInformation(AndhraBankAccount user1) {
        System.out.println("Your account details are: ");
        String fullName = user1.getFirstName() + " " + user1.getLastName();
        int accountNb = user1.getAccountNb();
        double balance = user1.getBalance();
        // Variable refers to class's static public method
        double interestRate = AndhraBankAccount.getAnnualInterestRate();
        // Printing all the information for user
        System.out.println("Name is: " + fullName);
        System.out.println("Account Number is " + accountNb);
        System.out.println("Current balance is $" + balance);
        System.out.println("Interest Rate is = " + interestRate + "%");
        System.out.println("Monthly interest for this balance is $" + getMonthlyInterestRate(balance));
        System.out.println("This account was created on " + user1.getDateCreated());
        // Empty line to follow example
        System.out.println();
    }

    // Calculating monthly interest rate and the monthly interest given the balance
    private static double getMonthlyInterestRate(double balance) {
        double monthlyInterestRate = AndhraBankAccount.getAnnualInterestRate() / 12;
        double monthlyInterest = balance * monthlyInterestRate / 100;
        return monthlyInterest;
    }

    // Asking user for wanted action
    private static void userInterraction(AndhraBankAccount user1) {
        System.out.print("Enter your choice (0: deposit, 1: withdraw, 2: quit): ");
        int action = Integer.parseInt(interractionInput());
        // Making sure that inputs are valid
        if (action < 0 || action > 2) {
            System.out.println("INVALID INPUT");
            userInterraction(user1);
        }
        // If 0 then deposit
        if (action == 0) {
            deposit(user1);
        }
        // If 1 then withdraw
        if (action == 1) {
            withdraw(user1);
        }
        // If 2 then exit
        if (action == 2) {
            System.out.println();
            return;
        }
    }

    // User input for the wanted action or wanted amount
    private static String interractionInput() {
        Scanner inputScanner = new Scanner(System.in);
        String interraction = inputScanner.nextLine();
        return interraction;
    }

    // User's deposit amount and change the balance in object's variables
    private static void deposit(AndhraBankAccount user1) {
        System.out.print("Enter the amount in $");
        double amount = Double.parseDouble(interractionInput());
        // Empty line to follow example
        System.out.println();
        // Verifying that the deposited amount is not negative
        if (amount <= 0) {
            System.out.println("INVALID INPUT");
            userInterraction(user1);
            return;
        }
        user1.setBalance(user1.getBalance() + amount);
        userInterraction(user1);
    }

    // User's withdraw amount and change the balance in object's variables
    private static void withdraw(AndhraBankAccount user1) {
        System.out.print("Enter the amount in $");
        double amount = Double.parseDouble(interractionInput());
        // Empty line to follow example
        System.out.println();
        // Verifying that the withdraw amount is not bigger than current balance
        if (amount > user1.getBalance()) {
            System.out.println("INVALID INPUT");
            userInterraction(user1);
            return;
        }
        user1.setBalance(user1.getBalance() - amount);
        userInterraction(user1);
    }

    // Displaying the new balance
    private static void newBalance(AndhraBankAccount user1) {
        System.out.println("New balance is $" + user1.getBalance());
    }
}