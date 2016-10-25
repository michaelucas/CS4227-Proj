package UserInterfaceLayer;
import DataLayer.DataControl;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddComponentUI {
	
	public static void printOutput(String output) {
		System.out.println(output);
	}

	public static int getComponentType() {
		
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
		return (checkedUserChoice - 1);
	}
	
	public static String getComponentSpecs() {
		
		Scanner in = new Scanner(System.in);
		String userInput = in.nextLine();
		return userInput;
	}
}
