/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - Receipt/Decorator Pattern Classes
	
	Usage: 
*/

package BusinessLayer.DecoratorReceipt;

public class BasicReceipt extends Receipt {

	@Override
	public String printReceipt() {
		return "\nNote:";
	}
}

