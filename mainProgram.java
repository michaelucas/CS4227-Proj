public class mainProgram {
	public static void main(String args []) {
		ComputerSystem alienwareGamingPC = new ComputerSystem(13141252, "AlienWare Laptop", 6, 1200.66, "Windows");
		CPU leafCPU = new CPU(13141253, "Intel i7 4670K", 6, "Series 12", "12PinSocketType");
		GPU leafGPU = new GPU(13141254, "Radeon R280x",6, "3333Mhrz", 4);
		Keyboard leafKeyBoard = new Keyboard(13141255, "Logitech 1770m", 6, "NormalKeySwitchType", true);
		MemoryDrive leafMemoryDrive = new MemoryDrive(13141256, "Crucial SSD", 6, 1000, false);
		Motherboard leafMotherboard = new Motherboard(13141257, "ROF266", 6, "12PinSocketType", "Series 12", "3333Mhrz");
		RAM leafRam = new RAM(13141258, "RipTide" , 7, 16, "Dual");
		Mouse leafMouse = new Mouse(13141259, "Razor Deathador", 8, 900, true, true);
		Monitor leafMonitor = new Monitor(13141260, "Samsung 22\" v1.1.1"  , 8, "1200 x 600", false, false);
		alienwareGamingPC.addComponent(leafCPU);
		alienwareGamingPC.addComponent(leafGPU);
		alienwareGamingPC.addComponent(leafKeyBoard);
		alienwareGamingPC.addComponent(leafMemoryDrive);
		alienwareGamingPC.addComponent(leafMotherboard);
		alienwareGamingPC.addComponent(leafMouse);
		alienwareGamingPC.addComponent(leafRam);
		alienwareGamingPC.addComponent(leafMonitor);
		alienwareGamingPC.removeComponent(alienwareGamingPC.getChildAtIndex(3));

		/*int amountOfComps =  alienwareGamingPC.getComponents().size();
		for(int i =0; i< amountOfComps; i++) {
			String compName = alienwareGamingPC.getChildAtIndex(i).getComponentName();
			System.out.println(compName);
		}


		CPU cpuPart = (CPU) alienwareGamingPC.getChildAtIndex(0);
		System.out.println(cpuPart.getComponentDetails());
		
		GPU gpuPart = (GPU) alienwareGamingPC.getChildAtIndex(1);
		System.out.println(gpuPart.getComponentDetails());
		
		Keyboard keyboardPart = (Keyboard) alienwareGamingPC.getChildAtIndex(2);
		System.out.println(keyboardPart.getComponentDetails());
		String keySwitch = keyboardPart.getKeySwitchType();
		System.out.println(keySwitch);*/

		System.out.println(leafCPU.getComponentName() + "\t\t" + leafCPU.getStock());
		System.out.println(leafGPU.getComponentName() + "\t\t" + leafGPU.getStock());
		System.out.println(leafKeyBoard.getComponentName() + "\t\t" + leafKeyBoard.getStock());
		System.out.println(leafMemoryDrive.getComponentName() + "\t\t" + leafMemoryDrive.getStock());
		System.out.println(leafMotherboard.getComponentName() + "\t\t\t" + leafMotherboard.getStock());
		System.out.println(leafRam.getComponentName() + "\t\t\t" + leafRam.getStock());
		System.out.println(leafMouse.getComponentName() + "\t\t" + leafMouse.getStock());
		System.out.println(leafMonitor.getComponentName() + "\t" + leafMonitor.getStock() + "\n\n\n\n\n");

		IncreaseStock buyStockOrder = new IncreaseStock(leafCPU);
      	DecreaseStock sellStockOrder = new DecreaseStock(leafGPU);

      	Stock stock = new Stock();
      	stock.takeOrder(buyStockOrder);
      	stock.takeOrder(sellStockOrder);

      	stock.placeOrders();

      	System.out.println("\n\n\n\n\n");
      	System.out.println(leafCPU.getComponentName() + "\t\t" + leafCPU.getStock());
      	System.out.println(leafGPU.getComponentName() + "\t\t" + leafGPU.getStock());
	}
}