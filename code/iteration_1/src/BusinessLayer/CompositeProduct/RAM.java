package compositeSoFar;

public class RAM extends Component {
	
    private int gigaBytes;
    private String multiChannel;

    public RAM(int componentId, String componentName, int stock, double price, String typeOfComponent, int gigaBytes, String multiChannel) {
        super(componentId, componentName ,stock, price, typeOfComponent);
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
}
