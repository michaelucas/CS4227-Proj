/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - Visitor Design Pattern
	
	Usage: 
*/

package BusinessLayer.VisitorShipping;
import BusinessLayer.CompositeProduct.*;

public interface Visitor {
	
	public void visit(CPU cpu);
	public void visit(GPU gpu);
	public void visit(Keyboard keyboard);
	public void visit(MemoryDrive memoryDrive);
	public void visit(Monitor monitor);
	public void visit(Motherboard motherboard);
	public void visit(Mouse mouse);
	public void visit(RAM ram);
}