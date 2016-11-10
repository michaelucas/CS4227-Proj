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
import BusinessLayer.CompositeProduct.*;
import BusinessLayer.VisitorShipping.*;
import BusinessLayer.MementoPattern.*;
import DataLayer.DataControl;
import UserInterfaceLayer.*;

public class ProductList {
	
	private List<VisitableElement> cartItems;

	public ProductList() throws IOException {
		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker();
		boolean summaryConfirmToContinue = false;

		while(!summaryConfirmToContinue) {
			String [] listOfComponentOptions = new String[] {"CPU", "GPU", "Keyboard", "MemoryDrive", "Monitor", "Motherboard", "Mouse", "RAM"};
			ComputerSystem computerSystem = new ComputerSystem(1, "Laptop", "ComputerSystem", "Windows", 00.00);
			cartItems = new ArrayList<>();
			
			//saved systems = the amount of mementos created
			//current system is used to return to the previous memento
			int savedSystems = 0;
			int currentSystem = 0;
			
			ComputerSystem c2 = new ComputerSystem(1, "Laptop", "ComputerSystem", "Windows", 00.00);
			
			originator.set(c2);
			caretaker.addMemento(originator.storeInMemento());

			// Loop for each component type in listOfComponentOptions array
			for(int i = 0;i < listOfComponentOptions.length;) {
				// Initialise an ArrayList to be filled with component type stored in index
				ArrayList<Component> listOfComponentTypeOptions = new ArrayList<>();
				// Ask for an ArrayList of all products of index component type
				
				
				listOfComponentTypeOptions = DataControl.getComponentTypeList(listOfComponentOptions[i]);
				
				
				//Print out the list of components of index type
				if (!listOfComponentTypeOptions.isEmpty()) {
					ProductListUI.printOutList(listOfComponentTypeOptions);
					int userChoice = ProductListUI.readUserInput();
					
					if (userChoice >= -1) {
						
						if(userChoice >= 0) {
							computerSystem.addComponent(listOfComponentTypeOptions.get(userChoice));
						}	
						ComputerSystem c1 = new ComputerSystem(1, "Laptop", "ComputerSystem", "Windows", 00.00);
						ArrayList<Component> l = computerSystem.getComponents();
						for(int y = 0;y < l.size();y++) {
							c1.addComponent(l.get(y));
						}
						//adding a memento of the current computer system
						originator.set(c1);
						caretaker.addMemento(originator.storeInMemento());
						
						savedSystems++;
						currentSystem++;
						i++;
					/*  Whenever a product is added to the computer system the currentSystem must be equal to
					 *  the number of savedSystems to ensure that when the user wants to undo a selection
					 *  it always returns the last added memento*/
						
						currentSystem = savedSystems;
					}
					//if the user enters -1 (undo)
					else if(userChoice == -2) {
						
						// user cannot undo if no components have been added to the computer system
						if(i <= 0)
							System.out.print("No components currently in computer system");
					
					else  {
						//get the previous memento
						currentSystem = currentSystem-1;
						// this computer system is set to the previous memento
							ComputerSystem computerSystem1 = new ComputerSystem(1, "Laptop", "ComputerSystem", "Windows", 00.00);
							computerSystem1 = originator.restoreFromMemento(caretaker.getMemento(currentSystem));
							
							/*  .clear() removes all the components in a computer system
							 *  this is needed in order to set the main computer system as the previously saved memento
							 */
							computerSystem.clear();
							
							//aadding the components from the previous memento to the computer system
							for(int j = 0;j < (computerSystem1.getComponents()).size();j++) {
								Component c = computerSystem1.getChildAtIndex(j);
								
								computerSystem.addComponent(c);
							}
							
							//return to the previous component selection screen
								i--;
						}
					}
				}
				
				
				else {
					System.out.println("We are currently out of all components of type" + listOfComponentOptions[i] + ".\nPlease consider returning after we restock our products");

				}
				
			}
			
			// Visitor Design Pattern - Get Shipping Cost
			ShippingVisitor shippingVisitor = new ShippingVisitor();
			addToVisitableElementList(computerSystem);
			
			for (VisitableElement item: cartItems)
				item.accept(shippingVisitor);
			
			double shippingCostTotal = shippingVisitor.getTotalShipping();
			double totalCostBeforeShipping = computerSystem.getPrice();
			double totalCostAfterShipping = totalCostBeforeShipping + shippingCostTotal;
			computerSystem.setShippingCost(totalCostAfterShipping);
			
			SummaryUI.printOutSummary(computerSystem.getSummary());

			summaryConfirmToContinue = SummaryUI.checkToContinue();
			
			StockManager.decrementStock(computerSystem);
			
			ReceiptUI aReceipt = new ReceiptUI(computerSystem);
		}
	}
	
	public int getStock(String compName) throws FileNotFoundException{
		return DataControl.getStockByComponentName(compName);
	}
	
	private void addToVisitableElementList(ComputerSystem computerSystem) {
		
		ArrayList<Component> componentList = computerSystem.getComponents();
		for (Component component: componentList) {
			switch(component.getTypeOfComponent()) {
				case "CPU" :		
					CPU cpu = (CPU) component; 
					cartItems.add(cpu); 	
					break;
				case "GPU" :		
					GPU gpu = (GPU) component; 
					cartItems.add(gpu); 	
					break;
				case "Keyboard" :	
					Keyboard keyboard = (Keyboard) component; 
					cartItems.add(keyboard); 	
					break;
				case "MemoryDrive" :
					MemoryDrive memoryDrive = (MemoryDrive) component; 
					cartItems.add(memoryDrive); 	
					break;
				case "Monitor" :	
					Monitor monitor = (Monitor) component; 
					cartItems.add(monitor); 	
					break;
				case "Motherboard" :
					Motherboard motherboard = (Motherboard) component; 
					cartItems.add(motherboard); 	
					break;
				case "Mouse" :		
					Mouse mouse = (Mouse) component; 
					cartItems.add(mouse); 	
					break;
				case "RAM" :		
					RAM ram = (RAM) component; 
					cartItems.add(ram); 	
					break;
				default:
					System.out.println("Invalid Component Type. ProductList.java");
					break;
			}
		}
	}
}
