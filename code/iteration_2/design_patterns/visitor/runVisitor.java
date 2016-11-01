/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

public class runVisitor {
	
	public static void main(String [] args) {
		
		VisitableElement [] cartItems = new VisitableElement[]{new CPUvisitor(20.99, 0.90)};
		double totalCost = calculatePrice(cartItems);
		System.out.println("Total Cost: " + totalCost);
	}

	private static double calculatePrice(VisitableElement[] cartItems) {

		PostageVisitor visitor = new PostageVisitor();
		double sum = 0.0;
		for (VisitableElement item : cartItems) {
			sum = sum + item.accept(visitor);
		}
		return sum;
	}
}
