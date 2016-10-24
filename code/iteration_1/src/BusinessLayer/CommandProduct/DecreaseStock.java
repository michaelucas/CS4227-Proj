package BusinessLayer.CommandProduct;
import BusinessLayer.CompositeProduct.*;

public class DecreaseStock implements Order {
	   //private Component comp;

		private Part part;

	   public DecreaseStock(Part part){
	      this.part = part;
	   }

	   public void execute() {
	      part.decrementStock();
	   }
}
