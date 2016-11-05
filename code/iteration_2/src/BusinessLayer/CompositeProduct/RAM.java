package BusinessLayer.CompositeProduct;

import BusinessLayer.VisitorShipping.VisitableElement;
import BusinessLayer.VisitorShipping.Visitor;

public class RAM extends Component implements VisitableElement {
	
    private int gigaBytes;
    private String multiChannel;

    public RAM(int componentId, String componentName, double price, String typeOfComponent, int gigaBytes, String multiChannel, double weight) {
        super(componentId, componentName, price, typeOfComponent, weight);
        this.gigaBytes = gigaBytes;
        this.multiChannel = multiChannel;
    }

    public int getGigaBytes() {
        return gigaBytes;
    }

    public void setGigaBytes(int gigaBytes) {
        this.gigaBytes = gigaBytes;
    }

    public String getMultiChannel() {
        return multiChannel;
    }

    public void setMultiChannel(String multiChannel) {
        this.multiChannel = multiChannel;
    }
    
    public String getComponentDetails(){
   	 return super.getComponentDetails() + "\nGigaBytes: " + this.gigaBytes + "\nMultiChannel" + this.multiChannel;
   }
    
    public String toString(){
		String output;
		output = super.toString();
		output += "," + gigaBytes + "," + multiChannel;
		return output;
	}

    // For Visitor
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
    
}
