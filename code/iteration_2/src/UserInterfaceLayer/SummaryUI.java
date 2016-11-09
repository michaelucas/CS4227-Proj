package UserInterfaceLayer;

import java.util.Scanner;

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
			if ("Y".equalsIgnoreCase(userChoice)) {
				correctInput = true;
				continueExecuting = true;
			}
			else if ("N".equalsIgnoreCase(userChoice)) {
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
