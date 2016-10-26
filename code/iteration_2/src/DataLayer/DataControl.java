package DataLayer;

import java.util.ArrayList;

import BusinessLayer.CompositeProduct.*;
import BusinessLayer.FactoryProduct.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class DataControl {

	public final static String componentFileName = "ComponentList.txt";
	public final static String stockFileName = "StockList.txt";

	public static ArrayList<String> getUniqueComponentTypes() throws FileNotFoundException {

		File componentFile = new File(componentFileName);
		FactoryDesignPattern component = new FactoryDesignPattern();
		ArrayList<Component> componentList = new ArrayList<Component>();
		Scanner reader = new Scanner(componentFile);
		while(reader.hasNextLine()){
			String LineFromFile = reader.nextLine();
			String[] pieceOfLine = LineFromFile.split(",");

			switch(pieceOfLine[4]){
			case "CPU":
				CPU cpuComponent = component.getCPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						pieceOfLine[5]);
				componentList.add(cpuComponent);
				break;
			case "GPU":
				GPU gpuComponent = component.getGPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						Integer.parseInt(pieceOfLine[5]));
				componentList.add(gpuComponent);
				break;
			case "Keyboard":
				Keyboard keyboardComponent = component.getKeyboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						Boolean.parseBoolean(pieceOfLine[5]));
				componentList.add(keyboardComponent);
				break;
			case "MemoryDrive":
				MemoryDrive memoryComponent = component.getMemoryDrive(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
						Boolean.parseBoolean(pieceOfLine[5]));
				componentList.add(memoryComponent);
				break;
			case "Monitor":
				Monitor monitorComponent = component.getMonitor(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						Boolean.parseBoolean(pieceOfLine[5]), Boolean.parseBoolean(pieceOfLine[6]));
				componentList.add(monitorComponent);
				break;
			case "Motherboard":
				Motherboard motherboardComponent = component.getMotherboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4],
						pieceOfLine[5], pieceOfLine[6]);
				componentList.add(motherboardComponent);
				break;
			case "Mouse":
				Mouse mouseComponent = component.getMouse(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
						Boolean.parseBoolean(pieceOfLine[5]), Boolean.parseBoolean(pieceOfLine[6]));
				componentList.add(mouseComponent);
				break;
			case "RAM":
				RAM ramComponent = component.getRAM(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
						pieceOfLine[5]);
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


	public static int getStockByComponentName(String compName) throws FileNotFoundException {
		File componentFile = new File(stockFileName);
		int amountOfItemsInStock = 0;
		Scanner reader = new Scanner(componentFile);
		while(reader.hasNextLine()){
			String LineFromFile = reader.nextLine();
			String[] pieceOfLine = LineFromFile.split(",");

			if(compName.matches(pieceOfLine[0])){
				amountOfItemsInStock = Integer.parseInt(pieceOfLine[1]);
			}
		}
		reader.close();
		return amountOfItemsInStock;
	}


	public static ArrayList<Component> getComponentTypeList(String componentType) throws FileNotFoundException {
		//Filled with factory stuff
		//Method will take in param of component type e.g. CPU
		//Factory stuff will search txt files for products matching CPU
		//Create ArrayList of Component type filled with all CPUs
		//Return ArrayList
		File componentFile = new File(componentFileName);
		FactoryDesignPattern component = new FactoryDesignPattern();
		ArrayList<Component> componentList = new ArrayList<Component>();
		Scanner reader = new Scanner(componentFile);
		while(reader.hasNextLine()){
			String LineFromFile = reader.nextLine();
			String[] pieceOfLine = LineFromFile.split(",");

			if (componentType.equals(pieceOfLine[3])) {
				switch(componentType){
				case "CPU":
					CPU cpuComponent = component.getCPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
							pieceOfLine[5]);
					componentList.add(cpuComponent);
					break;
				case "GPU":
					GPU gpuComponent = component.getGPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
							Integer.parseInt(pieceOfLine[5]));
					componentList.add(gpuComponent);
					break;
				case "Keyboard":
					Keyboard keyboardComponent = component.getKeyboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
							Boolean.parseBoolean(pieceOfLine[5]));
					componentList.add(keyboardComponent);
					break;
				case "MemoryDrive":
					MemoryDrive memoryComponent = component.getMemoryDrive(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
							Boolean.parseBoolean(pieceOfLine[5]));
					componentList.add(memoryComponent);
					break;
				case "Monitor":
					Monitor monitorComponent = component.getMonitor(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
							Boolean.parseBoolean(pieceOfLine[5]), Boolean.parseBoolean(pieceOfLine[6]));
					componentList.add(monitorComponent);
					break;
				case "Motherboard":
					Motherboard motherboardComponent = component.getMotherboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4],
							pieceOfLine[5], pieceOfLine[6]);
					componentList.add(motherboardComponent);
					break;
				case "Mouse":
					Mouse mouseComponent = component.getMouse(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
							Boolean.parseBoolean(pieceOfLine[5]), Boolean.parseBoolean(pieceOfLine[6]));
					componentList.add(mouseComponent);
					break;
				case "RAM":
					RAM ramComponent = component.getRAM(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
							pieceOfLine[5]);
					componentList.add(ramComponent);
					break;
				}
			}

		}
		reader.close();
		return componentList;
	}

	public static void writeNewComponentToFile(String details) throws FileNotFoundException {

		int nextID = checkNextAvailableId(componentFileName);
		String lineToAppend =  nextID + ", " + details + "\n";
		try {
			Files.write(Paths.get(componentFileName), lineToAppend.getBytes(), StandardOpenOption.APPEND);
		}
		catch (IOException e) {
			//exception handling left as an exercise for the reader
		}
	}


	public static int checkNextAvailableId(String textFileName) throws FileNotFoundException {
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

	public static void editComponent(Part part) throws IOException {
		int id = part.getComponentId();

		File searchTextFile = new File(componentFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		int length;
		ArrayList<String[]> fileList = new ArrayList<String[]>();

		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			length = splitLineFromFile.length;
			fileList.add(splitLineFromFile);

		}


		FileWriter writer = new FileWriter(componentFileName); 

		for(int k = 0;k < fileList.size();k++) {
			for(int u = 0;u < fileList.get(k).length;u++) {
				writer.write(fileList.get(k)[u]);
				if(!(u == fileList.get(k).length)) {
					writer.write(",");
				}

			}
			writer.write("\n");

		}
		writer.close();

	}

	public static void rewriteComponentFile(ArrayList<Component> components) throws IOException{
		FileWriter writer = new FileWriter(componentFileName);
		PrintWriter out = new PrintWriter(writer);
		Component c;
		for(int i =0; i < components.size();i++){
			System.out.println("[info]  : ------ Rewriting File (DataControl) ------");
			c= components.get(i);
			out.println(c.toString());
		}
		out.close();
	}

	public static ArrayList<Component> factoryDesignPattern() throws FileNotFoundException{
		File componentFile = new File(componentFileName);
		FactoryDesignPattern component = new FactoryDesignPattern();
		ArrayList<Component> componentList = new ArrayList<Component>();
		Scanner reader = new Scanner(componentFile);
		while(reader.hasNextLine()){
			String LineFromFile = reader.nextLine();
			String[] pieceOfLine = LineFromFile.split(",");
			switch(pieceOfLine[4]){
			case "CPU":
				CPU cpuComponent = component.getCPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						pieceOfLine[5]);
				componentList.add(cpuComponent);
				break;
			case "GPU":
				GPU gpuComponent = component.getGPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						Integer.parseInt(pieceOfLine[5]));
				componentList.add(gpuComponent);
				break;
			case "Keyboard":
				Keyboard keyboardComponent = component.getKeyboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						Boolean.parseBoolean(pieceOfLine[5]));
				componentList.add(keyboardComponent);
				break;
			case "MemoryDrive":
				MemoryDrive memoryComponent = component.getMemoryDrive(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
						Boolean.parseBoolean(pieceOfLine[5]));
				componentList.add(memoryComponent);
				break;
			case "Monitor":
				Monitor monitorComponent = component.getMonitor(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						Boolean.parseBoolean(pieceOfLine[5]), Boolean.parseBoolean(pieceOfLine[6]));
				componentList.add(monitorComponent);
				break;
			case "Motherboard":
				Motherboard motherboardComponent = component.getMotherboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4],
						pieceOfLine[5], pieceOfLine[6]);
				componentList.add(motherboardComponent);
				break;
			case "Mouse":
				Mouse mouseComponent = component.getMouse(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
						Boolean.parseBoolean(pieceOfLine[5]), Boolean.parseBoolean(pieceOfLine[6]));
				componentList.add(mouseComponent);
				break;
			case "RAM":
				RAM ramComponent = component.getRAM(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
						pieceOfLine[5]);
				componentList.add(ramComponent);
				break;
			}

		}
		reader.close();

		return componentList;

	}
}
