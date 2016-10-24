package UserInterfaceLayer;
import java.util.*;
import java.io.*;

import BusinessLayer.*;

public class mainProgramUI {
	
	public mainProgramUI() throws FileNotFoundException{
		
		String typeOfUser = "";
		boolean isValidChoice = false;
		Scanner input = new Scanner(System.in);
		while(!isValidChoice){
		System.out.println("Are you a customer or admin? ");
		typeOfUser = input.nextLine();
		if(typeOfUser.equalsIgnoreCase("Customer")){
			ProductList customerChoice = new ProductList();
		}
		else if(typeOfUser.equalsIgnoreCase("Admin")){
			AddComponent adminOptions = new AddComponent();
			
		}
		else
			System.out.println("Not a valid choice");
		}
	
	}

}
