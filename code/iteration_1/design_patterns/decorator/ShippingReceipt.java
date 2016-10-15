public class ShippingReceipt extends ReceiptDecorator {

	public ShippingReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		//return "Added shipping cost of \u20ac5.00";
		return super.printReceipt() + " Footer ";
	}
}

