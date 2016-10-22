/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - Receipt/Decorator Pattern Classes
	
	Usage: Call this Constructor passing in an object of ComputerSystem type
			e.g. CreateReceipt receipt1 = new CreateReceipt(alienwareGamingPC);
*/

package BusinessLayer.DecoratorReceipt;

import java.util.ArrayList;
import BusinessLayer.CompositeProduct.*;

public class CreateReceipt {

	private ComputerSystem computerSystem;
	
	public CreateReceipt(ComputerSystem computerSystem) {
		
		this.computerSystem = computerSystem;
	}
	
	public static String getReceipt() {
		
		String returnString = "";
		
		// Create heading section of receipt
		Receipt headerReceipt = new ThankYouReceipt(new HeaderReceipt(new BasicReceipt()));
		returnString = headerReceipt.printReceipt();

		// Create purchased products section of receipt
		returnString += "\nDetails of your Computer System purchase:";
		ArrayList<Component> computerComponents = computerSystem.getComponents();
		double totalCost = 0.0;
		for(Component component : computerComponents) {
			returnString += component.getTypeOfComponent() + "\t\u20ac" + component.getPrice() + "\t" + component.getComponentName();
			totalCost += component.getPrice();
		}
		returnString += "\nTotal Cost:\t\u20ac" + totalCost;
		
		// Create footing section of receipt
		Receipt shippingReceipt = new FooterReceipt(new BasicReceipt());
		returnString += shippingReceipt.printReceipt();
		
		return returnString;
	}
}
