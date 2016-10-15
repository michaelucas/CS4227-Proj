public class ThankYouReceipt extends ReceiptDecorator {
	
	public ThankYouReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		return super.printReceipt() + " Thank you ";
	}
}
