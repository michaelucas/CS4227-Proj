package BusinessLayer.CompositeProduct;

import BusinessLayer.VisitorShipping.VisitableElement;
import BusinessLayer.VisitorShipping.Visitor;

public class Monitor extends Component implements VisitableElement {
    private String screenResolution;
    private boolean curved;
    private boolean is3d;

    public Monitor(int componentId, String componentName, double price, String typeOfComponent, String screenResolution, boolean curved, boolean is3d, double weight) {
        super(componentId, componentName, price, typeOfComponent, weight);
        this.screenResolution = screenResolution;
        this.curved = curved;
        this.is3d = is3d;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public boolean isCurved() {
        return curved;
    }

    public void setCurved(boolean curved) {
        this.curved = curved;
    }

    public boolean is3d() {
        return is3d;
    }

    public void setIs3d(boolean is3d) {
        this.is3d = is3d;
    }
    
    public String getComponentDetails(){
   	 return super.getComponentDetails() + "\nScreenResolution: " + this.screenResolution + "\nCurved T/F: " + this.curved + "\nIs 3D T/F: " + this.is3d;
   }
    
    public String toString(){
		String output;
		output = super.toString();
		output += "," + screenResolution + "," + curved + "," + is3d;
		return output;
	}

    // For Visitor
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
