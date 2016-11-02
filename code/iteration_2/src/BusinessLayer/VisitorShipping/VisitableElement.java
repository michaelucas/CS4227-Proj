/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - Visitor Design Pattern
	
	Usage: 
*/

package BusinessLayer.VisitorShipping;

public interface VisitableElement {

	public void accept(Visitor visitor);
}