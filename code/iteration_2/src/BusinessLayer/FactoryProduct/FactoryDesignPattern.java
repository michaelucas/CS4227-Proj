package BusinessLayer.FactoryProduct;

import BusinessLayer.CompositeProduct.*;

public class FactoryDesignPattern {
	
			
	public CPU getCPU(int componentId, String componentName, double price, String typeOfComponent, String series, String CPUSocketType){	
		return new CPU(componentId, componentName, price, typeOfComponent, series, CPUSocketType);
	
	}
	
	public GPU getGPU(int componentId, String componentName, double price, String typeOfComponent, String memory, int displayPorts){
		return new GPU(componentId, componentName, price, typeOfComponent, memory, displayPorts);
		
	}
	public Keyboard getKeyboard(int componentId, String componentName, double price, String typeOfComponent, String keySwitchType, boolean backlit){
		return new Keyboard(componentId, componentName, price, typeOfComponent, keySwitchType, backlit);
		
	}
	public MemoryDrive getMemoryDrive(int componentId, String componentName, double price, String typeOfComponent, int driveCapacity, boolean SSD){
		return new MemoryDrive(componentId, componentName, price, typeOfComponent, driveCapacity, SSD);
		
	}
	public Monitor getMonitor(int componentId, String componentName, double price, String typeOfComponent, String screenResolution, boolean curved, boolean is3d){
		return new Monitor(componentId, componentName, price, typeOfComponent, screenResolution, curved, is3d);
		
	}
	public Motherboard getMotherboard(int componentId, String componentName, double price, String typeOfComponent, String cpuSocketType, String series, String memoryStandard){
		return new Motherboard(componentId, componentName, price, typeOfComponent, cpuSocketType, series, memoryStandard);
		
	}
	public Mouse getMouse(int componentId, String componentName, double price, String typeOfComponent, int dpi, boolean programmableButtons, boolean dpiSwitching){
		return new Mouse(componentId, componentName, price, typeOfComponent, dpi, programmableButtons, dpiSwitching);
		
	}
	
	public RAM getRAM(int componentId, String componentName, double price, String typeOfComponent, int gigaBytes, String multiChannel){
		return new RAM(componentId, componentName, price, typeOfComponent, gigaBytes, multiChannel);
		
	}
	
	public ComputerSystem getComputerSystem(int componentId, String componentName, double unitCost, String typeOfComponent, String OS ){
		return new ComputerSystem(componentId, componentName, typeOfComponent, unitCost, OS);
	}
	
}
