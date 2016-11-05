/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Test Visitor Design Pattern

	Usage: 
*/

public interface Visitor {
    // second dispatch
    public void visit(CPU cpu);
    public void visit(GPU gpu);
}