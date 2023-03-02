//Name: Kristiyan Stoilov
//Student ID: 260990847

public class Component extends ComputerDecorator{
    private String componentName;
    private double componentPrice;

    Component(Computer computer, String componentName, double componentPrice) {
        super(computer);
        this.componentName=componentName;
        this.componentPrice=componentPrice;
    }

    public void setComponentName(String componentName){
        this.componentName = componentName;
    }

    public void setComponentPrice(double componentPrice) {
        this.componentPrice = componentPrice;
    }

    public String getComponentName() {
        return componentName;
    }

    public double getComponentPrice() {
        return componentPrice;
    }
}
