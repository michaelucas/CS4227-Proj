package Tests;

import BusinessLayer.CompositeProduct.CPU;
import BusinessLayer.CompositeProduct.ComputerSystem;
import BusinessLayer.CompositeProduct.GPU;
import BusinessLayer.DecoratorReceipt.CreateReceipt;

import static org.junit.Assert.*;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class customerTest {
	int compSysId = (int) new Date().getTime();
	int cpuId = (int) new Date().getTime();
	int gpuId = (int) new Date().getTime();
	ComputerSystem testSystem = new ComputerSystem(compSysId, "TestSystem", "ComputerSystem" , "Windows", 123.00);
	CPU testCPU = new CPU(cpuId, "testCPU", 120.00, "CPU","Series 1" , "12Pin", 0.111);
	GPU testGPU = new GPU(gpuId, "testGPU", 120.00, "GPU", "4gb", 4, 12);
	
	@Test
	public void testComposite() {
		testSystem.addComponent(testCPU);
		testSystem.addComponent(testGPU);
		double compSysPrice = testSystem.getPrice();
		assertEquals(240.00, compSysPrice, 0);
	}
	
	@Test
	public void testReceipt() {
		testSystem.addComponent(testCPU);
		testSystem.addComponent(testGPU);
		CreateReceipt receipt1 = new CreateReceipt(testSystem);
		System.out.println(receipt1.getReceipt());
		String expectOutput = "CPU" + "\t\u20ac" + "120.0" + "\t" + "testCPU" + "\n";
		String expectOutput2 = "GPU" + "\t\u20ac" + "120.0" + "\t" + "testGPU" + "\n";
		assertThat(receipt1.getReceipt(), CoreMatchers.containsString(expectOutput));
		assertThat(receipt1.getReceipt(), CoreMatchers.containsString(expectOutput2));
	}
}
