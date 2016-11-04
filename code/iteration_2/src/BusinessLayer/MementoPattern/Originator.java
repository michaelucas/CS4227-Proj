package BusinessLayer.MementoPattern;

import BusinessLayer.CompositeProduct.*;

public class Originator {

	private ComputerSystem computerSystem;
	
	public void set(ComputerSystem computerSystem) {
		this.computerSystem = computerSystem;
	}
	
	public Memento storeInMemento() {
		return new Memento(computerSystem);
	}
	
	public ComputerSystem restoreFromMemento(Memento memento) {
		computerSystem = memento.getComputerSystem();
		
		return computerSystem;
	}
}
