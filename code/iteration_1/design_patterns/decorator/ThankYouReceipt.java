public class ThankYouReceipt extends ReceiptDecorator {
	
	public ThankYouReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		//return "DCM Computing\nThank you for shopping with us!\nPlease do so again.";
		return super.printReceipt() + " Thank you ";
	}
}
