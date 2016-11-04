package UserInterfaceLayer;
import java.util.*;

import ArchitecturalLayer.Dispatcher;
import ArchitecturalLayer.Interceptor;
import ArchitecturalLayer.infoRequest;

import java.io.*;

import BusinessLayer.*;

public class IntroUI {
	
	public IntroUI() throws IOException{
		
		Interceptor myInterceptor = new Interceptor () {
			public void onPreMarshalRequest(infoRequest context) {
				System.out.print(context.getType());
			}

		};
		Dispatcher dispatcher = new Dispatcher();
		dispatcher.register(myInterceptor);
		
		String typeOfUser = "";
		boolean isValidChoice = false;
		Scanner input = new Scanner(System.in);
		while(!isValidChoice){
		System.out.println("Are you a customer or admin? ");
		typeOfUser = input.nextLine();
		if(typeOfUser.equalsIgnoreCase("Customer")){
			ProductList customerChoice = new ProductList();
			System.exit(0);
		}
		else if(typeOfUser.equalsIgnoreCase("Admin")){
			//AddComponent adminOptions = new AddComponent();
			AdminUI adminNew = new AdminUI();
			adminNew.display();
			System.exit(0);
			
		}
		else
			System.out.println("Not a valid choice");
		}
	
	}

}
