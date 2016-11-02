/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie

	Project Title: CS4227 Project - Visitor Design Pattern

	Usage: 
*/

package BusinessLayer.VisitorShipping;

import BusinessLayer.CompositeProduct.*;

public class ShippingVisitor implements Visitor {

	private double totalShippingForCart;     

	public double getTotalShipping() {
		return totalShippingForCart;    
	}

	@Override
	public void visit(CPU cpu) {
		if(cpu.getPrice() < 10.0) {
			//totalShippingForCart += cpu.getWeight() * 2;  
		}
	}

	@Override
	public void visit(GPU gpu) {
		if(gpu.getPrice() < 10.0) {
			//totalShippingForCart += gpu.getWeight() * 3;  
		}
	}

	@Override
	public void visit(Keyboard keyboard) {
		if(keyboard.getPrice() < 10.0) {
			//totalShippingForCart += keyboard.getWeight() * 2;  
		}
	}

	@Override
	public void visit(MemoryDrive memoryDrive) {
		if(memoryDrive.getPrice() < 10.0) {
			//totalShippingForCart += memoryDrive.getWeight() * 2;  
		}
	}

	@Override
	public void visit(Monitor monitor) {
		if(monitor.getPrice() < 10.0) {
			//totalShippingForCart += monitor.getWeight() * 2;  
		}
	}

	@Override
	public void visit(Motherboard motherboard) {
		if(motherboard.getPrice() < 10.0) {
			//totalShippingForCart += motherboard.getWeight() * 2;  
		}
	}

	@Override
	public void visit(Mouse mouse) {
		if(mouse.getPrice() < 10.0) {
			//totalShippingForCart += mouse.getWeight() * 2;  
		}
	}

	@Override
	public void visit(RAM ram) {
		if(ram.getPrice() < 10.0) {
			//totalShippingForCart += ram.getWeight() * 2;  
		}
	}
} 