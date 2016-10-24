package BusinessLayer.CommandProduct;
import BusinessLayer.CompositeProduct.*;

public class IncreaseStock implements Order {
	   //private Component comp;

		private Part part;

	   public IncreaseStock(Component part){
	      this.part = part;
	   }

	   public void execute() {
	      part.addStock();
	   }
}
