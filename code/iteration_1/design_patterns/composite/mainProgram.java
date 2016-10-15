package compositeSoFar;
public class mainProgram {
	public static void main(String args []) {
		ComputerSystem alienwareGamingPC = new ComputerSystem(13141252, "AlienWare Laptop", 6, "ComputerSystem", 1200.66, "Windows" );
		CPU leafCPU = new CPU(13141253, "Intel i7 4670K", 6, "CPU", "Series 12", "12PinSocketType");
		GPU leafGPU = new GPU(13141254, "Radeon R280x",6, "GPU" , "3333Mhrz", 4);
		Keyboard leafKeyBoard = new Keyboard(13141255, "Logitech 1770m", 6, "Keyboard" , "NormalKeySwitchType", true);
		MemoryDrive leafMemoryDrive = new MemoryDrive(13141256, "Crucial SSD", 6, "MemoryDrive" ,1000, false);
		Motherboard leafMotherboard = new Motherboard(13141257, "ROF266", 6, "Motherboard" ,"12PinSocketType", "Series 12", "3333Mhrz");
		RAM leafRam = new RAM(13141258, "RipTide", 7, "RAM", 16, "Dual");
		Mouse leafMouse = new Mouse(13141259, "Razor Deathador", 8, "Mouse" , 900, true, true);
		Monitor leafMonitor = new Monitor(13141260, "Samsung 22\" v1.1.1", 8, "Monitor" ,"1200 x 600", false, false);
		alienwareGamingPC.addComponent(leafCPU);
		alienwareGamingPC.addComponent(leafGPU);
		alienwareGamingPC.addComponent(leafKeyBoard);
		alienwareGamingPC.addComponent(leafMemoryDrive);
		alienwareGamingPC.addComponent(leafMotherboard);
		alienwareGamingPC.addComponent(leafMouse);
		alienwareGamingPC.addComponent(leafRam);
		alienwareGamingPC.addComponent(leafMonitor);
		alienwareGamingPC.removeComponent(alienwareGamingPC.getChildAtIndex(3));
		

		int amountOfComps =  alienwareGamingPC.getComponents().size();
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
		System.out.println(keySwitch);
		
		

		

		
		
	}
}