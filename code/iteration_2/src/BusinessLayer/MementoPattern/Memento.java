package BusinessLayer.MementoPattern;
import BusinessLayer.CompositeProduct.*;

public class Memento {
	private ComputerSystem computerSystem;
	
	public Memento(ComputerSystem computerSystem) {
		this.computerSystem = computerSystem;
	}
	
	public ComputerSystem getComputerSystem() {
		return computerSystem;
	}
}
