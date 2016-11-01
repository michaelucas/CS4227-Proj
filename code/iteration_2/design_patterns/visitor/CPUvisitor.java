/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

public class CPUvisitor implements VisitableElement {
	
	private double price;
	private double weight;
	
	CPUvisitor(double price, double weight) {
		this.price = price;
		this.weight = weight;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getWeight() {
		return weight;
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
}