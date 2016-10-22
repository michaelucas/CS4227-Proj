/*
	Author: Conor Duggan
	Email: 13127004@studentmail.ul.ie
	
	Project Title: CS4227 Project - ProductList UI
	
	Usage: 
*/

package UserInterfaceLayer;

import java.util.ArrayList;
import java.util.Scanner;
import BusinessLayer.CompositeProduct.*;

public class ProductListUI {
	
	ProductListUI() {
		
	}

	public static void printOutList(ArrayList<Component> listArray) {
		
		System.out.println("\n\nPlease choose a component for your computer:\n");
		for (int i = 0; i < listArray.size(); i++) {
			System.out.println("Choice: " + (i + 1) + "\t" + " " + listArray.get(i).getComponentDetails());
		}
	}
	
	public static int readUserInput() {
		
		boolean acceptableInput = false;
		int checkedUserChoice;
		String uncheckedUserChoice = "";
		Scanner in = new Scanner(System.in);
		
		while (false == acceptableInput) {
			
			System.out.println("\nEnter choice number: ");
			uncheckedUserChoice = in.nextLine();
			if (uncheckedUserChoice.matches("[0-9]+"))
				acceptableInput = true;
			else
				System.out.println("Error: Invalid. Must be a number");
		}
		
		checkedUserChoice = Integer.parseInt(uncheckedUserChoice);
		return checkedUserChoice;
	}
}