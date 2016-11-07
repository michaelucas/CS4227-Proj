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
		String result = "String componentName, double price, String typeOfComponent, double weight";

		Scanner in = new Scanner(System.in);
		switch(type){
		case "CPU":
			return result + " String series, String CPUSocketType";
		case "GPU":
			return result + " String memory, int displayPorts";
		case "MemoryDrive":
			return result + " int driveCapacity, boolean SSD";
		case "Monitor":
			return result + " String screenResolution, boolean curved, boolean is3d";
		case "Motherboard":
			return result + " String cpuSocketType, String series, String memoryStandard";
		case "Mouse":
			return result + " int dpi, boolean programmableButtons, boolean dpiSwitching";
		case "RAM":
			return result + " int gigaBytes, String multiChannel";
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
