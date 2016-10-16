

public class Monitor extends Component {
    private String screenResolution;
    private boolean curved;
    private boolean is3d;

    public Monitor(int componentId, String componentName, int stock, String screenResolution, boolean curved, boolean is3d) {
        super(componentId, componentName, stock);
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
}