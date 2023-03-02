import java.io.*;
import java.sql.Array;
import java.util.*;

//Name: Kristiyan Stoilov
//Student ID: 260990847

// Singleton pattern
// Load all side products from file "products.txt"
public class MarketSpace {
    private ArrayList<Computer> cart = new ArrayList();
    private Map<String,Double> products;
    private static MarketSpace instance;
    private SortStrategy sortStrategy;

    public void loadProducts() {
        if (products!=null) return;
        try {
            products = new HashMap<>();
            Scanner scanner = new Scanner(new File("products.txt"));
            while (scanner.hasNext()) {
                String scannerLine = scanner.nextLine();
                String[] scannerString = scannerLine.split(",");
                products.put(scannerString[0], Double.valueOf(scannerString[1]));
            }
        } catch (Exception exception) {
        System.out.println(exception);
        }
    }

    public void showCart(){
        if (this.cart==null || this.cart.size() == 0) {
            System.out.println("Empty Cart");
        } else {
            System.out.print("[");
            for (int i = 0; i<cart.size(); i++){
                System.out.print("OrderID@" + cart.get(i).getOrderID() + ": " + cart.get(i).getDescription());
                showTotalPrice(cart.get(cart.size()-1).getPrice());
            }
        }
    }

    public static MarketSpace getInstance() {
        if (instance == null) instance = new MarketSpace();
        return instance;
    }

    public void sort() {
        if (this.cart==null) {
            System.out.println("Empty Cart");
        } else {
            sortStrategy.sort(cart);
        }
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
            this.sortStrategy = sortStrategy;
    }

    public void addOrder() {
        Computer defaultComputer = new Order(getRandomUniqueId());
        cart.add(defaultComputer);
    }

    private int getRandomUniqueId(){
        // Create new random integer
        Random random = new Random();
        int randomInt = random.nextInt(100) +1;
        // Verify if an element in cart already has the same ID
        for (int i =0; i<cart.size(); i++) {
            if (Integer.valueOf(cart.get(i).getOrderID())==randomInt) {
                randomInt = getRandomUniqueId();
            }
        }
        // Return the unique random integer
        return randomInt;
    }

    public void showTotalPrice(double price) {
        System.out.println(" $"+ price);
    }

    public Map<String,Double> getProducts() {
        return products;
    }
}
