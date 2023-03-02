import java.util.List;

//Name: Kristiyan Stoilov
//Student ID: 260990847

// Decorator Pattern
public class ComputerDecorator implements Computer {
    private String description;
    private double price;
    private String ID;
    private Computer computer;

    ComputerDecorator(Computer computer) {
        this.computer=computer;
    }

    @Override
    public String getDescription() {
        return computer.getDescription();
    }

    @Override
    public double getPrice() {
        return computer.getPrice();
    }

    @Override
    public String getOrderID() {
        return computer.getOrderID();
    }

    @Override
    public List<Component> getComponents() {
        return computer.getComponents();
    }
}