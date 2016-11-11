//Conor Buggan

package UserInterfaceLayer;
import java.util.*;

import java.io.*;

import BusinessLayer.*;

public class IntroUI {
	
	public IntroUI() throws IOException{
		
		IntroControl intro = new IntroControl();
		intro.setUp();
		
		String typeOfUser = "";
		boolean isValidChoice = false;
		Scanner input = new Scanner(System.in);
		while(!isValidChoice){
			System.out.println("Are you a customer or admin? ");
			typeOfUser = input.nextLine();
			if("Customer".equalsIgnoreCase(typeOfUser)) {
				isValidChoice = true;
				ProductList customerChoice = new ProductList();
			}
			else if ("Admin".equalsIgnoreCase(typeOfUser)) {
				isValidChoice = true;
				AdminUI adminNew = new AdminUI();
				adminNew.display();
				
			}
			else {
				System.out.println("Not a valid choice");
				isValidChoice = false;
			}
		}
	
	}

}
