/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - Receipt/Decorator Pattern UI
	
	Usage: 
*/

package UserInterfaceLayer;

import DecoratorReceipt.CreateReceipt;
// !!!! NEED TO INCLUDE IMPORT PATH WHERE COMPUTER SYSTEM CLASS IS LOCATED !!!!

public class ReceiptUI {

	ReceiptUI(ComputerSystem computerSystem) {
		CreateReceipt receipt1 = new CreateReceipt(computerSystem);
		System.out.println(receipt1.getReceipt());
	}
}
