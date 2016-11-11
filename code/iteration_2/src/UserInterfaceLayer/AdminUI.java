package UserInterfaceLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import BusinessLayer.AdminProductDisplay;
import BusinessLayer.AdminProductList;

public class AdminUI {

	private AdminProductList pl;
	private AdminProductDisplay display;
	private static final Logger LOGGER = Logger.getLogger( AdminProductList.class.getName() );

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
		}
	}

	public void addComponent(AdminProductList pl) throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		System.out.println("What type of product do you want to add (GPU,CPU etc.)?");
		String answer = in.nextLine();
		String componentToAdd = null;

		try {
			System.out.println(display.addComponent(answer));
			if(!("Invalid Input".equals(display.addComponent(answer))))
				componentToAdd = in.nextLine();
			System.out.println("How many are in Stock?");
			int stock = Integer.parseInt(in.nextLine());
			pl.addToFile(componentToAdd, stock);

		} catch (Exception e) {
            LOGGER.log(Level.SEVERE, "context", e);
		}
	}

	public void removeComponent(AdminProductList pl) throws IOException{
		System.out.println("Type the number of the product you want to remove");
		int choice = display.readUserInput();
		pl.removeComponent(choice);
	}
}
