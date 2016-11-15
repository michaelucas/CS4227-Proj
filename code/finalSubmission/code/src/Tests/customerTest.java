package Tests;

import BusinessLayer.CompositeProduct.CPU;
import BusinessLayer.CompositeProduct.ComputerSystem;
import BusinessLayer.CompositeProduct.GPU;
import BusinessLayer.DecoratorReceipt.CreateReceipt;
import BusinessLayer.VisitorShipping.ShippingVisitor;
import BusinessLayer.VisitorShipping.VisitableElement;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class customerTest {
	int compSysId = (int) new Date().getTime();
	int cpuId = (int) new Date().getTime();
	int gpuId = (int) new Date().getTime();
	ComputerSystem testSystem = new ComputerSystem(compSysId, "TestSystem", "ComputerSystem" , "Windows", 123.00);
	CPU testCPU = new CPU(cpuId, "testCPU", 120.00, "CPU","Series 1" , "12Pin", 100000.111);
	GPU testGPU = new GPU(gpuId, "testGPU", 20.00, "GPU", "4gb", 4, 12);

	@Test
	public void testComposite() {
		testSystem.addComponent(testCPU);
		testSystem.addComponent(testGPU);
		double compSysPrice = testSystem.getPrice();
		assertEquals(140.00, compSysPrice, 0);
	}

	@Test
	public void testReceipt() {
		testSystem.addComponent(testCPU);
		testSystem.addComponent(testGPU);
		CreateReceipt receipt1 = new CreateReceipt(testSystem);
		System.out.println(receipt1.getReceipt());
		String expectOutput = "CPU" + "\t\u20ac" + "120.0" + "\t" + "testCPU" + "\n";
		String expectOutput2 = "GPU" + "\t\u20ac" + "20.0" + "\t" + "testGPU" + "\n";
		assertThat(receipt1.getReceipt(), CoreMatchers.containsString(expectOutput));
		assertThat(receipt1.getReceipt(), CoreMatchers.containsString(expectOutput2));
	}

	@Test
	public void testVisitor() {
		List<VisitableElement> cartItems = new ArrayList<>();;
		cartItems.add(testCPU);
		cartItems.add(testGPU);
		ShippingVisitor shippingVisitor = new ShippingVisitor();

		for (VisitableElement item: cartItems)
			item.accept(shippingVisitor);

		double shippingCostTotal = shippingVisitor.getTotalShipping();
		assertEquals(36, shippingCostTotal, 0.0);
	}
}
