/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

public class CPUvisitor implements Visitable{
	
	private double price;
	private double weight;
	
	public void accept(Visitor vistor) {
		visitor.visit(this);
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getWeight() {
		return weight;
	}
}