package BusinessLayer.CommandProduct;
import BusinessLayer.CompositeProduct.*;

public class DecreaseStock implements Order {

	private Part part;

	public DecreaseStock(Part part){
		this.part = part;
	}

	public void execute() {
		part.decrementStock();
	}
}
