/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

public class PostageVisitor implements Visitor {
    
    private double totalPostageForCart;     

    public double getTotalPostage() {
        return totalPostageForCart;    
    }

    @Override
    public void visit(CPU cpu) {
        if(cpu.getPrice() < 10.0) {
            totalPostageForCart += cpu.getWeight() * 2;  
        }
    }

    @Override
    public void visit(GPU gpu) {
        if(gpu.getPrice() < 10.0) {
            totalPostageForCart += gpu.getWeight() * 3;  
        }
    }
} 