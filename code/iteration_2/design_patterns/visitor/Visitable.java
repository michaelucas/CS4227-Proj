/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

public interface Visitable {
	
	public void accept(Visitor visitor);
}