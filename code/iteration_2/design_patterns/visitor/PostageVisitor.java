/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

public class PostageVisitor implements Visitor {
	
	@Override
	public double visit(CPUvisitor cpuVisitor) {
		
		double cost = cpuVisitor.getPrice()*cpuVisitor.getWeight();
		return cost;
	}
}