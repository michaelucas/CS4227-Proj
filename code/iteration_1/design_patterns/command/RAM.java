

public class RAM extends Component {
	
    private int gigaBytes;
    private String multiChannel;

    public RAM(int componentId, String componentName, int stock, int gigaBytes, String multiChannel) {
        super(componentId, componentName ,stock);
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