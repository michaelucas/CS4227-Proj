/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 ProductList class
	
	Usage: 
*/

package BusinessLayer;
 
import java.util.ArrayList;
import java.util.Scanner;
import BusinessLayer.Product.*;
import UserInterfaceLayer.*;
import DataControl.*;

public class ProductList {

	ProductList() {
		
		String [] listOfComponentOptions = new String[] {"CPU", "GPU", "Keyboard", "MemoryDrive", "Monitor", "Motherboard", "Mouse", "RAM"};
		ComputerSystem computerSystem = new ComputerSystem(13141252, "AlienWare Laptop", 6, "ComputerSystem", 1200.66, "Windows" );
		
		// Loop for each component type in listOfComponentOptions array
		for(String index : listOfComponentOptions) {
			// Initialise an ArrayList to be filled with component type stored in index
			ArrayList<Component> listOfComponentTypeOptions = new ArrayList<Component>();
			// Ask for an ArrayList of all products of index component type
			listOfComponentTypeOptions = DataControl.getComponentTypeList(index);
			
			//Print out the list of components of index type
			ProductListUI.printOutList(listOfComponentTypeOptions);
			int userChoice = ProductListUI.readUserInput();
			computerSystem.addComponent(listOfComponentTypeOptions.get(userChoice));
		}
		
		// Call Observer stock edit and then receipt here
	}
}
