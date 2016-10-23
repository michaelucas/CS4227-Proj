package BusinessLayer;
import java.io.*;
import java.util.*;
import UserInterfaceLayer.AddComponentUI;
import DataLayer.DataControl;

public class AddComponent {

	public void addComponent(String type) throws FileNotFoundException{
		
		DataControl d = new DataControl();
		Scanner in = new Scanner(System.in);
		switch(type){
		case "CPU":
			System.out.println("String componentName, int stock, double price, String typeOfComponent, String series, String CPUSocketType");
			d.writeNewComponentToFile(in.nextLine());
			break;
		case "GPU":
			System.out.println("String componentName, int stock, double price, String typeOfComponent, String memory, int displayPorts");
			d.writeNewComponentToFile(in.nextLine());
			break;
		case "MemoryDrive":
			System.out.println("String componentName, int stock, double price, String typeOfComponent, int driveCapacity, boolean SSD");
			d.writeNewComponentToFile(in.nextLine());
			break;
		case "Monitor":
			System.out.println("String componentName, int stock, double price, String typeOfComponent, String screenResolution, boolean curved, boolean is3d");
			d.writeNewComponentToFile(in.nextLine());
			break;
		case "Motherboard":
			System.out.println(" String componentName, int stock, double price, String typeOfComponent, String cpuSocketType, String series, String memoryStandard");
			d.writeNewComponentToFile(in.nextLine());
			break;
		case "Mouse":
			System.out.println("String componentName, int stock, String typeOfComponent, int dpi, boolean programmableButtons, boolean dpiSwitching");
			d.writeNewComponentToFile(in.nextLine());
			break;
		case "RAM":
			System.out.println("String componentName, int stock, String typeOfComponent, int gigaBytes, String multiChannel");
			d.writeNewComponentToFile(in.nextLine());
			break;
		
		}
	}
	
}
