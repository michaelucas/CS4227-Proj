package BusinessLayer.CompositeProduct;

import BusinessLayer.VisitorShipping.VisitableElement;
import BusinessLayer.VisitorShipping.Visitor;

public class Motherboard extends Component implements VisitableElement {

    private String cpuSocketType;
    private String series;
    private String memoryStandard;

    public Motherboard(int componentId, String componentName, double price, String typeOfComponent, String cpuSocketType, String series, String memoryStandard, double weight) {
        super(componentId, componentName, price, typeOfComponent, weight);
        this.cpuSocketType = cpuSocketType;
        this.series = series;
        this.memoryStandard = memoryStandard;
    }

    public String getCpuSocketType() {
        return cpuSocketType;
    }

    public void setCpuSocketType(String cpuSocketType) {
        this.cpuSocketType = cpuSocketType;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMemoryStandard() {
        return memoryStandard;
    }

    public void setMemoryStandard(String memoryStandard) {
        this.memoryStandard = memoryStandard;
    }
    
    public String getComponentDetails(){
   	 return super.getComponentDetails() + "\nCPU Socket Type: " + this.cpuSocketType + "\nSeries" + this.series + "\nMemoryStandard: " + this.memoryStandard;
   }
    
    public String toString(){
		String output;
		output = super.toString();
		output += "," + cpuSocketType + "," + series + "," + memoryStandard;
		return output;
	}

    // For Visitor
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
