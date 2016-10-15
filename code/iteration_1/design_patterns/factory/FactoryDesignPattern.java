package compositeSoFar;


public class FactoryDesignPattern {
	

	
	public CPU getCPU(int componentId, String componentName, int stock, String typeOfComponent, String series, String CPUSocketType){
		return new CPU(componentId, componentName, stock,  typeOfComponent, series, CPUSocketType);
	}
	
	public GPU getGPU(int componentId, String componentName, int stock, String typeOfComponent, String memory, int displayPorts){
		return new GPU(componentId, componentName, stock, typeOfComponent, memory, displayPorts);
		
	}
	public Keyboard getKeyboard(int componentId, String componentName, int stock, String typeOfComponent, String keySwitchType, boolean backlit){
		return new Keyboard(componentId, componentName, stock, typeOfComponent, keySwitchType, backlit);
		
	}
	public MemoryDrive getMemoryDrive(int componentId, String componentName, int stock, String typeOfComponent, int driveCapacity, boolean SSD){
		return new MemoryDrive(componentId, componentName, stock, typeOfComponent, driveCapacity, SSD);
		
	}
	public Monitor getMonitor(int componentId, String componentName, int stock, String typeOfComponent, String screenResolution, boolean curved, boolean is3d){
		return new Monitor(componentId, componentName, stock, typeOfComponent, screenResolution, curved, is3d);
		
	}
	public Motherboard getMotherboard(int componentId, String componentName, int stock, String typeOfComponent, String cpuSocketType, String series, String memoryStandard){
		return new Motherboard(componentId, componentName, stock, typeOfComponent, cpuSocketType, series, memoryStandard);
		
	}
	public Mouse getMouse(int componentId, String componentName, int stock, String typeOfComponent, int dpi, boolean programmableButtons, boolean dpiSwitching){
		return new Mouse(componentId, componentName, stock, typeOfComponent, dpi, programmableButtons, dpiSwitching);
		
	}
	
	public RAM getRAM(int componentId, String componentName, int stock, String typeOfComponent, int gigaBytes, String multiChannel){
		return new RAM(componentId, componentName, stock, typeOfComponent, gigaBytes, multiChannel);
		
	}

}
