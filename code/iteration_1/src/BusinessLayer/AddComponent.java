package BusinessLayer;
import java.io.*;
import UserInterfaceLayer.AddComponentUI;

public class AddComponent {

	public void addComponent(String type) throws FileNotFoundException{
		
		AddComponentUI aComponent = new AddComponentUI();
		switch(type){
		case "CPU":
			aComponent.addCPUComponent(type);
			break;
		case "GPU":
			aComponent.addGPUComponent(type);
			break;
		case "Keyboard":
			aComponent.addKeyboardComponent(type);
			break;
		case "MemoryDrive":
			aComponent.addMemoryDriveComponent(type);
			break;
		case "Monitor":
			aComponent.addMonitorComponent(type);
			break;
		case "Motherboard":
			aComponent.addMotherboardComponent(type);
			break;
		case "Mouse":
			aComponent.addMouseComponent(type);
			break;
		case "RAM":
			aComponent.addRAMComponent(type);
			break;
		
		}
	}
}
