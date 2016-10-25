package BusinessLayer.CompositeProduct;

public class MemoryDrive extends Component {
    private int driveCapacity;
    private boolean SSD;

    public MemoryDrive(int componentId, String componentName, int stock, double price, String typeOfComponent, int driveCapacity, boolean SSD) {
        super(componentId, componentName ,stock,  price, typeOfComponent);
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
