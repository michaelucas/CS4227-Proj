package Observer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class DataControl {
	
	public final String productFileName = "productList.txt";
	
	
	public void writeNewProductToFile(String name, double cost, int stock, boolean isActive, boolean isDiscount, String details) throws FileNotFoundException {
		
		String lineToAppend =  name + "," + stock + "," + cost + "\n";
		try {
		    Files.write(Paths.get(productFileName), lineToAppend.getBytes(), StandardOpenOption.APPEND);
		}
		catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
	
	public void rewriteProductFile(Product product) throws IOException{
		ArrayList<Product> x = factoryDesignPatternSearch();
		for(int i =0;i < x.size();i++){
			if(x.get(i).getProductName().equals(product.getProductName()) ){
				x.remove(i);
				x.add(i , product);
			}
		}
		File file = new File(productFileName);
		FileWriter writer = new FileWriter(file);
		PrintWriter out = new PrintWriter(writer);
		Product p;
		for(int i =0; i < x.size();i++){
			System.out.println("[info]  : ------ Rewriting File (DataControl) ------");
			p=  x.get(i);
			out.println(p.toString());
		}
		out.close();
	}
	
	public void rewriteProductFile(ArrayList<Product> products) throws IOException{
		File file = new File(productFileName);
		FileWriter writer = new FileWriter(file);
		PrintWriter out = new PrintWriter(writer);
		Product p;
		for(int i =0; i < products.size();i++){
			System.out.println("[info]  : ------ Rewriting File (DataControl) ------");
			p= products.get(i);
			out.println(p.toString());
		}
		out.close();
	}
	
	public ArrayList<Product> factoryDesignPatternSearch() throws FileNotFoundException {
		File searchTextFile = new File(productFileName);
		ArrayList<Product> allFileProducts = new ArrayList<Product>();
		Scanner lineIn = new Scanner(searchTextFile); 
		while(lineIn.hasNextLine()){
			String aLineFromFile = lineIn.nextLine();
			String[] splitLineFromFile = aLineFromFile.split(",");
			// Check there is stock
			Product p = new Product(splitLineFromFile[0],Double.parseDouble(splitLineFromFile[2]) , Integer.parseInt(splitLineFromFile[1]));
			allFileProducts.add(p);
		}
		lineIn.close();
		return allFileProducts;
	}

}
