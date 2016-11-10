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
	
	public static void printOutput(String output) {
		System.out.println(output);
	}
	
	public static String readUserInput() {
		
		Scanner in = new Scanner(System.in);
		
		return  in.nextLine();
	}
}
