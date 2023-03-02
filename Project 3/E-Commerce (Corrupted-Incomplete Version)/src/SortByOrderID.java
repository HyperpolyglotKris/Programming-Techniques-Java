import java.util.ArrayList;
import java.util.List;

//Name: Kristiyan Stoilov
//Student ID: 260990847

public class SortByOrderID implements SortStrategy {
    @Override
    public void sort(ArrayList<Computer> cart) {
        // Lost internet reference (if needed to re-do, let me know)
        cart.sort((a,b)->Integer.parseInt(b.getOrderID())-Integer.parseInt(a.getOrderID()));
    }
}
