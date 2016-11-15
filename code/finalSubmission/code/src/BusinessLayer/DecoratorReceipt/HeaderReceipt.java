/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - Receipt/Decorator Pattern Classes
	
	Usage: 
*/

package BusinessLayer.DecoratorReceipt;

public class HeaderReceipt extends ReceiptDecorator {
	
	public HeaderReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		return super.printReceipt() + " The Computer Shop ";
	}
}
