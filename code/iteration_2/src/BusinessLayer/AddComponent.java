package BusinessLayer;
import java.io.*;
import java.util.*;
import UserInterfaceLayer.AddComponentUI;
import DataLayer.DataControl;

public class AddComponent {
	
	public AddComponent() throws FileNotFoundException {
		String componentTypeToAdd = getComponentType();
		addComponentSpecs(componentTypeToAdd);
	}
	
	private String getComponentType() throws FileNotFoundException {
		
		String componentTypes = "Please choose a component type to add a new product to:\n";
		ArrayList<String> uniqueComponentList = DataControl.getUniqueComponentTypes();
		for (int i = 0; i < uniqueComponentList.size(); i++) {
			componentTypes += "Choice: " + (i + 1) + "\t" + " " + uniqueComponentList.get(i) + "\n";
		}
		
		AddComponentUI.printOutput(componentTypes);
		
		int userChoice = AddComponentUI.getComponentType();
		
		return uniqueComponentList.get(userChoice);
	}

	public void addComponentSpecs(String type) throws FileNotFoundException{
		
		Scanner in = new Scanner(System.in);
		switch(type){
		case "CPU":
			System.out.println("String componentName, int stock, double price, String typeOfComponent, String series, String CPUSocketType");
			DataControl.writeNewComponentToFile(in.nextLine());
			break;
		case "GPU":
			System.out.println("String componentName, int stock, double price, String typeOfComponent, String memory, int displayPorts");
			DataControl.writeNewComponentToFile(in.nextLine());
			break;
		case "MemoryDrive":
			System.out.println("String componentName, int stock, double price, String typeOfComponent, int driveCapacity, boolean SSD");
			DataControl.writeNewComponentToFile(in.nextLine());
			break;
		case "Monitor":
			System.out.println("String componentName, int stock, double price, String typeOfComponent, String screenResolution, boolean curved, boolean is3d");
			DataControl.writeNewComponentToFile(in.nextLine());
			break;
		case "Motherboard":
			System.out.println(" String componentName, int stock, double price, String typeOfComponent, String cpuSocketType, String series, String memoryStandard");
			DataControl.writeNewComponentToFile(in.nextLine());
			break;
		case "Mouse":
			System.out.println("String componentName, int stock, String typeOfComponent, int dpi, boolean programmableButtons, boolean dpiSwitching");
			DataControl.writeNewComponentToFile(in.nextLine());
			break;
		case "RAM":
			System.out.println("String componentName, int stock, String typeOfComponent, int gigaBytes, String multiChannel");
			DataControl.writeNewComponentToFile(in.nextLine());
			break;
		default:
			System.out.println("Unknown Component Type Found. AddComponent.java");
			break;
		}
	}
	
}
