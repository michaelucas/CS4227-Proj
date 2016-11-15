package BusinessLayer;

import java.io.FileNotFoundException;

import BusinessLayer.CommandProduct.DecreaseStock;
import BusinessLayer.CommandProduct.Invoker;
import BusinessLayer.CompositeProduct.ComputerSystem;
import DataLayer.DataControl;

public class StockManager {
	
	private StockManager() {
		//Adding private constructor to hide implicit public one
	}
	
	public static void decrementStock(ComputerSystem computerSystem){
		Invoker stock = new Invoker();
		int length = computerSystem.getComponents().size();
		for(int i = 0;i < length;i++) {
			DecreaseStock decrease = new DecreaseStock(computerSystem.getChildAtIndex(i));
	      	stock.takeOrder(decrease);
		}
		stock.placeOrders();
	}
	public static boolean checkIsComponentInStock(String componentName) throws FileNotFoundException {
		
		int currentStock = DataControl.getStockByComponentName(componentName);
		boolean inStock;
		if (currentStock > 0 ){
			inStock = true;
		}
		else {
			inStock = false;
		}
		return inStock;
	}
}
