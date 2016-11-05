package BusinessLayer.CompositeProduct;

import BusinessLayer.VisitorShipping.VisitableElement;
import BusinessLayer.VisitorShipping.Visitor;

public class GPU extends Component implements VisitableElement {

    private String memory;
    private int displayPorts;

    public GPU(int componentId, String componentName, double price, String typeOfComponent, String memory, int displayPorts, double weight) {
        super(componentId, componentName, price, typeOfComponent, weight);
        this.memory = memory;
        this.displayPorts = displayPorts;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public int getDisplayPorts() {
        return displayPorts;
    }

    public void setDisplayPorts(int displayPorts) {
        this.displayPorts = displayPorts;
    }
    
    public String getComponentDetails(){
   	 return super.getComponentDetails() + "\nGPU Memory: " + this.memory + "\nGPU DisplayPorts" + this.displayPorts;
   }
    
    public String toString(){
		String output;
		output = super.toString();
		output += "," + memory + "," + displayPorts;
		return output;
	}

    // For Visitor
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
