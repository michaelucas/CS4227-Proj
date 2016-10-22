package BusinessLayer.CompositeProduct;

public class Motherboard extends Component {

    private String cpuSocketType;
    private String series;
    private String memoryStandard;

    public Motherboard(int componentId, String componentName, int stock, double price, String typeOfComponent, String cpuSocketType, String series, String memoryStandard) {
        super(componentId, componentName ,stock, price, typeOfComponent);
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
}
