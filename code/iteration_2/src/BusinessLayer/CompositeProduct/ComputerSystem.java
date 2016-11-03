package BusinessLayer.CompositeProduct;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ComputerSystem extends Component{

    private String OS;
    private ArrayList<Component> components;

    public ComputerSystem(int componentId, String componentName, String typeOfComponent, double unitCost, String OS) {
        super(componentId, componentName, 0, typeOfComponent);
        this.OS = OS;
        this.components = new ArrayList<Component>();
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
    
    public Part getChildAtIndex(int i) {
        return components.get(i);
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public double getUnitCost() {
    	double unitCost = 0;
    	if(components.size() > 0){
    		for (int i = 0; i < components.size(); i++) {
    			unitCost += components.get(i).getPrice();
    		}
    	}
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
    			summary += "\n\nTotal Price = " + new DecimalFormat("##.##").format(getUnitCost());
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
