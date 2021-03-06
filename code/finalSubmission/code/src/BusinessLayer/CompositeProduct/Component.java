package BusinessLayer.CompositeProduct;

import java.util.logging.Level;
import java.util.logging.Logger;

import BusinessLayer.ObserverProduct.AdminProductList;
import DataLayer.DataControl;

public abstract class Component implements Part {

    private int componentId;
    private String componentName;
    private double price;
    private String typeOfComponent;
    private double weight;
	private static final Logger LOGGER = Logger.getLogger( AdminProductList.class.getName() );

    /**
     * Construct a new component using the provided item
     * and price.
     *
     * @param componentId the componentId of the component.
     * @param stock the amount left to sell for the component
     * @param componentName the componentName of the component.
     */
    public Component(int componentId, String componentName, double price, String typeOfComponent, double weight) {
        this.componentId = componentId; //Generate new Id function should be used here
        this.componentName = componentName;
        this.price = price;
        this.typeOfComponent = typeOfComponent;
        this.weight = weight;
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
    
    public double getPrice(){
    	return price;
    }
    
    public void setPrice(double newPrice){
    	price = newPrice;
    }
    
	public String getTypeOfComponent() {
		
		return typeOfComponent;
	}
	
	public void setTypeOfComponent(String typeOfComponent) {
		
		this.typeOfComponent = typeOfComponent;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
    public String getComponentDetails() {
        return "\nComponent ID: " + this.componentId + "\nComponent Name: " + this.componentName  + 
        		"\nPrice: " + this.price + "\nType: " + this.typeOfComponent;
    }
    public void decrementStock() {
		try {
			DataControl.adjustStock(this.componentName, "decrement");
		} catch (Exception e) {
            LOGGER.log(Level.SEVERE, "context", e);
		}
    }

    public void addStock() {
    	try {
			DataControl.adjustStock(this.componentName, "increment");
		} catch (Exception e) {
            LOGGER.log(Level.SEVERE, "context", e);
		}
    }
    
    @Override
    public String toString(){
		String output;
		output = componentId + "," +  componentName  + "," + price  + "," + typeOfComponent + "," + weight;
		return output;
	}
}
