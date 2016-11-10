/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - Receipt/Decorator Pattern Classes
	
	Usage: 
*/

package BusinessLayer.DecoratorReceipt;

public abstract class ReceiptDecorator extends Receipt {

	private Receipt receipt;
	
	public ReceiptDecorator(Receipt receipt) {
		this.receipt = receipt;
	}
	
	@Override
	public String printReceipt() {
		if (receipt != null) 
			return receipt.printReceipt(); 
		return null;
	}
}