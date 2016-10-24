package DataLayer;

import java.util.ArrayList;

public class DataControl {
	
	public final static String aComponentFile = "ComponentList.txt";
	
public static ArrayList<String> getUniqueComponentTypes() throws FileNotFoundException {
		
		File componentFile = new File(aComponentFile);
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
			case "Keyboard":
				Keyboard keyboardComponent = component.getKeyboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Integer.parseInt(pieceOfLine[2]), Double.parseDouble(pieceOfLine[3]), pieceOfLine[4], pieceOfLine[5], 
						Boolean.parseBoolean(pieceOfLine[6]));
				componentList.add(keyboardComponent);
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
		ArrayList<String> uniqueComponentArrayList = new ArrayList<String>();
		
		for (int i = 0; i < componentList.size(); i++) {
			if (!(uniqueComponentArrayList.contains(componentList.get(i).getTypeOfComponent())))
				uniqueComponentArrayList.add(componentList.get(i).getTypeOfComponent());
		}
		
		return uniqueComponentArrayList;
	}
	
	}
	
	public static ArrayList<Component> getComponentTypeList(String componentType) {
		//Filled with factory stuff
		//Method will take in param of component type e.g. CPU
		//Factory stuff will search txt files for products matching CPU
		//Create ArrayList of Component type filled with all CPUs
		//Return ArrayList
		File componentFile = new File("ComponentList.txt");
		FactoryDesignPattern component = new FactoryDesignPattern();
		ArrayList<Component> componentList = new ArrayList<Component>();
		Scanner reader = new Scanner(componentFile);
		while(reader.hasNextLine()){
			String LineFromFile = reader.nextLine();
			String[] pieceOfLine = LineFromFile.split(",");
			if (componentType == pieceOfLine[4]) {
				switch(componentType){
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
				case "Keyboard":
					Keyboard keyboardComponent = component.getCPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Integer.parseInt(pieceOfLine[2]), Double.parseDouble(pieceOfLine[3]), pieceOfLine[4], pieceOfLine[5], 
							Boolean.parseBoolean(pieceOfLine[6]));
					componentList.add(keyboardComponent);
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
			
		}
		reader.close();
		return componentList;
	}
	
	public void writeNewComponentToFile(String details) throws FileNotFoundException {
		
		int nextID = checkNextAvailableId(componentFile);
		String lineToAppend =  nextID + ", " + details + "\n";
		try {
		    Files.write(Paths.get(componentFile), lineToAppend.getBytes(), StandardOpenOption.APPEND);
		}
		catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
	
	public int checkNextAvailableId(String textFileName) throws FileNotFoundException {
		int nextAvailableId = 0;
		
		File searchTextFile = new File(textFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			if (Integer.parseInt(splitLineFromFile[0]) > nextAvailableId) 
				nextAvailableId = Integer.parseInt(splitLineFromFile[0]);
		}
		lineIn.close();
		nextAvailableId++;
		return nextAvailableId;
	}
}
