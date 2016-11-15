package BusinessLayer.CompositeProduct;

import BusinessLayer.VisitorShipping.VisitableElement;
import BusinessLayer.VisitorShipping.Visitor;

public class Keyboard extends Component implements VisitableElement {
    private String keySwitchType;
    private boolean backlit;

    public Keyboard(int componentId, String componentName, double price, String typeOfComponent, String keySwitchType, boolean backlit, double weight) {
        super(componentId, componentName, price, typeOfComponent, weight);
        this.keySwitchType = keySwitchType;
        this.backlit = backlit;
    }

    public String getKeySwitchType() {
        return keySwitchType;
    }

    public void setKeySwitchType(String keySwitchType) {
        this.keySwitchType = keySwitchType;
    }

    public boolean isBacklit() {
        return backlit;
    }

    public void setBacklit(boolean backlit) {
        this.backlit = backlit;
    }
    
    public String getComponentDetails(){
   	 return super.getComponentDetails() + "\nKeySwitchType: " + this.keySwitchType + "\nBacklit: " + this.backlit;
   }
    
    public String toString(){
		String output;
		output = super.toString();
		output += "," + keySwitchType + "," + backlit;
		return output;
	}

    // For Visitor
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
