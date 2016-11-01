/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

public class PostageVisitor implements Visitor {
	
	private double totalPostageForCart;
	
	public void visit(CPUvisitor cpuVisitor) {
		
		if(cpuVisitor.getPrice() < 10.0) {
			totalPostageForCart += cpuVisitor.getWeight() * 2;
		}
	}
	
	public double getTotalPostage() {
		return totalPostageForCart;
	}
}