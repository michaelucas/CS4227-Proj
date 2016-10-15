public class ShippingReceipt extends ReceiptDecorator {

	public ShippingReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		return super.printReceipt() + " Footer ";
	}
}

