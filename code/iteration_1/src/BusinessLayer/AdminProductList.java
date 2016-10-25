package BusinessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import BusinessLayer.CompositeProduct.*;
import DataLayer.DataControl;

public class AdminProductList implements Subject {

	
	private ArrayList<Component> listOfProducts;
	private ArrayList<Observer> observers;
	
	public AdminProductList() throws FileNotFoundException{
		listOfProducts = new ArrayList<Component>();
		observers = new ArrayList<Observer>();
		listOfProducts = DataControl.factoryDesignPattern();
	}	
	
	public String getAllDisplay() throws FileNotFoundException{
		String display;
		display = "\n\nPlease choose a component for your computer:\n";
		for (int i = 0; i < listOfProducts.size(); i++) {
			display += "\n\nChoice: " + (i + 1) + "\t" + " " + listOfProducts.get(i).getComponentDetails();
		}
		return display;
	}
	
	
	public void removeComponent(int choice) throws IOException{
		listOfProducts.remove(choice - 1);
		for (int i = 0; i < listOfProducts.size(); i++) {
			DataControl.editComponent(listOfProducts.get(i));
		}
		
	}
	
	public String addComponent(String type) throws FileNotFoundException{
	
		
		Scanner in = new Scanner(System.in);
		switch(type){
		case "CPU":
			return "String componentName, int stock, double price, String typeOfComponent, String series, String CPUSocketType";
		case "GPU":
			return "String componentName, int stock, double price, String typeOfComponent, String memory, int displayPorts";
		case "MemoryDrive":
			return "String componentName, int stock, double price, String typeOfComponent, int driveCapacity, boolean SSD";
		case "Monitor":
			return "String componentName, int stock, double price, String typeOfComponent, String screenResolution, boolean curved, boolean is3d";
		case "Motherboard":
			return " String componentName, int stock, double price, String typeOfComponent, String cpuSocketType, String series, String memoryStandard";
		case "Mouse":
			return "String componentName, int stock, double price, String typeOfComponent, int dpi, boolean programmableButtons, boolean dpiSwitching";
		case "RAM":
			return "String componentName, int stock,double price, String typeOfComponent, int gigaBytes, String multiChannel";
		default: return "Invalid Input";	
		}
	}
	
	public void addToFile(String details) throws FileNotFoundException{
		DataControl.writeNewComponentToFile(details);
		listOfProducts = DataControl.factoryDesignPattern();
		notifyObservers();

	}
	
	public String getCurrentStatus(int choice){
		String status;
		Component c = listOfProducts.get(choice - 1);
		status = "Name\tPrice\tStock\n";
		status += c.getComponentName();
		status += "\t" + c.getPrice();
		status += "\t" + c.getStock();
		return status;
	}
	
	public void editComponent(int choice, String details) throws IOException{
		Component c = listOfProducts.get(choice - 1);
		String[] updated = details.split(",");
		listOfProducts.remove(choice - 1);
		//DataControl.rewriteComponentFile(listOfProducts);
	}
	
	@Override
	public void registerObserver(Observer O) {
		observers.add(O);
		
	}

	@Override
	public void notifyObservers() {
		
		Observer o;
        try {
            for(int i = 0; i < observers.size();i++ )
            {
                o = observers.get(i);
                o.update();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
