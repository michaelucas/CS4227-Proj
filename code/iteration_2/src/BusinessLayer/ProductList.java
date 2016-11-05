/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 ProductList class

	Usage: 
 */

package BusinessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
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
	
	private List<VisitableElement> cartItems;

	public ProductList() throws IOException {
		boolean summaryConfirmToContinue = false;

		while(summaryConfirmToContinue == false) {
			String [] listOfComponentOptions = new String[] {"CPU", "GPU", "Keyboard", "MemoryDrive", "Monitor", "Motherboard", "Mouse", "RAM"};
			ComputerSystem computerSystem = new ComputerSystem(1, "Laptop", "ComputerSystem", 00.00, "Windows", 00.00);
			cartItems = new ArrayList<VisitableElement>();

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
					if (userChoice >= 0)
						computerSystem.addComponent(listOfComponentTypeOptions.get(userChoice));
				}
				else {
					System.out.println("We are currently out of all components of type" + index + ".\nPlease consider returning after we restock our products");
				}
			}
			
			// Visitor Design Pattern - Get Shipping Cost
			ShippingVisitor shippingVisitor = new ShippingVisitor();
			addToVisitableElementList(computerSystem);
			
			for (VisitableElement item: cartItems)
				item.accept(shippingVisitor);
			
			double shippingCostTotal = shippingVisitor.getTotalShipping();
			double totalCostBeforeShipping = computerSystem.getPrice();
			double totalCostAfterShipping = (totalCostBeforeShipping + shippingCostTotal);
			
			SummaryUI.printOutSummary(computerSystem.getSummary());
			System.out.println("\nTotal Additional Shipping Cost:" + new DecimalFormat("##.##").format(shippingCostTotal));
			computerSystem.setShippingCost(totalCostAfterShipping);

			summaryConfirmToContinue = SummaryUI.checkToContinue();
			
			StockManager.decrementStock(computerSystem);
			
			ReceiptUI aReceipt = new ReceiptUI(computerSystem);
		}
	}
	
	public int getStock(String compName) throws FileNotFoundException{
		int stock = DataControl.getStockByComponentName(compName);
		return stock;
	}
	
	private void addToVisitableElementList(ComputerSystem computerSystem) {
		
		ArrayList<Component> componentList = computerSystem.getComponents();
		for (Component component: componentList) {
			switch(component.getTypeOfComponent()) {
				case "CPU" :		CPU cpu = (CPU) component; cartItems.add(cpu); 	break;
				case "GPU" :		GPU gpu = (GPU) component; cartItems.add(gpu); 	break;
				case "Keyboard" :	Keyboard keyboard = (Keyboard) component; cartItems.add(keyboard); 	break;
				case "MemoryDrive" :MemoryDrive memoryDrive = (MemoryDrive) component; cartItems.add(memoryDrive); 	break;
				case "Monitor" :	Monitor monitor = (Monitor) component; cartItems.add(monitor); 	break;
				case "Motherboard" :Motherboard motherboard = (Motherboard) component; cartItems.add(motherboard); 	break;
				case "Mouse" :		Mouse mouse = (Mouse) component; cartItems.add(mouse); 	break;
				case "RAM" :		RAM ram = (RAM) component; cartItems.add(ram); 	break;
			}
		}
	}
}
