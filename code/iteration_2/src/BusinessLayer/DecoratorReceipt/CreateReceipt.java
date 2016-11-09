/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - Receipt/Decorator Pattern Classes
	
	Usage: Call this Constructor passing in an object of ComputerSystem type
			e.g. CreateReceipt receipt1 = new CreateReceipt(alienwareGamingPC);
*/

package BusinessLayer.DecoratorReceipt;

import java.text.DecimalFormat;
import java.util.ArrayList;
import BusinessLayer.CompositeProduct.*;

public class CreateReceipt {

	private static ComputerSystem computerSystem;
	
	public CreateReceipt(ComputerSystem computerSystem) {
		
		this.computerSystem = computerSystem;
	}
	
	public static String getReceipt() {
		
		String returnString = "";
		
		// Create heading section of receipt
		Receipt headerReceipt = new ThankYouReceipt(new HeaderReceipt(new BasicReceipt()));
		returnString = headerReceipt.printReceipt();

		// Create purchased products section of receipt
		returnString += "\nDetails of your Computer System purchase:\n";
		ArrayList<Component> computerComponents = computerSystem.getComponents();
		for(Component component : computerComponents) {
			returnString += component.getTypeOfComponent() + "\t\u20ac" + component.getPrice() + "\t" + component.getComponentName() + "\n";
		}
		double totalCost = computerSystem.getPrice();
		returnString += "\nTotal Cost:\t\u20ac" + new DecimalFormat("##.##").format(totalCost);
		
		// Create footing section of receipt
		Receipt shippingReceipt = new FooterReceipt(new BasicReceipt());
		returnString += shippingReceipt.printReceipt();
		
		return returnString;
	}
}
