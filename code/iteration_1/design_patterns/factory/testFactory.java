package Factory;
import java.io.*;
import java.util.*;

import Component.*;

public class testFactory {

	public static ArrayList<Component> getComponentList() throws IOException {
		
		
		File componentFile = new File("ComponentList.txt");
		FactoryDesignPattern component = new FactoryDesignPattern();
		ArrayList<Component> componentList = new ArrayList<Component>();
		Scanner reader = new Scanner(componentFile);
		while(reader.hasNextLine()){
			String LineFromFile = reader.nextLine();
			String[] pieceOfLine = LineFromFile.split(",");
			switch(pieceOfLine[4]){
			case "CPU":
				CPU cpuComponent = component.getCPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Integer.parseInt(pieceOfLine[2]), Double.parseDouble(pieceOfLine[3]), pieceOfLine[4], pieceOfLine[5], 
						pieceOfLine[6]);
				componentList.add(cpuComponent);
				break;
			case "GPU":
				GPU gpuComponent = component.getGPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Integer.parseInt(pieceOfLine[2]),Double.parseDouble(pieceOfLine[3]), pieceOfLine[4], pieceOfLine[5], 
						Integer.parseInt(pieceOfLine[6]));
				componentList.add(gpuComponent);
				break;
			case "MemoryDrive":
				MemoryDrive memoryComponent = component.getMemoryDrive(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Integer.parseInt(pieceOfLine[2]), Double.parseDouble(pieceOfLine[3]), pieceOfLine[4], Integer.parseInt(pieceOfLine[5]), 
						Boolean.parseBoolean(pieceOfLine[6]));
				componentList.add(memoryComponent);
				break;
			case "Monitor":
				Monitor monitorComponent = component.getMonitor(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Integer.parseInt(pieceOfLine[2]), Double.parseDouble(pieceOfLine[3]), pieceOfLine[4], pieceOfLine[5], 
						Boolean.parseBoolean(pieceOfLine[6]), Boolean.parseBoolean(pieceOfLine[7]));
				componentList.add(monitorComponent);
				break;
			case "Motherboard":
				Motherboard motherboardComponent = component.getMotherboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Integer.parseInt(pieceOfLine[2]), Double.parseDouble(pieceOfLine[3]), pieceOfLine[4], pieceOfLine[5],
						pieceOfLine[6], pieceOfLine[7]);
				componentList.add(motherboardComponent);
				break;
			case "Mouse":
				Mouse mouseComponent = component.getMouse(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Integer.parseInt(pieceOfLine[2]), Double.parseDouble(pieceOfLine[3]), pieceOfLine[4], Integer.parseInt(pieceOfLine[5]), 
						Boolean.parseBoolean(pieceOfLine[6]), Boolean.parseBoolean(pieceOfLine[7]));
				componentList.add(mouseComponent);
				break;
			case "RAM":
				RAM ramComponent = component.getRAM(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Integer.parseInt(pieceOfLine[2]), Double.parseDouble(pieceOfLine[3]), pieceOfLine[4], Integer.parseInt(pieceOfLine[5]), 
						pieceOfLine[6]);
				componentList.add(ramComponent);
				break;
			}
			
		}
		reader.close();

		return componentList;

	}

}
