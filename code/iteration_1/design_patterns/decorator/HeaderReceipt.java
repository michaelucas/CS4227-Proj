public class HeaderReceipt extends ReceiptDecorator {
	
	public HeaderReceipt(Receipt receipt) {
		super(receipt);
	}

	@Override
	public String printReceipt() {
		//return "DCM Computing\nThank you for shopping with us!\nPlease do so again.";
		return super.printReceipt() + " Header ";
	}
}
