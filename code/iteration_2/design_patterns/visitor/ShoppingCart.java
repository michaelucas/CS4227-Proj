/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

public class ShoppingCart {
	
	private ArrayList<Visitable> items;
	
	public double calculatePostage() {
		
		PostageVisitor visitor = new PostageVisitor();
		
		for(Visitable item: items) {
			item.accept(visitor);
		}
		double postage = visitor.getTotalPostage();
		
		return postage;
	}
}