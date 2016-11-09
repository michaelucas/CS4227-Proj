package UserInterfaceLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import BusinessLayer.AddComponent;
import BusinessLayer.AdminProductDisplay;
import BusinessLayer.AdminProductList;
import BusinessLayer.CompositeProduct.Component;

public class AdminUI {
	
	private AdminProductList pl;
	private AdminProductDisplay display;
	
	public AdminUI() throws IOException {
		pl = new AdminProductList();
		display = new AdminProductDisplay();
		pl.registerObserver(display);
	}

	public void display() throws IOException{
		
		//v2
		int choice = 1;
		while (choice != 0){
			
			System.out.println(display.getAllDisplay());
			System.out.println("\n\nWould you like to : \n1. Add a new Product\n2. Remove a Product\n0. Exit");
			choice = display.readUserInput();
			
			if(choice == 1){
				addComponent(pl);
			}
			else if(choice == 2){
				removeComponent(pl);
			}
			else if(choice == 3){
				editComponent(pl);
			}
		}
	}
	
	public void addComponent(AdminProductList pl) throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		System.out.println("What type of product do you want to add (GPU,CPU etc.)?");
		String answer = in.nextLine();
		
		try {
			System.out.println(display.addComponent(answer));
			if(!(display.addComponent(answer).equals("Invalid Input")))
				pl.addToFile(in.nextLine());
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void removeComponent(AdminProductList pl) throws IOException{
		System.out.println("Type the number of the product you want to remove");
		int choice = display.readUserInput();
		pl.removeComponent(choice);
	}
}
