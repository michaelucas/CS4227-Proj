package UserInterfaceLayer;

import java.util.ArrayList;
import java.util.Scanner;

import BusinessLayer.CompositeProduct.*;

public class SummaryUI {

	SummaryUI(String summary) {
	}
	public static void printOutSummary(String summary) {

		System.out.println(summary);
		
	}
	
	public static boolean checkToContinue(){
		System.out.println("Type \"Y\" to coninue\nOr \"N\" if you want to try choosing the computer systems components again");
		Scanner in = new Scanner(System.in);
		boolean correctInput = false;
		boolean continueExecuting = false;
		while(!correctInput) {
			String userChoice;
			userChoice = in.nextLine();
			if(userChoice.equalsIgnoreCase("Y")) {
				correctInput = true;
				continueExecuting = true;
			}
			else if (userChoice.equalsIgnoreCase("N")) {
				correctInput = true;
				continueExecuting = false;
			}
			else {
				System.out.println("\nEnter either Y or N\n");
			}
		}
		return continueExecuting;
	}
}
