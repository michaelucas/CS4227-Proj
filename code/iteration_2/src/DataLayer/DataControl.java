package DataLayer;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import BusinessLayer.StockManager;
import BusinessLayer.CompositeProduct.*;
import BusinessLayer.FactoryProduct.*;
import BusinessLayer.ObserverProduct.AdminProductList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class DataControl {

	public static final String componentFileName = "code/iteration_2/ComponentList.txt";
	public static final String stockFileName = "code/iteration_2/StockList.txt";
	private static final Logger LOGGER = Logger.getLogger( AdminProductList.class.getName() );
	
	private DataControl() {
		//Adding private constructor to avoid implicit public one
	}

	public static ArrayList<String> getUniqueComponentTypes() throws FileNotFoundException {

		File componentFile = new File(componentFileName);
		FactoryDesignPattern component = new FactoryDesignPattern();
		ArrayList<Component> componentList = new ArrayList<>();
		Scanner reader = new Scanner(componentFile);
		while(reader.hasNextLine()){
			String LineFromFile = reader.nextLine();
			String[] pieceOfLine = LineFromFile.split(",");

			switch(pieceOfLine[4]){
			case "CPU":
				CPU cpuComponent = component.getCPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						pieceOfLine[5], Double.parseDouble(pieceOfLine[6]));
				componentList.add(cpuComponent);
				break;
			case "GPU":
				GPU gpuComponent = component.getGPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						Integer.parseInt(pieceOfLine[5]), Double.parseDouble(pieceOfLine[6]));
				componentList.add(gpuComponent);
				break;
			case "Keyboard":
				Keyboard keyboardComponent = component.getKeyboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						Boolean.parseBoolean(pieceOfLine[5]), Double.parseDouble(pieceOfLine[6]));
				componentList.add(keyboardComponent);
				break;
			case "MemoryDrive":
				MemoryDrive memoryComponent = component.getMemoryDrive(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
						Boolean.parseBoolean(pieceOfLine[5]), Double.parseDouble(pieceOfLine[6]));
				componentList.add(memoryComponent);
				break;
			case "Monitor":
				Monitor monitorComponent = component.getMonitor(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4], 
						Boolean.parseBoolean(pieceOfLine[5]), Boolean.parseBoolean(pieceOfLine[6]), Double.parseDouble(pieceOfLine[7]));
				componentList.add(monitorComponent);
				break;
			case "Motherboard":
				Motherboard motherboardComponent = component.getMotherboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[4],
						pieceOfLine[5], pieceOfLine[6], Double.parseDouble(pieceOfLine[7]));
				componentList.add(motherboardComponent);
				break;
			case "Mouse":
				Mouse mouseComponent = component.getMouse(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
						Boolean.parseBoolean(pieceOfLine[5]), Boolean.parseBoolean(pieceOfLine[6]), Double.parseDouble(pieceOfLine[7]));
				componentList.add(mouseComponent);
				break;
			case "RAM":
				RAM ramComponent = component.getRAM(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[4]), 
						pieceOfLine[5], Double.parseDouble(pieceOfLine[6]));
				componentList.add(ramComponent);
				break;
			default:
				System.out.println("Invalid Component type. DataControl.java -> Method: getUniqueComponentTypes()");
				break;
			}

		}
		reader.close();
		ArrayList<String> uniqueComponentArrayList = new ArrayList<>();

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
		ArrayList<Component> componentList = new ArrayList<>();
		Scanner reader = new Scanner(componentFile);
		while(reader.hasNextLine()){
			String LineFromFile = reader.nextLine();
			String[] pieceOfLine = LineFromFile.split(",");
			if (StockManager.checkIsComponentInStock(pieceOfLine[1]) && componentType.equals(pieceOfLine[3])) {
				switch(componentType){
				case "CPU":
					CPU cpuComponent = component.getCPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[5], 
							pieceOfLine[6], Double.parseDouble(pieceOfLine[4]));
					componentList.add(cpuComponent);
					break;
				case "GPU":
					GPU gpuComponent = component.getGPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[5], 
							Integer.parseInt(pieceOfLine[6]), Double.parseDouble(pieceOfLine[4]));
					componentList.add(gpuComponent);
					break;
				case "Keyboard":
					Keyboard keyboardComponent = component.getKeyboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[5], 
							Boolean.parseBoolean(pieceOfLine[6]), Double.parseDouble(pieceOfLine[4]));
					componentList.add(keyboardComponent);
					break;
				case "MemoryDrive":
					MemoryDrive memoryComponent = component.getMemoryDrive(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[5]), 
							Boolean.parseBoolean(pieceOfLine[6]), Double.parseDouble(pieceOfLine[4]));
					componentList.add(memoryComponent);
					break;
				case "Monitor":
					Monitor monitorComponent = component.getMonitor(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[5], 
							Boolean.parseBoolean(pieceOfLine[6]), Boolean.parseBoolean(pieceOfLine[7]), Double.parseDouble(pieceOfLine[4]));
					componentList.add(monitorComponent);
					break;
				case "Motherboard":
					Motherboard motherboardComponent = component.getMotherboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[5],
							pieceOfLine[6], pieceOfLine[7], Double.parseDouble(pieceOfLine[4]));
					componentList.add(motherboardComponent);
					break;
				case "Mouse":
					Mouse mouseComponent = component.getMouse(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[5]), 
							Boolean.parseBoolean(pieceOfLine[6]), Boolean.parseBoolean(pieceOfLine[7]), Double.parseDouble(pieceOfLine[4]));
					componentList.add(mouseComponent);
					break;
				case "RAM":
					RAM ramComponent = component.getRAM(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[5]), 
							pieceOfLine[6], Double.parseDouble(pieceOfLine[4]));
					componentList.add(ramComponent);
					break;
				default:
					System.out.println("Invalid Component type. DataControl.java -> Method: getComponentTypeList()");
					break;
				}
			}

		}
		reader.close();
		return componentList;
	}

	public static void writeNewComponentToFile(String details, int stock) throws FileNotFoundException {
		
		int nextID = checkNextAvailableId(componentFileName);
		String lineToAppendToComponentFile =  nextID + ",";
		String [] detailsSplit = details.split(",");
		for(int i=0;i < detailsSplit.length;i++){
			lineToAppendToComponentFile += detailsSplit[i].trim() + ",";
		}
		String lineToAppendToStockFile = detailsSplit[0] + "," + stock + "\n";
		lineToAppendToComponentFile += "\n";
		try {
			Files.write(Paths.get(componentFileName), lineToAppendToComponentFile.getBytes(), StandardOpenOption.APPEND);
		}
		catch (Exception e) {
            LOGGER.log(Level.SEVERE, "context", e);
		}
		try {
			Files.write(Paths.get(stockFileName),  lineToAppendToStockFile.getBytes(), StandardOpenOption.APPEND);
		}
		catch (Exception e) {
            LOGGER.log(Level.SEVERE, "context", e);
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

		File searchTextFile = new File(componentFileName);
		Scanner lineIn = new Scanner(searchTextFile);
		ArrayList<String[]> fileList = new ArrayList<>();

		while (lineIn.hasNextLine()) {
			String aLineFromFile = lineIn.nextLine();
			String [] splitLineFromFile = aLineFromFile.split(",");
			fileList.add(splitLineFromFile);
		}


		FileWriter writer = new FileWriter(componentFileName); 

		for(int k = 0;k < fileList.size();k++) {
			for(int u = 0;u < fileList.get(k).length;u++) {
				writer.write(fileList.get(k)[u]);
				if (u != fileList.get(k).length) {
					writer.write(",");
				}

			}
			writer.write("\n");

		}
		lineIn.close();
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
		ArrayList<Component> componentList = new ArrayList<>();
		Scanner reader = new Scanner(componentFile);
		while(reader.hasNextLine()){
			String LineFromFile = reader.nextLine();
			String[] pieceOfLine = LineFromFile.split(",");
			switch(pieceOfLine[3]){
				case "CPU":
					CPU cpuComponent = component.getCPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[5], 
							pieceOfLine[6], Double.parseDouble(pieceOfLine[4]));
					componentList.add(cpuComponent);
					break;
				case "GPU":
					GPU gpuComponent = component.getGPU(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[5], 
							Integer.parseInt(pieceOfLine[6]), Double.parseDouble(pieceOfLine[4]));
					componentList.add(gpuComponent);
					break;
				case "Keyboard":
					Keyboard keyboardComponent = component.getKeyboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[5], 
							Boolean.parseBoolean(pieceOfLine[6]), Double.parseDouble(pieceOfLine[4]));
					componentList.add(keyboardComponent);
					break;
				case "MemoryDrive":
					MemoryDrive memoryComponent = component.getMemoryDrive(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[5]), 
							Boolean.parseBoolean(pieceOfLine[6]), Double.parseDouble(pieceOfLine[4]));
					componentList.add(memoryComponent);
					break;
				case "Monitor":
					Monitor monitorComponent = component.getMonitor(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[5], 
							Boolean.parseBoolean(pieceOfLine[6]), Boolean.parseBoolean(pieceOfLine[7]), Double.parseDouble(pieceOfLine[4]));
					componentList.add(monitorComponent);
					break;
				case "Motherboard":
					Motherboard motherboardComponent = component.getMotherboard(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], pieceOfLine[5],
							pieceOfLine[6], pieceOfLine[7], Double.parseDouble(pieceOfLine[4]));
					componentList.add(motherboardComponent);
					break;
				case "Mouse":
					Mouse mouseComponent = component.getMouse(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[5]), 
							Boolean.parseBoolean(pieceOfLine[6]), Boolean.parseBoolean(pieceOfLine[7]), Double.parseDouble(pieceOfLine[4]));
					componentList.add(mouseComponent);
					break;
				case "RAM":
					RAM ramComponent = component.getRAM(Integer.parseInt(pieceOfLine[0]), pieceOfLine[1], Double.parseDouble(pieceOfLine[2]), pieceOfLine[3], Integer.parseInt(pieceOfLine[5]), 
							pieceOfLine[6], Double.parseDouble(pieceOfLine[4]));
					componentList.add(ramComponent);
					break;
				default:
					System.out.println("Invalid Component Type. DataControl.java -> Method: factoryDesignPattern()");
					break;
			}

		}
		reader.close();

		return componentList;

	}


	public static void adjustStock(String componentName, String incOrDec) throws IOException {
		File searchTextFile = new File(stockFileName);

		//Construct the new file that will later be renamed to the original filename.
		File tempFile = new File(searchTextFile.getAbsolutePath() + ".tmp");

		BufferedReader br = new BufferedReader(new FileReader(searchTextFile));
		PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		String line = null;

		//Read from the original file and write to the new
		//unless content matches data to be removed.
		while ((line = br.readLine()) != null) {
			String aLineFromFile = line;
			String [] splitLineFromFile = aLineFromFile.split(",");

			if (!splitLineFromFile[0].equals(componentName)) {

				pw.println(line);
				pw.flush();
			}
			else {
				int stock = Integer.parseInt(splitLineFromFile[1]);
				if (incOrDec.matches("increment")){
					stock++;
				}
				else if(incOrDec.matches("decrement")){
					stock--;
				}
				pw.println(componentName + "," + stock + ",");
				pw.flush();

			}
		}
		pw.close();
		br.close();

		//Delete the original file
		if (!searchTextFile.delete()) {
			System.out.println("Could not delete file");
			return;
		}

		//Rename the new file to the filename the original file had.
		if (!tempFile.renameTo(searchTextFile))
			System.out.println("Could not rename file");
	}
	
	public static void removeStockFromFile(String componentName) throws IOException{
		File searchTextFile = new File(stockFileName);

		//Construct the new file that will later be renamed to the original filename.
		File tempFile = new File(searchTextFile.getAbsolutePath() + ".tmp");

		BufferedReader br = new BufferedReader(new FileReader(searchTextFile));
		PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		String line = null;

		//Read from the original file and write to the new
		//unless content matches data to be removed.
		while ((line = br.readLine()) != null) {
			String aLineFromFile = line;
			String [] splitLineFromFile = aLineFromFile.split(",");

			if (!splitLineFromFile[0].equals(componentName)) {

				pw.println(line);
				pw.flush();
			}
			
		}
		pw.close();
		br.close();

		//Delete the original file
		if (!searchTextFile.delete()) {
			System.out.println("Could not delete file");
			return;
		}

		//Rename the new file to the filename the original file had.
		if (!tempFile.renameTo(searchTextFile))
			System.out.println("Could not rename file");
	}
}
