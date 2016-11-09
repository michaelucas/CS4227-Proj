package UserInterfaceLayer;

import java.util.Scanner;

public class AddComponentUI {
	
	private AddComponentUI() {
		// Adding private constructor to avoid public implicit one
	}
	
	public static void printOutput(String output) {
		System.out.println(output);
	}

	public static int getComponentType() {
		
		boolean acceptableInput = false;
		int checkedUserChoice;
		String uncheckedUserChoice = "";
		Scanner in = new Scanner(System.in);
		
		while (!acceptableInput) {
			
			System.out.println("\nEnter choice number: ");
			uncheckedUserChoice = in.nextLine();
			if (uncheckedUserChoice.matches("[0-9]+"))
				acceptableInput = true;
			else
				System.out.println("Error: Invalid. Must be a number");
		}
		
		checkedUserChoice = Integer.parseInt(uncheckedUserChoice);
		return checkedUserChoice - 1;
	}
	
	public static String getComponentSpecs() {
		
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
}
