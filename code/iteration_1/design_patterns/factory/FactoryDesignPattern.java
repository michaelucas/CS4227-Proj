package Component;





public class FactoryDesignPattern {
	
			
	public CPU getCPU(int componentId, String componentName, int stock, double price, String typeOfComponent, String series, String CPUSocketType){	
		return new CPU(componentId, componentName, stock, price, typeOfComponent, series, CPUSocketType);
	
	}
	
	public GPU getGPU(int componentId, String componentName, int stock, double price, String typeOfComponent, String memory, int displayPorts){
		return new GPU(componentId, componentName, stock,  price, typeOfComponent, memory, displayPorts);
		
	}
	public Keyboard getKeyboard(int componentId, String componentName, int stock, double price, String typeOfComponent, String keySwitchType, boolean backlit){
		return new Keyboard(componentId, componentName, stock, price, typeOfComponent, keySwitchType, backlit);
		
	}
	public MemoryDrive getMemoryDrive(int componentId, String componentName, int stock, double price, String typeOfComponent, int driveCapacity, boolean SSD){
		return new MemoryDrive(componentId, componentName, stock, price, typeOfComponent, driveCapacity, SSD);
		
	}
	public Monitor getMonitor(int componentId, String componentName, int stock, double price, String typeOfComponent, String screenResolution, boolean curved, boolean is3d){
		return new Monitor(componentId, componentName, stock, price, typeOfComponent, screenResolution, curved, is3d);
		
	}
	public Motherboard getMotherboard(int componentId, String componentName, int stock, double price, String typeOfComponent, String cpuSocketType, String series, String memoryStandard){
		return new Motherboard(componentId, componentName, stock, price, typeOfComponent, cpuSocketType, series, memoryStandard);
		
	}
	public Mouse getMouse(int componentId, String componentName, int stock, double price, String typeOfComponent, int dpi, boolean programmableButtons, boolean dpiSwitching){
		return new Mouse(componentId, componentName, stock, price, typeOfComponent, dpi, programmableButtons, dpiSwitching);
		
	}
	
	public RAM getRAM(int componentId, String componentName, int stock, double price, String typeOfComponent, int gigaBytes, String multiChannel){
		return new RAM(componentId, componentName, stock, price, typeOfComponent, gigaBytes, multiChannel);
		
	}
	
}
