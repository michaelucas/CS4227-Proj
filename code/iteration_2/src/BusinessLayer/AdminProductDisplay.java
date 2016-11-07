package BusinessLayer;

import java.io.FileNotFoundException;
import java.util.Scanner;

import DataLayer.*;

public class AdminProductDisplay implements Observer {
	
	private String allDisplay;
	
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
			/*GPUDisplay = pl.getIndividualDisplay("GPU");
			CPUDisplay = pl.getIndividualDisplay("CPU");
			motherboardDisplay = pl.getIndividualDisplay("Motherboard");
			keyboardDisplay = pl.getIndividualDisplay("Keyboard");
			memoryDriveDisplay = pl.getIndividualDisplay("MemoryDrive");
			mouseDisplay = pl.getIndividualDisplay("Mouse");
			RAMDisplay = pl.getIndividualDisplay("RAM");
			monitorDisplay = pl.getIndividualDisplay("Monitor");*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String addComponent(String type) throws FileNotFoundException{


		Scanner in = new Scanner(System.in);
		switch(type){
		case "CPU":
			return "String componentName, double price, String typeOfComponent, String series, String CPUSocketType, double weight";
		case "GPU":
			return "String componentName, double price, String typeOfComponent, String memory, int displayPorts, double weight";
		case "MemoryDrive":
			return "String componentName, double price, String typeOfComponent, int driveCapacity, boolean SSD, double weight";
		case "Monitor":
			return "String componentName, double price, String typeOfComponent, String screenResolution, boolean curved, boolean is3d, double weight";
		case "Motherboard":
			return " String componentName, double price, String typeOfComponent, String cpuSocketType, String series, String memoryStandard, double weight";
		case "Mouse":
			return "String componentName, double price, String typeOfComponent, int dpi, boolean programmableButtons, boolean dpiSwitching, double weight";
		case "RAM":
			return "String componentName, double price, String typeOfComponent, int gigaBytes, String multiChannel, double weight";
		default: return "Invalid Input";	
		}
	}
	
public int readUserInput() {
		
		boolean acceptableInput = false;
		int checkedUserChoice;
		String uncheckedUserChoice = "";
		Scanner in = new Scanner(System.in);
		
		while (false == acceptableInput) {
			
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
