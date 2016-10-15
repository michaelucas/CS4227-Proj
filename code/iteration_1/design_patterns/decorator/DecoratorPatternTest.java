public class DecoratorPatternTest {

	public static void main(String [] args) {
		Receipt headerReceipt = new ThankYouReceipt(new HeaderReceipt(new BasicReceipt()));
		System.out.println(headerReceipt.printReceipt());

		Receipt shippingReceipt = new ShippingReceipt(new BasicReceipt());
		System.out.println(shippingReceipt.printReceipt());
	}
}