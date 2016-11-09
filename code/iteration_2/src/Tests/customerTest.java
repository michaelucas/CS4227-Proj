package Tests;

import BusinessLayer.CompositeProduct.CPU;
import BusinessLayer.CompositeProduct.ComputerSystem;
import BusinessLayer.CompositeProduct.GPU;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class customerTest {

	@Test
	public void checkComposite() {
		int compSysId = (int) new Date().getTime();
		int cpuId = (int) new Date().getTime();
		int gpuId = (int) new Date().getTime();
		ComputerSystem testSystem = new ComputerSystem(compSysId, "TestSystem", "ComputerSystem" , "Windows", 123.00);
		CPU testCPU = new CPU(cpuId, "testCPU", 120.00, "CPU","Series 1" , "12Pin", 0.111);
		GPU testGPU = new GPU(gpuId, "testGPU", 120.00, "GPU", "4gb", 4, 12);
		testSystem.addComponent(testCPU);
		testSystem.addComponent(testGPU);
		double compSysPrice = testSystem.getPrice();
		assertEquals(240.00, compSysPrice, 0);
	}

}
