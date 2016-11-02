/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

import java.util.ArrayList;
import java.util.List;

public class runVisitor {
	
	public static void main(String [] args) {
		
		List<VisitableElement> items = new ArrayList<VisitableElement>();
        items.add(new CPU(8, 10));
        items.add(new GPU(5, 5));
        
        PostageVisitor postage = new PostageVisitor();         
        for(VisitableElement item: items) {
            item.accept(postage);
        }
        double total = postage.getTotalPostage();
        System.out.println(total);     	
	}
}
