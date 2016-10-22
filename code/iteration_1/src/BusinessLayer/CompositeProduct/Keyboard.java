package BusinessLayer.CompositeProduct;

public class Keyboard extends Component {
    private String keySwitchType;
    private boolean backlit;

    public Keyboard(int componentId, String componentName, int stock, double price, String typeOfComponent, String keySwitchType, boolean backlit) {
        super(componentId, componentName ,stock, price, typeOfComponent);
        this.keySwitchType = keySwitchType;
        this.backlit = backlit;
    }

    public String getKeySwitchType() {
        return keySwitchType;
    }

    public void setKeySwitchType(String keySwitchType) {
        this.keySwitchType = keySwitchType;
    }

    public boolean isBacklit() {
        return backlit;
    }

    public void setBacklit(boolean backlit) {
        this.backlit = backlit;
    }
    
    public String getComponentDetails(){
   	 return super.getComponentDetails() + "\nKeySwitchType: " + this.keySwitchType + "\nBacklit: " + this.backlit;
   }
}
