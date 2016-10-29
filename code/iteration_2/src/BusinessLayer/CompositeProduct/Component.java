package BusinessLayer.CompositeProduct;

import java.io.IOException;

import DataLayer.DataControl;

public abstract class Component implements Part {

    private int componentId;
    private String componentName;
    private int stock;
    private double price;
    private String typeOfComponent;

    /**
     * Construct a new component using the provided item
     * and price.
     *
     * @param componentId the componentId of the component.
     * @param stock the amount left to sell for the component
     * @param componentName the componentName of the component.
     */
    public Component(int componentId, String componentName, double price, String typeOfComponent) {
        this.componentId = componentId; //Generate new Id function should be used here
        this.componentName = componentName;
        this.stock = 2;
        this.price = price;
        this.typeOfComponent = typeOfComponent;
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
	
    public String getComponentDetails() {
        return "\nComponent ID: " + this.componentId + "\nComponent Name: " + this.componentName + "\nStock: " + this.stock + 
        		"\nPrice: " + this.price + "\nType: " + this.typeOfComponent;
    }
    public void decrementStock() {
		try {
			DataControl.adjustStock(this.componentName, "decrement");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void addStock() {
    	try {
			DataControl.adjustStock(this.componentName, "increment");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public String toString(){
		String output;
		output = componentId + "," +  componentName + "," + stock  + "," + price  + "," + typeOfComponent;
		return output;
	}
}