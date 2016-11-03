package BusinessLayer.MementoPattern;

import java.util.*;

public class Caretaker {

	ArrayList<Memento> computerList = new ArrayList<Memento>();
	
	public void addMemento(Memento m) {
		computerList.add(m);
	}
	
	public Memento getMemento(int index) {
		return computerList.get(index);
	}
	public int getLength() {
		return computerList.size();
	}
}
