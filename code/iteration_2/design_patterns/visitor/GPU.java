/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

public class GPU implements VisitableElement {

    private double price;
    private double weight;

    public GPU(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {      
        return price;        
    }

    public double getWeight() {
        return weight;
    }
}