package BusinessLayer.ObserverProduct;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ArchitecturalLayer.ContextObject;
import ArchitecturalLayer.Dispatcher;
import BusinessLayer.CompositeProduct.*;
import DataLayer.DataControl;

public class AdminProductList implements Subject {


	private ArrayList<Component> listOfProducts;
	private ArrayList<Observer> observers;
	private Dispatcher dispatcher;
	private static final Logger LOGGER = Logger.getLogger( AdminProductList.class.getName() );

	public AdminProductList() throws FileNotFoundException{
		listOfProducts = new ArrayList<>();
		observers = new ArrayList<>();
		listOfProducts = DataControl.factoryDesignPattern();
		dispatcher = new Dispatcher();
	}	

	public String getAllDisplay() throws FileNotFoundException{
		String display;
		display = "\n\nPlease choose a component for your computer:\n";
		for (int i = 0; i < listOfProducts.size(); i++) {
			display += "\n\nChoice: " + (i + 1) + "\t" + " " + listOfProducts.get(i).getComponentDetails();
		}
		return display;
	}


	public void removeComponent(int choice) throws IOException{
		ContextObject context = new ContextObject("remove" , listOfProducts.get(choice - 1));
		dispatcher.iterate_list(context);
		DataControl.removeStockFromFile(listOfProducts.get(choice-1).getComponentName());
		listOfProducts.remove(choice - 1);
		DataControl.rewriteComponentFile(listOfProducts);
		notifyObservers();
	}


	public void addToFile(String details, int stock) throws FileNotFoundException{
		DataControl.writeNewComponentToFile(details, stock);
		listOfProducts = DataControl.factoryDesignPattern();
		ContextObject c = new ContextObject("add" , listOfProducts.get(listOfProducts.size()-1));
		dispatcher.iterate_list(c);
		notifyObservers();

	}

	public String getCurrentStatus(int choice){
		String status;
		Component c = listOfProducts.get(choice - 1);
		status = "Name\tPrice\tStock\n";
		status += c.getComponentName();
		status += "\t" + c.getPrice();
		return status;
	}

	@Override
	public void registerObserver(Observer O) {
		observers.add(O);

	}

	@Override
	public void notifyObservers() {

		Observer o;
		try {
			for(int i = 0; i < observers.size();i++ )
			{
				o = observers.get(i);
				o.update();
			}
		} catch (Exception e) {
            LOGGER.log(Level.SEVERE, "context", e);
		}
	}


}
