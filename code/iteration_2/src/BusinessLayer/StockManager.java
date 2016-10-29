package BusinessLayer;

import BusinessLayer.CommandProduct.DecreaseStock;
import BusinessLayer.CommandProduct.Stock;
import BusinessLayer.CompositeProduct.ComputerSystem;

public class StockManager {
	public static void decrementStock(ComputerSystem computerSystem){
		Stock stock = new Stock();
		int length = computerSystem.getComponents().size();
		for(int i = 0;i < length;i++) {
			DecreaseStock decrease = new DecreaseStock(computerSystem.getChildAtIndex(i));
	      	stock.takeOrder(decrease);
		}
	}
}
