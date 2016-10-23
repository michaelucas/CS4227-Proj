package UserInterfaceLayer;
import DataLayer.DataControl;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddComponentUI {
	
	Scanner in = new Scanner(System.in);
	DataControl d = new DataControl();
	
	public void addCPUComponent(String type) throws FileNotFoundException{
		
		System.out.println("String componentName, int stock, double price, String typeOfComponent, String series, String CPUSocketType");
		d.writeNewComponentToFile(in.nextLine());	
	}
	
	public void addGPUComponent(String type) throws FileNotFoundException{
		System.out.println("String componentName, int stock, double price, String typeOfComponent, String memory, int displayPorts");
		d.writeNewComponentToFile(in.nextLine());
		
	}

	public void addKeyboardComponent(String type) throws FileNotFoundException{
		System.out.println("String componentName, int stock, double price, String typeOfComponent, String keySwitchType, boolean backlit");
		d.writeNewComponentToFile(in.nextLine());
	
	}

	public void addMemoryDriveComponent(String type) throws FileNotFoundException{
		System.out.println("String componentName, int stock, double price, String typeOfComponent, int driveCapacity, boolean SSD");
		d.writeNewComponentToFile(in.nextLine());
	}
	
	public void addMonitorComponent(String type) throws FileNotFoundException{
		System.out.println("String componentName, int stock, double price, String typeOfComponent, String screenResolution, boolean curved, boolean is3d");
		d.writeNewComponentToFile(in.nextLine());
	}
	
	public void addMotherboardComponent(String type) throws FileNotFoundException{
		System.out.println(" String componentName, int stock, double price, String typeOfComponent, String cpuSocketType, String series, String memoryStandard");
		d.writeNewComponentToFile(in.nextLine());
		
	}
	
	public void addMouseComponent(String type) throws FileNotFoundException{
		System.out.println("String componentName, int stock, String typeOfComponent, int dpi, boolean programmableButtons, boolean dpiSwitching");
		d.writeNewComponentToFile(in.nextLine());
		
	}
	
	public void addRAMComponent(String type) throws FileNotFoundException{
		System.out.println("String componentName, int stock, String typeOfComponent, int gigaBytes, String multiChannel");
		d.writeNewComponentToFile(in.nextLine());
		
	}

}
