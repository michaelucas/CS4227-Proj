package BusinessLayer.FactoryProduct;

import BusinessLayer.CompositeProduct.*;

public class FactoryDesignPattern {
	
			
	public CPU getCPU(int componentId, String componentName, double price, String typeOfComponent, String series, String CPUSocketType, double weight){	
		return new CPU(componentId, componentName, price, typeOfComponent, series, CPUSocketType, weight);
	
	}
	
	public GPU getGPU(int componentId, String componentName, double price, String typeOfComponent, String memory, int displayPorts, double weight){
		return new GPU(componentId, componentName, price, typeOfComponent, memory, displayPorts, weight);
		
	}
	public Keyboard getKeyboard(int componentId, String componentName, double price, String typeOfComponent, String keySwitchType, boolean backlit, double weight){
		return new Keyboard(componentId, componentName, price, typeOfComponent, keySwitchType, backlit, weight);
		
	}
	public MemoryDrive getMemoryDrive(int componentId, String componentName, double price, String typeOfComponent, int driveCapacity, boolean SSD, double weight){
		return new MemoryDrive(componentId, componentName, price, typeOfComponent, driveCapacity, SSD, weight);
		
	}
	public Monitor getMonitor(int componentId, String componentName, double price, String typeOfComponent, String screenResolution, boolean curved, boolean is3d, double weight){
		return new Monitor(componentId, componentName, price, typeOfComponent, screenResolution, curved, is3d, weight);
		
	}
	public Motherboard getMotherboard(int componentId, String componentName, double price, String typeOfComponent, String cpuSocketType, String series, String memoryStandard, double weight){
		return new Motherboard(componentId, componentName, price, typeOfComponent, cpuSocketType, series, memoryStandard, weight);
		
	}
	public Mouse getMouse(int componentId, String componentName, double price, String typeOfComponent, int dpi, boolean programmableButtons, boolean dpiSwitching, double weight){
		return new Mouse(componentId, componentName, price, typeOfComponent, dpi, programmableButtons, dpiSwitching, weight);
		
	}
	
	public RAM getRAM(int componentId, String componentName, double price, String typeOfComponent, int gigaBytes, String multiChannel, double weight){
		return new RAM(componentId, componentName, price, typeOfComponent, gigaBytes, multiChannel, weight);
		
	}
	
	public ComputerSystem getComputerSystem(int componentId, String componentName, String typeOfComponent, String OS, double weight){
		return new ComputerSystem(componentId, componentName, typeOfComponent, OS, weight);
	}
	
}
