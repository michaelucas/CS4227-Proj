package BusinessLayer.CompositeProduct;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ComputerSystem extends Component{

    private String OS;
    private ArrayList<Component> components;
    private double shippingCost;

    public ComputerSystem(int componentId, String componentName, String typeOfComponent, String OS, double weight) {
        super(componentId, componentName, 0, typeOfComponent, weight);
        this.OS = OS;
        this.components = new ArrayList<Component>();
        this.shippingCost = 0.0;
    }

    public void addComponent(Component component) {
    	components.add(component);
    }
    
    public ArrayList<Component> getComponents() {
        return components;

    }

    public void removeComponent(Part component) {
    	components.remove(component);
    }
    
    public Component getChildAtIndex(int i) {
        return components.get(i);
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }
    
    public void setShippingCost(double shippingCost) {
    	this.shippingCost = shippingCost;
    }

    public double getPrice() {
    	double unitCost = 0;
    	if(components.size() > 0){
    		for (int i = 0; i < components.size(); i++) {
    			unitCost += components.get(i).getPrice();
    		}
    	}
    	unitCost += shippingCost;
		return unitCost;
    }
    
    public String getComponentDetails(){
    	return super.getComponentDetails() + "\nOperating System: " + this.OS;
    }
    public String getSummary() {
    	String summary = "";
    	if(components.size() > 0){
    		for (int i = 0; i < components.size(); i++) {
    			String compInfo = components.get(i).getComponentName() + "\t\t:" + components.get(i).getPrice() + "\n";
    			summary += compInfo;
    		}
    		summary += "\nShipping Cost = " + new DecimalFormat("##.##").format(shippingCost);
    		summary += "\nTotal Price incl. Shipping = " + new DecimalFormat("##.##").format(getPrice()) + "\n";
    	}
    	return summary;
    }
    
    public String toString(){
		String output;
		output = super.toString();
		output += "," + OS;
		return output;
	}
	
    public void clear() {
    		components.removeAll(components);
    }
 }
