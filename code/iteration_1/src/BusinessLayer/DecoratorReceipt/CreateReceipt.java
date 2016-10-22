/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - Receipt/Decorator Pattern Classes
	
	Usage: Call this Constructor passing in an object of ComputerSystem type
			e.g. CreateReceipt receipt1 = new CreateReceipt(alienwareGamingPC);
*/

package BusinessLayer.DecoratorReceipt;

import java.util.ArrayList;
// !!!! NEED TO INCLUDE IMPORT PATH WHERE COMPONENT AND COMPUTER SYSTEM CLASSES ARE LOCATED !!!! 

public class CreateReceipt {

	public CreateReceipt(ComputerSystem computerSystem) {
		
		// Create heading section of receipt
		Receipt headerReceipt = new ThankYouReceipt(new HeaderReceipt(new BasicReceipt()));
		System.out.println(headerReceipt.printReceipt());

		// Create purchased products section of receipt
		System.out.println("\nDetails of your Computer System purchase:");
		ArrayList<Component> computerComponents = computerSystem.getComponents();
		double totalCost = 0.0;
		for(Component component : computerComponents) {
			System.out.println(component.getTypeOfComponent() + "\t\u20ac" + component.getPrice() + "\t" + component.getComponentName());
			totalCost += component.getPrice();
		}
		System.out.println("\nTotal Cost:\t\u20ac" + totalCost);
		
		// Create footing section of receipt
		Receipt shippingReceipt = new FooterReceipt(new BasicReceipt());
		System.out.println(shippingReceipt.printReceipt());
	}
}
