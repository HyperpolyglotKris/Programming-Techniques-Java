
// Name: Kristiyan Stoilov
import java.util.Date;

public class AndhraBankAccount {
    // All the static variables of this class
    private static double annualInterestRate;
    private static int nextAccountNb = 300;
    // All the other variables of this class
    private int accountNb;
    private String f_name;
    private String l_name;
    private double balance;
    private Date dateCreated;

    // Constructor for an ojbect
    public AndhraBankAccount(String firstName, String lastName, double initialBalance) {
        f_name = firstName;
        l_name = lastName;
        balance = initialBalance;
        // Assign account number and change the static nextAccountNumber
        accountNb = nextAccountNb;
        nextAccountNb++;
        dateCreated = new Date();
    }

    // Accessor for Account Number
    public int getAccountNb() {
        return accountNb;
    }

    // Accessor for First Name
    public String getFirstName() {
        return f_name;
    }

    // Accessor for Last Name
    public String getLastName() {
        return l_name;
    }

    // Accessor for Balance
    public double getBalance() {
        return balance;
    }

    // Mutator for Balance
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    // Accessor for Annual Interest Rate
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Mutator for Annual Interest Rate
    public static void setInterestRate(double interestRate) {
        annualInterestRate = interestRate;
    }

    // Accessor for Date Created
    public Date getDateCreated() {
        return dateCreated;
    }
}