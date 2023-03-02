import java.util.Map;
import java.util.Scanner;

//Name: Kristiyan Stoilov
//Student ID: 260990847

public class Main {
    private static MarketSpace marketSpace;
    public static void main(String[] args) {
        // Create MarketSpace and Load Products
        marketSpace = MarketSpace.getInstance();
        marketSpace.loadProducts();
        Map<String, Double> products = marketSpace.getProducts();

        Scanner input = new Scanner(System.in);
        char choice;
        do {
            displayOptions();
            choice = input.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    marketSpace.addOrder();
                    do {
                        displayProductsList(products);
                        if (products.get(choice)== null) {
                            break;
                        }
                    } while (choice != '9');
                    break;
                case '2':
                    marketSpace.showCart();

                    break;
                case '3':
                    marketSpace.setSortStrategy(new SortByOrderID());
                    marketSpace.sort();
                    break;
                case '4':
                    marketSpace.setSortStrategy(new SortByPrice());
                    marketSpace.sort();
                    break;
                case '5':
                    break;
                default:
                    System.out.println("Please enter a valid input.");
            }
        } while (choice!='5');

    }

    public static void displayOptions() {
        System.out.println("Hi, what would you like to do?\n1: Buy a computer\n2: See my shopping cart\n3: Sort by order ID (Descending order)\n4: Sort by order price (Descending order)\n5: Quit");
    }

    public static void displayProductsList(Map<String, Double> products) {
        System.out.println("What component would you like to add?");
        int i=0;
        for (String name: products.keySet()){
            i++;
            String value = products.get(name).toString();
            System.out.println(i+"."+name+", "+value + "$");
        }
        System.out.println(products.size() +1+ ": Done");
    }
}