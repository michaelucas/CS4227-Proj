package Observer;

import java.io.IOException;

public class AddNewProduct {
	
	private String name;
	private double cost;
	private int stock;
	private Product p;
	
	public String process(String inName , double inCost , int inStock) throws IOException{
		name = inName;
		cost = inCost;
		stock = inStock;
		
		p = new Product(name , cost , stock);
		return this.name;
		
	}
	
	public void addProduct(String details , productList pl) throws IOException{
		DataControl dataControl = new DataControl();
		p.registerObserver(pl);
		dataControl.writeNewProductToFile(name, cost, stock, true, false, details);
		p.notifyObservers();
	}

}
