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
		
		String [] listOfComponentOptions = new String[] {"CPU"}; //Need to add more component types
		ComputerSystem computerSystem = new ComputerSystem(13141252, "AlienWare Laptop", 6, "ComputerSystem", 1200.66, "Windows" );
		
		for(String index : listOfComponentOptions) {
			ArrayList<Component> listOfComponentTypeOptions = new ArrayList<Component>();
			listOfComponentTypeOptions = DataControl.getComponentTypeList(index);
			
			ProductListUI.printOutList(listOfComponentTypeOptions);
			int userChoice = ProductListUI.readUserInput();
			computerSystem.addComponent(listOfComponentTypeOptions.get(userChoice));
		}
		
		// 
	}
}
