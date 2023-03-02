import java.util.ArrayList;
import java.util.List;

//Name: Kristiyan Stoilov
//Student ID: 260990847

public class SortByPrice implements SortStrategy {
    @Override
    public void sort(ArrayList<Computer> cart) {
        // Lost internet reference (if needed to re-do, let me know)
        cart.sort((a,b)->(int) (b.getPrice()-a.getPrice()));
    }
}
