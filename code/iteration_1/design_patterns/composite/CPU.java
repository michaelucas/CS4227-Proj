package compositeSoFar;

public class CPU extends Component {
    private String series;
    private String CPUSocketType;

    public CPU(int componentId, String componentName, int stock, String typeOfComponent, String series, String CPUSocketType) {
        super(componentId, componentName ,stock, typeOfComponent);
        this.series = series;
        this.CPUSocketType = CPUSocketType;
    }


    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getCPUSocketType() {
        return CPUSocketType;
    }

    public void setCPUSocketType(String CPUSocketType) {
        this.CPUSocketType = CPUSocketType;
    }
    
    public String getComponentDetails(){
    	 return super.getComponentDetails() + "\nCPU series: " + this.series + "\nCPU SocketType" + this.CPUSocketType;
    }
}