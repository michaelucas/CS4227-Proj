
public class Component implements Part {

    private int componentId;
    private String componentName;
    private int stock;

    /**
     * Construct a new component using the provided item
     * and price.
     *
     * @param componentId the componentId of the component.
     * @param stock the amount left to sell for the component
     * @param componentName the componentName of the component.
     */
    public Component(int componentId, String componentName, int stock) {
        this.componentId = componentId; //Generate new Id function should be used here
        this.componentName = componentName;
        this.stock = stock;
    }
    public int getComponentId() {
        return componentId;
    }
    public void setComponentId(int newComponentId) {
        componentId =  newComponentId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String newComponentName) {
        componentName =  newComponentName;
    }
    

    public int getStock() {
        return stock;
    }

    public void setStock(int newStock) {
        stock =  newStock;
    }

    public String getComponentDetails() {
        return "\nComponent ID: " + this.componentId + "\nComponent Name: " + this.componentName + "\nStock: " + this.stock + "\n";
    }

    public void decrementStock() {
        stock--;
    }

    public void addStock() {
        stock++;
    }
}