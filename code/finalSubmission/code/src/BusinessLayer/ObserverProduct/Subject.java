package BusinessLayer.ObserverProduct;

public interface Subject {

	public void registerObserver(Observer O);
	public void notifyObservers();
}
