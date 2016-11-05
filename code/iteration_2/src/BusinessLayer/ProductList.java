/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 ProductList class

	Usage: 
 */

package BusinessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import BusinessLayer.*;
import BusinessLayer.CommandProduct.*;
import BusinessLayer.CompositeProduct.*;
import BusinessLayer.VisitorShipping.*;
import DataLayer.DataControl;
import UserInterfaceLayer.*;

public class ProductList {
	
	private List<VisitableElement> cartItems = new ArrayList<VisitableElement>();

	public ProductList() throws IOException {
		boolean summaryConfirmToContinue = false;

		while(summaryConfirmToContinue == false) {
			String [] listOfComponentOptions = new String[] {"CPU", "GPU", "Keyboard", "MemoryDrive", "Monitor", "Motherboard", "Mouse", "RAM"};
			ComputerSystem computerSystem = new ComputerSystem(1, "Laptop", "ComputerSystem", 00.00, "Windows", 00.00);

			// Loop for each component type in listOfComponentOptions array
			for(String index : listOfComponentOptions) {
				// Initialise an ArrayList to be filled with component type stored in index
				ArrayList<Component> listOfComponentTypeOptions = new ArrayList<Component>();
				// Ask for an ArrayList of all products of index component type
				listOfComponentTypeOptions = DataControl.getComponentTypeList(index);
				//Print out the list of components of index type
				if (listOfComponentTypeOptions.size() > 0) {
					ProductListUI.printOutList(listOfComponentTypeOptions);
					int userChoice = ProductListUI.readUserInput();
					if (userChoice >= 0) {
						computerSystem.addComponent(listOfComponentTypeOptions.get(userChoice));
						addToVisitableElementList(listOfComponentTypeOptions.get(userChoice));
					}
				}
				else {
					System.out.println("We are currently out of all components of type" + index + ".\nPlease consider returning after we restock our products");
				}
			}
			
			// Visitor Design Pattern - Get Shipping Cost
			ShippingVisitor shippingVisitor = new ShippingVisitor();
			for (VisitableElement item: cartItems)
				item.accept(shippingVisitor);
			double shippingCostTotal = shippingVisitor.getTotalShipping();
			//System.out.println("\nTotal Shipping Cost:" + shippingCostTotal);

			SummaryUI.printOutSummary(computerSystem.getSummary());
			summaryConfirmToContinue = SummaryUI.checkToContinue();
			StockManager.decrementStock(computerSystem);
			ReceiptUI aReceipt = new ReceiptUI(computerSystem);
		}
	}
	
	public int getStock(String compName) throws FileNotFoundException{
		int stock = DataControl.getStockByComponentName(compName);
		return stock;
	}
	
	private void addToVisitableElementList(Component component) {
		/*
		switch(component.getTypeOfComponent()) {
			case "CPU" :		cartItems.add((CPU) component); 	break;
			case "GPU" :		cartItems.add((VisitableElement) component); 	break;
			case "Keyboard" :	cartItems.add((VisitableElement) component); 	break;
			case "MemoryDrive" :cartItems.add((VisitableElement) component); 	break;
			case "Monitor" :	cartItems.add((VisitableElement) component); 	break;
			case "Motherboard" :cartItems.add((VisitableElement) component); 	break;
			case "Mouse" :		cartItems.add((VisitableElement) component); 	break;
			case "RAM" :		cartItems.add((VisitableElement) component); 	break;
		}*/
	}
}
