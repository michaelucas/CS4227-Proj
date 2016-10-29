package BusinessLayer;

import java.io.FileNotFoundException;

import BusinessLayer.CommandProduct.DecreaseStock;
import BusinessLayer.CommandProduct.Stock;
import BusinessLayer.CompositeProduct.ComputerSystem;
import DataLayer.DataControl;

public class StockManager {
	public static void decrementStock(ComputerSystem computerSystem){
		Stock stock = new Stock();
		int length = computerSystem.getComponents().size();
		for(int i = 0;i < length;i++) {
			DecreaseStock decrease = new DecreaseStock(computerSystem.getChildAtIndex(i));
	      	stock.takeOrder(decrease);
		}
	}
	public static boolean checkIsComponentInStock(String componentName) throws FileNotFoundException {
		int currentStock = DataControl.getStockByComponentName(componentName);
		if (currentStock > 0 ){
			return true;
		}
		else {
			return false;
		}
	}
}
