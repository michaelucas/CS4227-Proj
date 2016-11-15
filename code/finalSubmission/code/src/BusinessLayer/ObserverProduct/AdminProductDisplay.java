package BusinessLayer.ObserverProduct;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.*;

import DataLayer.*;

public class AdminProductDisplay implements Observer {
	
	private String allDisplay;
	private static final Logger LOGGER = Logger.getLogger( AdminProductDisplay.class.getName() );
	
	public AdminProductDisplay() throws FileNotFoundException{
		
		allDisplay = "\n\nPlease choose a component for your computer:\n";
		for (int i = 0; i < DataControl.factoryDesignPattern().size(); i++) {
			allDisplay += "\n\nChoice: " + (i + 1) + "\t" + " " + DataControl.factoryDesignPattern().get(i).getComponentDetails();
		}
	}
	

	public String getAllDisplay() {
		return allDisplay;
	}

	@Override
	public void update() {
		try {
			allDisplay = "\n\nPlease choose a component for your computer:\n";
			for (int i = 0; i < DataControl.factoryDesignPattern().size(); i++) {
				allDisplay += "\n\nChoice: " + (i + 1) + "\t" + " " + DataControl.factoryDesignPattern().get(i).getComponentDetails();
			}
		} catch (Exception e) {
            LOGGER.log(Level.SEVERE, "context", e);
		}
		
	}
	
	public String addComponent(String type) throws FileNotFoundException{
		String result = "String componentName, double price, String typeOfComponent, double weight";
		
		switch(type){
			case "CPU":
				result += ", String series, String CPUSocketType";
				break;
			case "GPU":
				result += ", String memory, int displayPorts";
				break;
			case "Keyboard":
				result +=  ", String keySwitchType , booelan backlit";
				break;
			case "MemoryDrive":
				result += ", int driveCapacity, boolean SSD";
				break;
			case "Monitor":
				result += ", String screenResolution, boolean curved, boolean is3d";
				break;
			case "Motherboard":
				result += ", String cpuSocketType, String series, String memoryStandard";
				break;
			case "Mouse":
				result += ", int dpi, boolean programmableButtons, boolean dpiSwitching";
				break;
			case "RAM":
				result += ", int gigaBytes, String multiChannel";
				break;
			default: 
				result = "Invalid Input";	
				break;
		}
		return result;
	}
	
	
public int readUserInput() {
		
		boolean acceptableInput = false;
		int checkedUserChoice;
		String uncheckedUserChoice = "";
		Scanner in = new Scanner(System.in);
		
		while (!acceptableInput) {
			
			System.out.println("\nEnter choice number: ");
			uncheckedUserChoice = in.nextLine();
			if (uncheckedUserChoice.matches("[0-9]+"))
				acceptableInput = true;
			else
				System.out.println("Error: Invalid. Must be a number");
		}
		
		checkedUserChoice = Integer.parseInt(uncheckedUserChoice);
		return checkedUserChoice;
	}

}
