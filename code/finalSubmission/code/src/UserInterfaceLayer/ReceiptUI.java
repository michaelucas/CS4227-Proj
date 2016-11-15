/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - Receipt/Decorator Pattern UI
	
	Usage: 
*/

package UserInterfaceLayer;

import BusinessLayer.DecoratorReceipt.CreateReceipt;
import BusinessLayer.CompositeProduct.*;

public class ReceiptUI {

	public ReceiptUI(ComputerSystem computerSystem) {
		CreateReceipt receipt1 = new CreateReceipt(computerSystem);
		System.out.println(receipt1.getReceipt());
	}
}
