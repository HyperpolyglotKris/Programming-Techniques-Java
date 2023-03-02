import java.util.List;

//Name: Kristiyan Stoilov
//Student ID: 260990847

public class Order implements Computer {
    private String componentName = "Default Computer";
    private double componentPrice = 700.00;
    private String componentId;

    @Override
    public String getDescription() {
        return componentName;
    }

    @Override
    public double getPrice() {
        return componentPrice;
    }

    @Override
    public String getOrderID() {
        return componentId;
    }

    @Override
    public List<Component> getComponents() {
        return null;
    }

    public Order(int id){
        this.componentId = ""+id;
    }
}
