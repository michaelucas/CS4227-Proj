package BusinessLayer.CompositeProduct;

public class MemoryDrive extends Component {
    private int driveCapacity;
    private boolean SSD;

    public MemoryDrive(int componentId, String componentName, double price, String typeOfComponent, int driveCapacity, boolean SSD, double weight) {
        super(componentId, componentName,  price, typeOfComponent, weight);
        this.driveCapacity = driveCapacity;
        this.SSD = SSD;
    }
    

    public int getDriveCapacity() {
        return driveCapacity;
    }

    public void setDriveCapacity(int driveCapacity) {
        this.driveCapacity = driveCapacity;
    }

    public boolean isSSD() {
        return SSD;
    }

    public void setRPM(boolean SSD) {
        this.SSD = SSD;
    }
    
    public String toString() {
    	 return super.toString() + "," + this.driveCapacity + "," + this.SSD;
    }
    
    public String getComponentDetails(){
   	 return super.getComponentDetails() + "\nDriveCapacity: " + this.driveCapacity + "\nSSD T/F : " + this.SSD;
   }
    
}
